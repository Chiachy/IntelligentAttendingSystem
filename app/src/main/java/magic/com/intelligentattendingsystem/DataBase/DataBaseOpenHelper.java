package magic.com.intelligentattendingsystem.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chiachi on 2016/11/6.
 */

public class DataBaseOpenHelper extends SQLiteOpenHelper {

    /**
     * 把id当做学号使用，student_number弃用为空
     */
    public static final String CREATE_STUDENT =
            "create table StudentDatas(" +
                    "id text primary key ," +
                    "name text," +
                    "gender text," +
                    "student_number text," +
                    "class_name text," +
                    "tel text," +
                    "password text" +
                    ")";

    /**
     * 把id当做工号使用，teacher_number弃用为空
     */
    public static final String CREATE_TEACHER =
            "create table TeacherDatas(" +
                    "id text primary key," +
                    "name text," +
                    "gender text," +
                    "work_number text," +
                    "tel text," +
                    "password text" +
                    ")";

    public static final String CREATE_COURSE =
            "create table CourseDatas(" +
                    "id text primary key," +
                    "name text," +
                    "site text," +
                    "time_begin text," +
                    "time_end," +
                    "teacher_name," +
                    "teacher_number" +
                    ")";

    public static final String CREATE_APPLICATION =
            "create table ApplicationDatas(" +
                    "id text primary key," +
                    "applier_number text," +
                    "applier_name text," +
                    "time_from text," +
                    "time_to text," +
                    "reason text," +
                    "receiver text" +
                    ")";

    public static final String CREATE_LEAVE =
            "create table LeaveDatas(" +
                    "id text primary key," +
                    "course text," +
                    "leave_name text," +
                    "application_id text," +
                    "application_statu text," +
                    "pass_time text," +
                    "course_teacher text" +
                    ")";

    public DataBaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDENT);
        sqLiteDatabase.execSQL(CREATE_TEACHER);
        sqLiteDatabase.execSQL(CREATE_COURSE);
        sqLiteDatabase.execSQL(CREATE_APPLICATION);
        sqLiteDatabase.execSQL(CREATE_LEAVE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(CREATE_STUDENT);
        sqLiteDatabase.execSQL(CREATE_TEACHER);
        sqLiteDatabase.execSQL(CREATE_COURSE);
        sqLiteDatabase.execSQL(CREATE_APPLICATION);
        sqLiteDatabase.execSQL(CREATE_LEAVE);
    }
}
