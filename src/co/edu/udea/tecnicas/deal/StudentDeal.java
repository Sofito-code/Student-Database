package co.edu.udea.tecnicas.deal;

import java.util.List;

import co.edu.udea.tecnicas.dao.impl.StudentList;
import co.edu.udea.tecnicas.dao.impl.StudentFile;
import co.edu.udea.tecnicas.dao.StudentDAO;
import co.edu.udea.tecnicas.model.StudentDTO;


public class StudentDeal {
    StudentDAO studentDAO = new StudentFile("1");
    StudentDAO studentList = new StudentList();
	
    public boolean store(StudentDTO student){
        if(student.getGroup().equals("N")){
            return false;
        }
        boolean answer2 = studentList.store(student);
        boolean answer1 = studentDAO.store(student);
        return answer1==answer2;

    }

    public List<StudentDTO> listing(){
        return studentDAO.listing();
    }
//falta

}
