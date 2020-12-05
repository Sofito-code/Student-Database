package co.edu.udea.tecnicas.dao;

import java.util.List;

import co.edu.udea.tecnicas.model.StudentDTO;

public interface StudentDAO 
{	
    public boolean store(StudentDTO student);
    public StudentDTO consult(String id);
    public List<StudentDTO> listing();
    public boolean delete(String id);
    public boolean update(StudentDTO student);
}
