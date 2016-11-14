package magic.com.intelligentattendingsystem.DataBase;

/**
 * Created by Chiachi on 2016/11/6.
 */

public class StudentData {
    private String id;
    private String name;
    private String gender;
    private String student_number;
    private String class_name;
    private String tel;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getStudent_number() {
        return student_number;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getTel() {
        return tel;
    }

}
