package co.edu.udea.tecnicas.deal;

import co.edu.udea.tecnicas.model.StudentDTO;
import javax.swing.JOptionPane;


public class StudentDeal {
    public boolean store(StudentDTO student) {
        
        boolean pass = true;
        if(student.getNames().length()<3){
            JOptionPane.showMessageDialog(null, "Los nombres deben ser de 3 letras o más");
            pass=false;
        }
        if(student.getLastNames().length()<3){
            JOptionPane.showMessageDialog(null, "Los apellidos deben ser de 3 letras o más");
            pass=false;
        }
        if(isNumeric(student.getYearsOld())){
            if(Integer.parseInt(student.getYearsOld())>13){
            JOptionPane.showMessageDialog(null, "El estudiante supera la edad permitida");
            pass=false;
            }            
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor ingrese una edad valida (numerica)");
            pass=false;    
        }
        char men = 'h';
        char women = 'm';
        if(student.getGender()!=men && student.getGender()!= women){
            JOptionPane.showMessageDialog(null, "El genero debe ser F o M");
            pass=false;
        }
        if(!isNumeric(student.getId())){
            JOptionPane.showMessageDialog(null, "Por favor ingrese una identificación valida (numerica)");
            pass=false;
        }
        if(!isNumeric(student.getGroup())){
            JOptionPane.showMessageDialog(null, "Por favor ingrese un grupo valido (numerica), escoja un grupo del 1 al 5");
            pass=false;
        }        
        return pass;
    }
    
    
    public boolean read(String id) {
        if(!isNumeric(id))
        {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una identificación valida (numerica)");
            return false;
        }
        else{            
            return true;
        }        
    }    
    
    public boolean delete(String identificacion) {
        boolean answer1 = read(identificacion);
        if(answer1){
            int a = JOptionPane.showConfirmDialog(null, "¿seguro que desea eliminar este alumno o alumna?",
                "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            System.out.println(a);
            if(a==0) return true;
            else{
                return false;
            }            
        }
        else{
            JOptionPane.showMessageDialog(null, "No se encontro el estudiante en la matricula.");
            return false;
        }
    }
    
    public boolean update(StudentDTO estudiante) {
        return store(estudiante);
    }   
        
    public boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return true;
	} 
        catch (NumberFormatException e){
            return false;
	}
    } 

}
