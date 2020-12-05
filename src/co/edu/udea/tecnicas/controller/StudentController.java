package co.edu.udea.tecnicas.controller;

import java.util.List;

import co.edu.udea.tecnicas.model.StudentDTO;
import co.edu.udea.tecnicas.deal.StudentDeal;

public class StudentController {
    StudentDeal studentDeal = new StudentDeal();

    public boolean store(StudentDTO student) { // pudo haber sido
                                                                                                              // bot�n
        // Validar que los campos est�n correctos
        boolean answer = studentDeal.store(student);
        return answer;
    }


    public List<StudentDTO> listing(){
            return studentDeal.listing();
    }

}
