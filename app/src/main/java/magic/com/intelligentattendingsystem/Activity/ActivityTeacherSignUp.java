package magic.com.intelligentattendingsystem.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import magic.com.intelligentattendingsystem.DataBase.DataBaseModel;
import magic.com.intelligentattendingsystem.DataBase.StudentData;
import magic.com.intelligentattendingsystem.R;

public class ActivityTeacherSignUp extends AppCompatActivity {

    private EditText mEtTeacherName;
    private RadioGroup mRgGender;
    private EditText mEtTeacherNumber;
    private EditText mEtTeacherTel;
    private EditText mEtPassword;

    private EditText mEtPasswordAgain;
    private Button mBtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_up);
        initViews();

        mEtTeacherNumber.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        mEtTeacherTel.setInputType(EditorInfo.TYPE_CLASS_PHONE);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DataBaseModel.getInstance(ActivityTeacherSignUp.this)
                        .searchStudent(mEtTeacherNumber.getText().toString()).get(0).getId() == null) {

                    Toast.makeText(ActivityTeacherSignUp.this, DataBaseModel.getInstance(ActivityTeacherSignUp.this)
                            .searchStudent(mEtTeacherNumber.getText().toString()).get(0).getId(), Toast.LENGTH_SHORT).show();

                    if(mEtTeacherNumber.getText().toString().length() == 14 ){
                        if (mEtPassword.getText().toString().length() >= 6 ) {
                            if (mEtPassword.getText().toString().equals(mEtPasswordAgain.getText().toString())) {
                                StudentData studentData = new StudentData();

                                studentData.setId(mEtTeacherNumber.getText().toString());
                                studentData.setPassword(mEtPassword.getText().toString());
                                studentData.setGender(mRgGender.getCheckedRadioButtonId()
                                        == R.id.rbtn_male ?"男":"女" );
                                studentData.setName(mEtTeacherName.getText().toString());
                                studentData.setTel(mEtTeacherTel.getText().toString());

                                DataBaseModel.getInstance(ActivityTeacherSignUp.this).saveStudentData(studentData);
                                Toast.makeText(ActivityTeacherSignUp.this, "注册成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(ActivityTeacherSignUp.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(ActivityTeacherSignUp.this, "密码长度应至少六位字符", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ActivityTeacherSignUp.this, "工号长度不符合规范", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ActivityTeacherSignUp.this, "该工号已注册", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews() {
        mEtTeacherName = (EditText) findViewById(R.id.et_sign_up_teacher_name);
        mRgGender = (RadioGroup) findViewById(R.id.rg_tea_choose_gender);
        mEtTeacherNumber = (EditText) findViewById(R.id.et_sign_up_teacher_work_number);
        mEtTeacherTel = (EditText) findViewById(R.id.et_sign_up_teacher_telephone);
        mEtPassword = (EditText) findViewById(R.id.et_sign_up_teacher_password);
        mEtPasswordAgain = (EditText) findViewById(R.id.et_sign_up_teacher_password_again);
        mBtnSignUp = (Button) findViewById(R.id.btn_sign_up_confirm);
    }


}
