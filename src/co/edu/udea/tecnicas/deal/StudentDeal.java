package co.edu.udea.tecnicas.deal;

import java.util.List;

import co.edu.udea.tecnicas.dao.impl.StudentFile;
import co.edu.udea.tecnicas.dao.StudentDAO;
import co.edu.udea.tecnicas.model.StudentDTO;


public class StudentDeal {
	StudentDAO studentDAO = new StudentFile();
	
	public boolean store(StudentDTO student){
		//Validaciones de negocio y se ejecutar�an los casos de uso de la aplicaci�n
		boolean answer = studentDAO.store(student);
		return answer;
                
	}
	
	public List<StudentDTO> listing(){
		return studentDAO.listing();
	}
//falta

}
