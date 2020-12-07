package co.edu.udea.tecnicas.controller;

import co.edu.udea.tecnicas.dao.StudentDAO;
import co.edu.udea.tecnicas.dao.impl.StudentFile;
import co.edu.udea.tecnicas.dao.impl.StudentList;
import co.edu.udea.tecnicas.deal.StudentDeal;
import java.util.List;
import co.edu.udea.tecnicas.model.StudentDTO;
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
    StudentFile allStudentFile = new StudentFile("Todos-los-estudiantes");
    StudentDAO allStudents = new StudentList();
    StudentDeal deal = new StudentDeal();
   
    public boolean store(StudentDTO student){        
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
        return answer1==answer2;
    }
    /**
     * index
     * @return 
     */
    public List<StudentDTO> listing(StudentDAO studentList){
        return studentList.listing();
    }
//falta
   

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

    public void setFirst(StudentDAO first) {
        this.first = first;
    }

    public void setSecond(StudentDAO second) {
        this.second = second;
    }

    public void setThird(StudentDAO third) {
        this.third = third;
    }

    public void setFourth(StudentDAO fourth) {
        this.fourth = fourth;
    }

    public void setFifth(StudentDAO fifth) {
        this.fifth = fifth;
    }
    

}
