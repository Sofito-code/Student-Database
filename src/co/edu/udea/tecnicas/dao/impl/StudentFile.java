package co.edu.udea.tecnicas.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import co.edu.udea.tecnicas.model.StudentDTO;
import co.edu.udea.tecnicas.dao.StudentDAO;

public class StudentFile implements StudentDAO 
{
    private static final String DELIMITADOR_ARCHIVO = ",";
    private static final String _FILE_NAME = "C:\\Users\\Dilopez\\Desktop\\estudiantesescritorio";
    private BufferedWriter escritorBuffer;
    private FileWriter escritorArchivo;
    private Scanner lector;
    private File archivoEstudiantes;

    public StudentFile() {
            archivoEstudiantes = new File(_FILE_NAME);		
            try {
                lector = new Scanner(archivoEstudiantes);		
            } 
            catch (IOException e) {
                    e.printStackTrace();
            }
    }

    @Override
    public boolean store(StudentDTO estudiante) {
            StringBuilder sb=new StringBuilder();
            sb.append(estudiante.getId());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(estudiante.getNames());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(estudiante.getLastNames());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(estudiante.getGender());

            try {
                    escritorArchivo=new FileWriter(archivoEstudiantes, true);
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
    public StudentDTO consult(String identificacion) {

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
}
