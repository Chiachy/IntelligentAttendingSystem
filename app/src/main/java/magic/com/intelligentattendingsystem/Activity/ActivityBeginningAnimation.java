package magic.com.intelligentattendingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import magic.com.intelligentattendingsystem.DataBase.CourseData;
import magic.com.intelligentattendingsystem.DataBase.DataBaseModel;
import magic.com.intelligentattendingsystem.R;

public class ActivityBeginningAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = View.inflate(this, R.layout.activity_beginning_animation,null);
        setContentView(view);

        initdb();

        //渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(2000);
        view.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(ActivityBeginningAnimation.this, ActivitySignIn.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

    private void initdb() {
        DataBaseModel db = DataBaseModel.getInstance(ActivityBeginningAnimation.this);

        if (!db.checkDataBase()) {
            CourseData c0 = new CourseData("1000", "高等数学",
                    "@31-219","8:00","12:00","刘二根","2021012025");

            Toast.makeText(ActivityBeginningAnimation.this, "iiii", Toast.LENGTH_SHORT).show();

        }
    }
}
