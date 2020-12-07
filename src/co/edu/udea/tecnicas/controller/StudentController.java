package co.edu.udea.tecnicas.controller;

import co.edu.udea.tecnicas.dao.StudentDAO;
import co.edu.udea.tecnicas.dao.impl.StudentFile;
import co.edu.udea.tecnicas.dao.impl.StudentList;
import co.edu.udea.tecnicas.deal.StudentDeal;
import java.util.List;
import co.edu.udea.tecnicas.model.StudentDTO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
   
    public static void main(String[] args) {
        StudentController a = new StudentController();
        a.readAllGroups();
    }
    public boolean store(StudentDTO student) throws IOException{
        StudentDTO studentRequest = allStudents.read(student.getId());
        if(studentRequest == null){
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
        JOptionPane.showMessageDialog(null, "El estudiante con identificacion " + student.getId() + " ya fue reguistrado");
        return false;       
    }
    /**
     * index
     * @return 
     */
    public List<StudentDTO> listing(StudentDAO studentList){
        return studentList.listing();
    }
//
    public void readAllGroups(){
        try {
            first.setList(firstFile.read());
            second.setList(secondFile.read());
            third.setList(thirdFile.read());
            fourth.setList(fourthFile.read());
            fifth.setList(fifthFile.read());
            allStudents.setList(allStudentFile.read());
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean update(StudentDTO student) throws IOException{
        StudentDTO studentRequest = allStudents.read(student.getId());
        if(studentRequest != null){
            boolean answer2 = false;
            boolean answer1 = false;
            if(!deal.update(student)) return false;   
            //preguntar si esta en el mismo grupo
            //sisi entonces solo actualiza los datos, reeescribe archivos
            
            //y sino entonces lo ambia de lista, reescrive archivos
        }     
        return false;
    }
    
    public boolean delete(String id){
        return deal.delete(id);
    }
   

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
