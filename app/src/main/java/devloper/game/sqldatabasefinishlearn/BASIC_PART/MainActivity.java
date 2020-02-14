package devloper.game.sqldatabasefinishlearn.BASIC_PART;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import devloper.game.sqldatabasefinishlearn.R;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        music= MediaPlayer.create(this,R.raw.welcome);
        music.start();
        TextView textExit=findViewById(R.id.lestProg);
        textExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
