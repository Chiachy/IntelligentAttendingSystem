package magic.com.intelligentattendingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import magic.com.intelligentattendingsystem.DataBase.DataBaseModel;
import magic.com.intelligentattendingsystem.Dialog.DialogSelectTeacOrStud;
import magic.com.intelligentattendingsystem.R;

public class ActivitySignIn extends AppCompatActivity {

    private EditText mEtAccount;
    private EditText mEtPassword;
    private TextView mTvJump2SignUp;
    private Button mBtnSignIn;
    private android.widget.Toolbar mTbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //Toolbar config
        setActionBar(mTbMain);
        mTbMain.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_user_user_center:
                        Toast.makeText(ActivitySignIn.this, "请先登陆！", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        //sign in button function
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
               // Toast.makeText(ActivitySignIn.this, "登陆按钮", Toast.LENGTH_SHORT).show();
            }
        });

        //Jump tv function
        mTvJump2SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the choosing dialog
                showChooseDialog();
            }
        });
    }

    //生成导航栏菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void initViews() {
        mEtAccount = (EditText) findViewById(R.id.et_signin_account);
        mEtPassword = (EditText) findViewById(R.id.et_signin_password);
        mTvJump2SignUp = (TextView) findViewById(R.id.tv_signin_jump2sign_up);
        mBtnSignIn = (Button) findViewById(R.id.btn_sign_in);
        mTbMain = (Toolbar) findViewById(R.id.toolbar_main_activity);
    }

    //弹出选择身份提示框
    public void showChooseDialog() {
        DialogFragment dialogFragment = new DialogSelectTeacOrStud();
        dialogFragment.show(getSupportFragmentManager(), "selectIdentity");
    }

    //登陆业务逻辑
    public void signIn() {
        String account = mEtAccount.getText().toString();
        String password = mEtAccount.getText().toString();
        if (!account.equals("") && !password.equals("")) {
            if (DataBaseModel.getInstance(ActivitySignIn.this)
                    .searchStudent(account).size() != 0) {
                if (account.equals(DataBaseModel.getInstance(ActivitySignIn.this).searchStudent(account)
                        .get(0).getId())) {
                    if (password.equals(DataBaseModel.getInstance(ActivitySignIn.this)
                            .searchStudent(account).get(0).getPassword())) {
                        Toast.makeText(this, "学生账号登陆成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ActivitySignIn.this, ActivityStudentView.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (DataBaseModel.getInstance(ActivitySignIn.this).searchTeacher(account)
                    .size() != 0) {
                if (account.equals(DataBaseModel.getInstance(ActivitySignIn.this)
                        .searchTeacher(account).get(0).getId())) {
                    if (password.equals(DataBaseModel.getInstance(ActivitySignIn.this)
                            .searchTeacher(account).get(0).getPassword())) {
                        Toast.makeText(this, "教职工账号登陆成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ActivitySignIn.this, ActivityTeacherView.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(this, "账号不存在", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "请输入账号或密码", Toast.LENGTH_SHORT).show();
        }
    }

}
