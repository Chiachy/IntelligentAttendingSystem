package magic.com.intelligentattendingsystem.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import magic.com.intelligentattendingsystem.DataBase.DataBaseModel;
import magic.com.intelligentattendingsystem.DataBase.StudentData;
import magic.com.intelligentattendingsystem.R;

public class ActivityStudentSignUp extends AppCompatActivity {

    private EditText mEtStudentName;
    private EditText mEtStudentNumber;
    private EditText mEtTel;
    private EditText mEtStudentClassNumber;
    private EditText mEtPassword;
    private EditText mEtPasswordAgain;
    private RadioGroup mRgGender;
    private Button mBtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);
        initViews();

        mEtStudentNumber.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        mEtTel.setInputType(EditorInfo.TYPE_CLASS_PHONE);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DataBaseModel.getInstance(ActivityStudentSignUp.this)
                        .searchStudent(mEtStudentNumber.getText().toString()).get(0).getId() == null) {

                    Toast.makeText(ActivityStudentSignUp.this, DataBaseModel.getInstance(ActivityStudentSignUp.this)
                            .searchStudent(mEtStudentNumber.getText().toString()).get(0).getId(), Toast.LENGTH_SHORT).show();

                    if(mEtStudentNumber.getText().toString().length() == 14 ){
                        if (mEtPassword.getText().toString().length() >= 6 ) {
                            if (mEtPassword.getText().toString().equals(mEtPasswordAgain.getText().toString())) {
                                StudentData studentData = new StudentData();

                                studentData.setId(mEtStudentNumber.getText().toString());
                                studentData.setPassword(mEtPassword.getText().toString());
                                studentData.setGender(mRgGender.getCheckedRadioButtonId()
                                        == R.id.rbtn_male ?"男":"女" );
                                studentData.setName(mEtStudentName.getText().toString());
                                studentData.setTel(mEtTel.getText().toString());
                                studentData.setClass_name(mEtStudentClassNumber.getText().toString());

                                DataBaseModel.getInstance(ActivityStudentSignUp.this).saveStudentData(studentData);
                                Toast.makeText(ActivityStudentSignUp.this, "注册成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(ActivityStudentSignUp.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(ActivityStudentSignUp.this, "密码长度应至少六位字符", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ActivityStudentSignUp.this, "学号长度不符合规范", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ActivityStudentSignUp.this, "该学号已注册", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews() {
        mEtStudentClassNumber = (EditText) findViewById(R.id.et_sign_up_student_class_number);
        mEtStudentName = (EditText) findViewById(R.id.et_sign_up_student_name);
        mEtStudentNumber = (EditText) findViewById(R.id.et_sign_up_student_number);
        mEtTel = (EditText) findViewById(R.id.et_sign_up_student_telephone);
        mEtPassword = (EditText) findViewById(R.id.et_sign_up_student_password);
        mEtPasswordAgain = (EditText) findViewById(R.id.et_sign_up_student_password_again);
        mRgGender = (RadioGroup) findViewById(R.id.rg_stu_choose_gender);
        mBtnSignUp = (Button) findViewById(R.id.btn_student_confirm_signup);
    }
}
