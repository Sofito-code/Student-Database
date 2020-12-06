package co.edu.udea.tecnicas.controller;

import java.util.List;

import co.edu.udea.tecnicas.model.StudentDTO;
import co.edu.udea.tecnicas.deal.StudentDeal;

public class StudentController {
    StudentDeal studentDeal = new StudentDeal();

    public boolean store(StudentDTO student) { // pudo haber sido botón
        // Validar que los campos est�n correctos
        Helper h = new Helper();
        if(!(h.isNumeric(student.getId()) && h.isNumeric(student.getGroup()))){
            return false;
        }
        if(h.isNumeric(student.getYearsOld())){
            if(Integer.parseInt(student.getYearsOld())>13){
               return false;
            }
        }
        else{
            return false;
        }        
        if(student.getGroup().equals("N")){
            return false;
        }
        if(student.getNames().length()<3 || student.getLastNames().length()<3){
            return false;
        }
        
        boolean answer = studentDeal.store(student);
        return answer;
    }


    public List<StudentDTO> listing(){
            return studentDeal.listing();
    }

}
