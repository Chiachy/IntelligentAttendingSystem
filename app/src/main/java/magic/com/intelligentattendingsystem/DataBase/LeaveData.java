package magic.com.intelligentattendingsystem.DataBase;

/**
 * Created by Chiachi on 2016/11/7.
 */

public class LeaveData {

    private String leaverName;
    private String course;
    private String applicationId;
    private String applicationStatu;
    private String passTime;
    private String courseTeacher;

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public void setLeaverName(String leaverName) {
        this.leaverName = leaverName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public void setApplicationStatu(String applicationStatu) {
        this.applicationStatu = applicationStatu;
    }

    public void setPassTime(String passTime) {
        this.passTime = passTime;
    }

    public String getLeaverName() {
        return leaverName;
    }

    public String getCourse() {
        return course;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getApplicationStatu() {
        return applicationStatu;
    }

    public String getPassTime() {
        return passTime;
    }
}
