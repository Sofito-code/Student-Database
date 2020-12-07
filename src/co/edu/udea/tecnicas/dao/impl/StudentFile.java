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
    private static String FILE_NAME = "";
    private BufferedWriter escritorBuffer;
    private FileWriter escritorArchivo;
    private File archivoEstudiantes;
    private Scanner lector;
    
    public StudentFile(String fileName) { 
        FILE_NAME = fileName;
        
        try {
            archivoEstudiantes = new File(FILE_NAME+".txt");
            if (!archivoEstudiantes.exists()) archivoEstudiantes.createNewFile();
            lector = new Scanner(archivoEstudiantes); 
            escritorArchivo = new FileWriter(archivoEstudiantes, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);
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
            escritorBuffer.write(sb.toString());
            escritorBuffer.newLine();
            escritorBuffer.close();
            escritorArchivo.close();
            
            return true;
        } catch (IOException e) {			
            e.printStackTrace();
        }		
        return false;
    }

    public boolean delete() {
            archivoEstudiantes.delete();
        try {
          archivoEstudiantes.createNewFile();
        } catch (IOException e) {
          e.printStackTrace();
        }
            return false;
    }

    public boolean update(List<StudentDTO> list)throws IOException{
        delete();
        list.forEach((StudentDTO student) -> {
            store(student);
        });
        return true;
        
    }
    
    
    public List read() throws IOException{
        Scanner s = null;
        List<StudentDTO> list = new ArrayList<>();
        try {
            s = new Scanner(new BufferedReader(new FileReader(this.archivoEstudiantes)));
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
