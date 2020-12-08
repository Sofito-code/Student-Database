package co.edu.udea.tecnicas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.tecnicas.model.StudentDTO;
import co.edu.udea.tecnicas.dao.StudentDAO;

public class StudentList implements StudentDAO 
{
    private List<StudentDTO> list = new ArrayList<>();;

    /**
     * Create
     * @param student
     * @return 
     */
    @Override
    public boolean store(StudentDTO student) {
        
        return list.add(student);
    }

    @Override
    public StudentDTO read(String id) {
        for (StudentDTO student : list) {
            if (student.getId().equals(id))
                return student;
        }
        return new StudentDTO();
    }

    @Override
    public List<StudentDTO> listing() {
        List<StudentDTO> students = new ArrayList<>();
        list.forEach((StudentDTO student) -> {
            students.add(student);
        });
        return students;
    }

    @Override
    public boolean delete(String identificacion) {
        for (StudentDTO student : list) {
            if (student.getId().equals(identificacion)) {
                list.remove(student);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(StudentDTO data) {
        for (StudentDTO estudiante : list) {
            if (estudiante.getId().equals(data.getId())){
                list.remove(estudiante);
                list.add(data);
                return true;
            }
        }
        return false;
    }


    @Override
    public void setList(List<StudentDTO> list) {
        this.list = list;
    }

}
