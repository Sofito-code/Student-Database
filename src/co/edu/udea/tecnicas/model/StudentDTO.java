package co.edu.udea.tecnicas.model;
/**
 * DTO = DATA TRANSFER OBJECT = OBJETO DE TRANSFERENCIA DE DATOS
 * @author Sofia Vanegas
 */
public class StudentDTO
{                                       
    private String names;
    private String lastNames;
    private char gender;
    private String id;        
    private String group;
    private String registrationNumber;

    public StudentDTO(String names, String lastNames, char gender, String id, String group) {
        this.names = names;
        this.lastNames = lastNames;
        this.gender = gender;
        this.id = id;
        this.group = group;
    }
    /**
     * Student empty
     */
    public StudentDTO() {
        this.names = "N";
        this.lastNames = "N";
        this.gender = 'N';
        this.id = "N";
        this.group = "N";
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
        return "Student: " + "names=" + names + ", lastNames=" + lastNames + ", gender=" + gender + ", id=" + id + ", group=" + group;
    }    
}
