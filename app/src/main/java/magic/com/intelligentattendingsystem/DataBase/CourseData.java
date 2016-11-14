package magic.com.intelligentattendingsystem.DataBase;

/**
 * Created by Chiachi on 2016/11/6.
 */

public class CourseData {
    private String id;
    private String name;
    private String site;
    private String time_begin;
    private String time_end;
    private String teacher_name;
    private String teacher_number;

    public CourseData(String id, String name, String site, String time_begin,
                      String time_end, String teacher_name, String teacher_number) {
        this.id = id;
        this.name = name;
        this.site = site;
        this.time_begin = time_begin;
        this.time_end = time_end;
        this.teacher_name = teacher_name;
        this.teacher_number = teacher_number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setTime_begin(String time_begin) {
        this.time_begin = time_begin;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setTeacher_number(String teacher_number) {
        this.teacher_number = teacher_number;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    public String getTime_begin() {
        return time_begin;
    }

    public String getTime_end() {
        return time_end;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getTeacher_number() {
        return teacher_number;
    }
}
