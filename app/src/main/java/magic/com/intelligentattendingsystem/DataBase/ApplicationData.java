package magic.com.intelligentattendingsystem.DataBase;

/**
 * Created by Chiachi on 2016/11/6.
 */

public class ApplicationData {

    private String id;
    private String applier_number;
    private String applier_name;
    private String time_from;
    private String time_to;
    private String reason;
    private String receiver;

    public void setApplier_name(String applier_name) {
        this.applier_name = applier_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setApplier_number(String applier_number) {
        this.applier_number = applier_number;
    }

    public void setTime_from(String time_from) {
        this.time_from = time_from;
    }

    public void setTime_to(String time_to) {
        this.time_to = time_to;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getId() {
        return id;
    }

    public String getApplier_number() {
        return applier_number;
    }

    public String getApplier_name() {
        return applier_name;
    }

    public String getTime_from() {
        return time_from;
    }

    public String getTime_to() {
        return time_to;
    }

    public String getReason() {
        return reason;
    }

    public String getReceiver() {
        return receiver;
    }

}
