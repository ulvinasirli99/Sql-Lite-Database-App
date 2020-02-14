package devloper.game.sqldatabasefinishlearn.Database_Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devloper.game.sqldatabasefinishlearn.R;
import devloper.game.sqldatabasefinishlearn.SQL_MODEL.SqlHelper;

public class ResetPassword extends AppCompatActivity {

    EditText edtEmail;
    Button btnReset;
    Button btnBack;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        context=this;

        final SqlHelper db =new SqlHelper(context);

        edtEmail=findViewById(R.id.email);
        btnReset=findViewById(R.id.btnReset);
        btnBack=findViewById(R.id.btnBack);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.removeAcc();
                Toast.makeText(context, "You have delete account...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context,LoginActivity.class));
                return;
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
