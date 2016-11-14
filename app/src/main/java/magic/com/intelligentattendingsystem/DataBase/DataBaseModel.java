package magic.com.intelligentattendingsystem.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chiachi on 2016/11/7.
 */

public class DataBaseModel {

    public static final String DB_NAME = "attending_system";

    public static final int VERSION = 1;

    public static DataBaseModel dataBaseModel;

    private SQLiteDatabase db;

    //将构造方法私有化
    private DataBaseModel(Context context){
        DataBaseOpenHelper dbOpenHelper = new DataBaseOpenHelper(
                context, DB_NAME, null, VERSION);
        db = dbOpenHelper.getWritableDatabase();
    }

    //获取AttendingSystemDB的实例
    public synchronized static DataBaseModel getInstance(Context context) {
        if(dataBaseModel == null ){
            dataBaseModel = new DataBaseModel(context);
        }
        return dataBaseModel;
    }

    /**
     * 储存StudentData
     * @param studentData
     */
    public void saveStudentData(StudentData studentData ){
        if (studentData != null){
            ContentValues values = new ContentValues();
            values.put("id", studentData.getId());
            values.put("name", studentData.getName());
            values.put("gender", studentData.getGender());
            values.put("student_number", studentData.getStudent_number());
            values.put("class_name", studentData.getClass_name());
            values.put("tel", studentData.getTel());
            values.put("password", studentData.getPassword());
        }
    }

    /**
     * 删除学生数据
     * @param id
     * @return
     */
    private int deleteStudentData(String id) {
        String[] numbers = {id};
        return db.delete("StudentDatas", "id=?", numbers);
    }

    /**
     * 更新学生数据
     * @param studentData
     * @param formerNumber
     */
    public void updateStudentData(StudentData studentData, String formerNumber) {
        deleteStudentData(formerNumber);
        saveStudentData(studentData);
    }

    /**
     *  按学号搜索学生信息
     * @param stuNumber
     * @return
     */
    public List<StudentData> searchStudent(String stuNumber){
        List<StudentData> list = new ArrayList<>();
        Cursor cursor = null;
        String sql = "select * from StudentDatas " +
                "where id=? ";
        String[] args = {stuNumber};
        cursor = db.rawQuery(sql, args);
        if (cursor.moveToFirst()){
            do {
                StudentData studentData = new StudentData();
                studentData.setId(cursor.getString(cursor.getColumnIndex("id")));
                studentData.setName(cursor.getString(cursor.getColumnIndex("name")));
                studentData.setGender(cursor.getString(cursor.getColumnIndex("gender")));
                studentData.setClass_name(cursor.getString(cursor.getColumnIndex("class_name")));
                studentData.setTel(cursor.getString(cursor.getColumnIndex("tel")));
                studentData.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                list.add(studentData);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    /**
     * 储存TeacherData
     * @param teacherData
     */
    public void saveTeacherData(TeacherData teacherData ){
        if (teacherData != null){
            ContentValues values = new ContentValues();
            values.put("id", teacherData.getId());
            values.put("name", teacherData.getName());
            values.put("gender", teacherData.getGender());
            values.put("student_number", teacherData.getWork_number());
            values.put("tel", teacherData.getTel());
            values.put("password", teacherData.getPassword());
        }
    }

    /**
     * 删除TeacherData
     * @param number
     * @return
     */
    private int deleteTeacherData(String number) {
        String[] numbers = {number};
        return db.delete("TeacherDatas", "id=?", numbers);
    }

    /**
     * 更新TeacherData
     * @param teacherData
     * @param formerNumber
     */
    public void updateTeacherData(TeacherData teacherData, String formerNumber) {
        deleteTeacherData(formerNumber);
        saveTeacherData(teacherData);
    }

    /**
     * 按工号搜索教职工信息
     * @param teaNumber
     * @return 教职工信息
     */
    public List<TeacherData> searchTeacher(String teaNumber){
        List<TeacherData> list = new ArrayList<>();
        Cursor cursor = null;
        String sql = "select * from TeacherDatas " +
                "where id=? ";
        String[] args = {teaNumber};
        cursor = db.rawQuery(sql, args);
        if (cursor.moveToFirst()){
            do {
                TeacherData teacherData = new TeacherData();
                teacherData.setId(cursor.getString(cursor.getColumnIndex("id")));
                teacherData.setName(cursor.getString(cursor.getColumnIndex("name")));
                teacherData.setGender(cursor.getString(cursor.getColumnIndex("gender")));
                teacherData.setTel(cursor.getString(cursor.getColumnIndex("tel")));
                teacherData.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                list.add(teacherData);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }


    /**
     * 检查数据库表是否存在
     *
     * @return true：数据库存在
     */
    public boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = "/data/data/com.magic/" + "CourseDatas";
            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY | SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        } catch (SQLiteException e) {
            //database does't exist yet.
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

}


