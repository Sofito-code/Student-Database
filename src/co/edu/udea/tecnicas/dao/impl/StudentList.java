package co.edu.udea.tecnicas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.tecnicas.model.StudentDTO;
import co.edu.udea.tecnicas.dao.StudentDAO;

public class StudentList implements StudentDAO 
{
    public final List<StudentDTO> studentBD;

    public StudentList() {
        studentBD = new ArrayList<StudentDTO>();
    }   

    /**
     * Create
     * @param student
     * @return 
     */
    @Override
    public boolean store(StudentDTO student) {
        
        return studentBD.add(student);
    }

    @Override
    public StudentDTO consult(String id) {
        for (StudentDTO student : studentBD) {
            if (student.getId().equals(id))
                return student;
        }
        return null;
    }

    @Override
    public List<StudentDTO> listing() {
        List<StudentDTO> students = new ArrayList<StudentDTO>();
        for (StudentDTO student : studentBD) {
                students.add(student);
        }
        return students;
    }

    @Override
    public boolean delete(String identificacion) {
        for (StudentDTO student : studentBD) {
            if (student.getId().equals(identificacion)) {
                studentBD.remove(student);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(StudentDTO data) {
        for (StudentDTO estudiante : studentBD) {
            if (estudiante.getId().equals(data.getId())){
                studentBD.remove(estudiante);
                studentBD.add(data);
                return true;
            }
        }
        return false;
    }
}
