package co.edu.udea.tecnicas.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import co.edu.udea.tecnicas.model.StudentDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StudentFile
{
    private static final String DELIMITADOR_ARCHIVO = ",";    
    private static String FILE_ROUTE = "";
    private BufferedWriter buffWriter;
    private FileWriter fileWriter;
    private File studentFile;
    private Scanner reader;
    
    public StudentFile(String fileName) { 
        FILE_ROUTE = "reports/"+fileName+".txt";        
        try {
            studentFile = new File(FILE_ROUTE);
            if (!studentFile.exists()) studentFile.createNewFile();
            reader = new Scanner(studentFile);                       
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean store(StudentDTO estudiante) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(estudiante.getRegistrationNumber());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(estudiante.getNames());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(estudiante.getLastNames());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(estudiante.getYearsOld());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(estudiante.getGender());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(estudiante.getId());
        sb.append(DELIMITADOR_ARCHIVO);        
        sb.append(estudiante.getGroup());
        try {            
            fileWriter = new FileWriter(studentFile, true);
            buffWriter = new BufferedWriter(fileWriter);  
            buffWriter.write(sb.toString());
            buffWriter.newLine();
            buffWriter.close();
            fileWriter.close();
            
            return true;
        } catch (IOException e) {			
            e.printStackTrace();
        }		
        return false;
    }

    public boolean delete() throws IOException {
        if(studentFile.delete()){
            try{
                if (!studentFile.exists()) studentFile.createNewFile();
                reader = new Scanner(studentFile);                       
                reader.close();
            }
            catch(IOException e)            {
                e.printStackTrace();
            }
            return true;
        }        
        return false;
        
    }

    public boolean update(List<StudentDTO> list)throws IOException{
        if(delete()){            
                list.forEach((StudentDTO student) -> {
                store(student);
            });
            return true;
        }      
        return false;
    }
    
    
    public List read() throws IOException{
        Scanner s = null;
        List<StudentDTO> list = new ArrayList<>();
        try {
            s = new Scanner(new BufferedReader(new FileReader(this.studentFile)));
            while (s.hasNextLine()) {
                String[] data = s.nextLine().split(",");                
                StudentDTO oldStudent = new StudentDTO(data[1], data[2], data[3], data[4].charAt(0), data[5], data[6]);
                list.add(oldStudent);                
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if (s != null) {
                s.close();
            }
        }        
        return list;
    }
    

}
