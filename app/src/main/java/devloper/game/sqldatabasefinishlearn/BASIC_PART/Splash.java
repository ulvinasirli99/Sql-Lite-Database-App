package devloper.game.sqldatabasefinishlearn.BASIC_PART;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import devloper.game.sqldatabasefinishlearn.Database_Account.LoginActivity;
import devloper.game.sqldatabasefinishlearn.R;

public class Splash extends AppCompatActivity {

    Context context;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context = this;

        mp=MediaPlayer.create(context,R.raw.hos);
        mp.start();

       final ImageView iv=findViewById(R.id.Spl);

         Animation an =AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);

         iv.startAnimation(an);

         an.setAnimationListener(new Animation.AnimationListener() {
             @Override
             public void onAnimationStart(Animation animation) {

             }

             @Override
             public void onAnimationEnd(Animation animation) {
                 Intent i = new Intent(context,LoginActivity.class);
                 startActivity(i);
                 finish();
             }

             @Override
             public void onAnimationRepeat(Animation animation) {

             }
         });

    }
}
