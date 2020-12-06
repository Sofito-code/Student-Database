package co.edu.udea.tecnicas.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import co.edu.udea.tecnicas.model.StudentDTO;
import co.edu.udea.tecnicas.dao.StudentDAO;
import java.io.BufferedReader;
import java.io.FileReader;

public class StudentFile implements StudentDAO 
{
    private static final String DELIMITADOR_ARCHIVO = " ";
    
    private static String FILE_NAME = "students" ;
    private BufferedWriter escritorBuffer;
    private FileWriter escritorArchivo;
    private Scanner lector;
    private File archivoEstudiantes;

    
    public StudentFile(String fileName) { 
        FILE_NAME = fileName;
        try {
            archivoEstudiantes = new File("/reports/"+FILE_NAME+".txt");
            if (!archivoEstudiantes.exists()) archivoEstudiantes.createNewFile();
            lector = new Scanner(archivoEstudiantes);                
        } 
        catch (IOException e) {
                e.printStackTrace();
        }
    }
    

    @Override
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
            escritorBuffer.newLine();
            escritorBuffer.close();
            
            return true;
        } catch (IOException e) {			
            e.printStackTrace();
        }		
        return false;
    }

    @Override
    public StudentDTO consult(String id) {

            return null;
    }

    @Override
    public List<StudentDTO> listing() {

            return null;
    }

    @Override
    public boolean delete(String identificacion) {

            return false;
    }

    @Override
    public boolean update(StudentDTO estudiante) {

            return false;
    }
    
    public boolean read(String id) throws IOException{
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));
            while (s.hasNext()) {
                System.out.println(s.next());
                if(s.next().equals(id)){
                    
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return false;
    }
}
