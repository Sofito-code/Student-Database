package co.edu.udea.tecnicas.controller;

import co.edu.udea.tecnicas.dao.StudentDAO;
import co.edu.udea.tecnicas.dao.impl.StudentFile;
import co.edu.udea.tecnicas.dao.impl.StudentList;
import co.edu.udea.tecnicas.deal.StudentDeal;
import java.util.List;
import co.edu.udea.tecnicas.model.StudentDTO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StudentController {
    
    StudentFile firstFile = new StudentFile("Primero");
    StudentDAO first = new StudentList();
    StudentFile secondFile = new StudentFile("Segundo");
    StudentDAO second = new StudentList();
    StudentFile thirdFile = new StudentFile("Tercero");
    StudentDAO third = new StudentList();
    StudentFile fourthFile = new StudentFile("Cuarto");
    StudentDAO fourth = new StudentList();
    StudentFile fifthFile = new StudentFile("Quinto");
    StudentDAO fifth = new StudentList();
    StudentFile allStudentFile = new StudentFile("Todos los estudiantes");
    StudentDAO allStudents = new StudentList();
    StudentDeal deal = new StudentDeal();
    
    public boolean store(StudentDTO student) throws IOException{
        StudentDTO studentRequest = allStudents.read(student.getId());
        if(studentRequest == null){
            boolean answer2 = false;
            boolean answer1 = false;
            if(!deal.store(student)) return false;        
            switch(student.getGroup()){
                case "1":
                    answer1 = first.store(student);
                    answer2 = firstFile.store(student);
                    if(answer1){
                        allStudents.store(student);
                    }                
                    if(answer2){
                        allStudentFile.store(student);
                    }                
                    break;
                case "2":
                    answer1 = second.store(student);
                    answer2 = secondFile.store(student);
                    if(answer1){
                        allStudents.store(student);
                    }                
                    if(answer2){
                        allStudentFile.store(student);
                    } 
                    break;
                case "3":
                    answer1 = third.store(student);
                    answer2 = thirdFile.store(student);
                    if(answer1){
                        allStudents.store(student);
                    }                
                    if(answer2){
                        allStudentFile.store(student);
                    } 
                    break;
                case "4":
                    answer1 = fourth.store(student);
                    answer2 = fourthFile.store(student);
                    if(answer1){
                        allStudents.store(student);
                    }                
                    if(answer2){
                        allStudentFile.store(student);
                    } 
                    break;
                case "5":
                    answer1 = fifth.store(student);
                    answer2 = fifthFile.store(student);
                    if(answer1){
                        allStudents.store(student);
                    }                
                    if(answer2){
                        allStudentFile.store(student);
                    } 
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No se pudo asignar el grupo");
            }
            if(answer1==true&&answer2==true){
                JOptionPane.showMessageDialog(null, "El estudiante se matriculo correctamente");                
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "El estudiante con identificacion " + student.getId() + " ya fue reguistrado");
        return false;       
    }
    /**
     * index
     * @param studentList
     * @return 
     */
    public List<StudentDTO> listing(StudentDAO studentList){
        return studentList.listing();
    }
    public static void main(String[] args) throws IOException {
        StudentController c = new StudentController();
        c.readAllGroups();
        
        System.out.println(c.search("1234"));        
    }
    public void readAllGroups(){
        try {
            first.setList(firstFile.read());
            second.setList(secondFile.read());
            third.setList(thirdFile.read());
            fourth.setList(fourthFile.read());
            fifth.setList(fifthFile.read());
            allStudents.setList(allStudentFile.read());
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean update(StudentDTO student) throws IOException{
        StudentDTO studentRequest = allStudents.read(student.getId());
        if(studentRequest != null){
            boolean answer1 = false;
            boolean answer2 = false;
            if(!deal.update(student)) return false;
            if(student.getGroup().equalsIgnoreCase(studentRequest.getGroup())){
                switch(student.getGroup()){
                    case "1":
                        answer1 = first.update(student);
                        answer2 = firstFile.update(first.listing());
                        if(answer1){
                            allStudents.update(student);
                        }                
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }                
                        break;
                    case "2":
                        answer1 = second.update(student);
                        answer2 = secondFile.update(second.listing());
                        if(answer1){
                            allStudents.update(student);
                        }                
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }   
                        break;
                    case "3":
                        answer1 = third.update(student);
                        answer2 = thirdFile.update(third.listing());
                        if(answer1){
                            allStudents.update(student);
                        }                
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }   
                        break;
                    case "4":
                        answer1 = fourth.update(student);
                        answer2 = fourthFile.update(fourth.listing());
                        if(answer1){
                            allStudents.update(student);
                        }                
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }  
                        break;
                    case "5":
                        answer1 = fifth.update(student);
                        answer2 = fifthFile.update(fifth.listing());
                        if(answer1){
                            allStudents.update(student);
                        }                
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }  
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No se pudo asignar el grupo");
                }
                return answer1==answer2;
            }
            else{
                switch(studentRequest.getGroup()){
                    case "1":
                        answer1 = delete(studentRequest.getId(),false);
                        answer2 = store(student);
                        break;
                    case "2":
                        answer1 = delete(studentRequest.getId(),false);
                        answer2 = store(student);  
                        break;
                    case "3":
                        answer1 = delete(studentRequest.getId(),false);
                        answer2 = store(student);  
                        break;
                    case "4":
                        answer1 = delete(studentRequest.getId(),false);
                        answer2 = store(student); 
                        break;
                    case "5":
                        answer1 = delete(studentRequest.getId(),false);
                        answer2 = store(student); 
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No se pudo asignar el grupo");
                }
                if(answer1==true&&answer2==true){
                    JOptionPane.showMessageDialog(null, "El estudiante se actualizo correctamente");                
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "El estudiante no se pudo actualizar");
                    return false;
                }
            }
            //preguntar si esta en el mismo grupo
            //sisi entonces solo actualiza los datos, reeescribe archivos
            
            //y sino entonces lo ambia de lista, reescrive archivos
        }     
        return false;
    }
    
    public boolean delete(String id, boolean validation) throws IOException{
        StudentDTO studentRequest = allStudents.read(id);        
        boolean answer1 = false;
        boolean answer2 = false;
        if(validation){
            if(!deal.delete(id)){ 
                JOptionPane.showMessageDialog(null, "El estudiante no fue eliminado");
                return false;
            }
        }        
        if(studentRequest != null){
            switch(studentRequest.getGroup()){
                case "1":
                        answer1 = first.delete(studentRequest.getId());
                        if(answer1){
                            allStudents.delete(studentRequest.getId());
                        }
                        answer2 = firstFile.update(first.listing());                        
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }
                        break;
                    case "2":
                        answer1 = second.delete(studentRequest.getId());
                        answer2 = secondFile.update(second.listing());
                        if(answer1){
                            allStudents.delete(studentRequest.getId());
                        }
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }                        
                        break;
                    case "3":
                        answer1 = third.delete(studentRequest.getId());
                        answer2 = thirdFile.update(third.listing());
                        if(answer1){
                            allStudents.delete(studentRequest.getId());
                        }
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }                        
                        break;
                    case "4":
                        answer1 = fourth.delete(studentRequest.getId());
                        answer2 = fourthFile.update(fourth.listing());
                        if(answer1){
                            allStudents.delete(studentRequest.getId());
                        }
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }
                        break;
                    case "5":
                        answer1 = fifth.delete(studentRequest.getId());
                        answer2 = fifthFile.update(fifth.listing());
                        if(answer1){
                            allStudents.delete(studentRequest.getId());
                        }
                        if(answer2){
                            allStudentFile.update(allStudents.listing());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No se pudo aliminar el estudiente");
            }
            if(validation){
                if(answer1==true&&answer2==true){
                    JOptionPane.showMessageDialog(null, "El estudiante se elimino correctamente");                
                    return true;
                }
                else{
                JOptionPane.showMessageDialog(null, "ocurrio un error al intentar eliminar el estudiante, contacte con soporte técnico");
                System.out.println("lista:" + answer1);
                System.out.println("archivo:" + answer2);
                return false;
            }
            }            
             
        }
        else{
            JOptionPane.showMessageDialog(null, "El estudiante no existe");
            return false;
        }
        JOptionPane.showMessageDialog(null, "El estudiante no fue eliminado");
        return false;
    }
   
    public StudentDTO search(String id) throws IOException {
        return allStudents.read(id);       
    }
    
    public StudentDAO getFirst() {
        return first;
    }

    public StudentDAO getSecond() {
        return second;
    }

    public StudentDAO getThird() {
        return third;
    }

    public StudentDAO getFourth() {
        return fourth;
    }
    
    public StudentDAO getFifth() {
        return fifth;
    }

    public StudentDAO getAllStudents() {
        return allStudents;
    }
    
}
