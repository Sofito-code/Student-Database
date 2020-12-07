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

public class StudentFile
{
    private static final String DELIMITADOR_ARCHIVO = "-";    
    private static String FILE_NAME = "";
    private BufferedWriter escritorBuffer;
    private FileWriter escritorArchivo;
    private File archivoEstudiantes;

    
    public StudentFile(String fileName) { 
        FILE_NAME = fileName;
        Scanner lector;
        try {
            archivoEstudiantes = new File(FILE_NAME+".txt");
            if (!archivoEstudiantes.exists()) archivoEstudiantes.createNewFile();
            lector = new Scanner(archivoEstudiantes);                
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
        sb.append(estudiante.getId());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(estudiante.getGender());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(estudiante.getGroup());
        sb.append(DELIMITADOR_ARCHIVO);
        try {
            escritorArchivo = new FileWriter(archivoEstudiantes, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);		
            escritorBuffer.write(sb.toString());
            escritorBuffer.write("\n");
            escritorBuffer.newLine();
            escritorBuffer.close();
            escritorArchivo.close();
            
            return true;
        } catch (IOException e) {			
            e.printStackTrace();
        }		
        return false;
    }

//    public StudentDTO consult(String id){
//        
//    }

    public List<StudentDTO> listing() {
        
            return null;
    }

    public boolean delete(String identificacion) {
            archivoEstudiantes.delete();
            return false;
    }

    public boolean update(StudentDTO estudiante)throws IOException{
        archivoEstudiantes.delete();
        return true;
        
    }
    
    public boolean read(File grouoFile) throws IOException{
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(grouoFile)));
            while (s.hasNext()) {
                System.out.println(s.next());
                
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
        return false;
    }
}
