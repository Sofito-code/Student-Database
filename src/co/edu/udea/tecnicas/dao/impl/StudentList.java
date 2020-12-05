package co.edu.udea.tecnicas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.tecnicas.model.StudentDTO;
import co.edu.udea.tecnicas.dao.StudentDAO;

public class StudentList implements StudentDAO 
{
    public static final List<StudentDTO> studentBD = new ArrayList<StudentDTO>();

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
        List<StudentDTO> estudiantes = new ArrayList<StudentDTO>();
        for (StudentDTO estudiante : studentBD) {
                estudiantes.add(estudiante);
        }
        return estudiantes;
    }

    @Override
    public boolean delete(String identificacion) {
        for (StudentDTO estudiante : studentBD) {
            if (estudiante.getId().equals(identificacion)) {
                studentBD.remove(estudiante);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(StudentDTO parametro) {
        for (StudentDTO estudiante : studentBD) {
            if (estudiante.getId().equals(parametro.getId())){
                studentBD.remove(estudiante);
                studentBD.add(parametro);
                return true;
            }
        }
        return false;
    }
}
