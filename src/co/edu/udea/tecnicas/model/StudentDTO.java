package co.edu.udea.tecnicas.model;

import java.util.Random;

/**
 * DTO = DATA TRANSFER OBJECT = OBJETO DE TRANSFERENCIA DE DATOS
 * @author Sofia Vanegas
 */
public class StudentDTO
{                                       
    private String names;
    private String lastNames;
    private String yearsOld;
    private char gender;
    private String id;        
    private String group;
    private String registrationNumber;

    public StudentDTO(String names, String lastNames, String yearsOld, char gender, String id, String group) {
        Random r = new Random();
        this.names = names;
        this.lastNames = lastNames;
        this.yearsOld = yearsOld;
        this.gender = gender;
        this.id = id;
        this.group = group;
        this.registrationNumber = Integer.toString(r.nextInt(1000));
    }

    
    /**
     * Student empty
     */
    public StudentDTO() {
        this.names = "N";
        this.lastNames = "N";
        this.yearsOld = "N";
        this.gender = 'N';
        this.id = "N";
        this.group = "N";
        this.registrationNumber = "N";
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombres:").append(names);
        sb.append(" - Apellidos:").append(lastNames);
        sb.append(" - Años:").append(yearsOld);
        sb.append(" - Genero:").append(gender);
        sb.append(" - Identificacion:").append(id);
        sb.append(" - Grupo:").append(group);
        sb.append(" - Matricula:").append(registrationNumber);
        return sb.toString();
    }
   

    public String getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(String yearsOld) {
        this.yearsOld = yearsOld;
    }
}
