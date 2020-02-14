package devloper.game.sqldatabasefinishlearn.BASIC_PART;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import devloper.game.sqldatabasefinishlearn.Database_Account.RegisterActivity;
import devloper.game.sqldatabasefinishlearn.R;

import android.view.View;
import android.widget.TextView;
public class Restore extends AppCompatActivity {
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restore);
        context=this;

        TextView txtReg=findViewById(R.id.registerComes);

        txtReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
