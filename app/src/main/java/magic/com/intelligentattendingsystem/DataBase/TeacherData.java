package magic.com.intelligentattendingsystem.DataBase;

/**
 * Created by Chiachi on 2016/11/6.
 */

public class TeacherData {

    private String id;
    private String name;
    private String gender;
    private String work_number;
    private String tel;
    private String password;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWork_number(String work_number) {
        this.work_number = work_number;
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

    public String getWork_number() {
        return work_number;
    }

    public String getTel() {
        return tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
