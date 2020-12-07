package co.edu.udea.tecnicas.dao;

import java.util.List;

import co.edu.udea.tecnicas.model.StudentDTO;
import java.io.IOException;

public interface StudentDAO 
{	
    public boolean store(StudentDTO student);
    public StudentDTO read(String id) throws IOException;
    public List<StudentDTO> listing();
    public boolean delete(String id);
    public boolean update(StudentDTO student)throws IOException;    
    public void setList(List<StudentDTO> list);
}
