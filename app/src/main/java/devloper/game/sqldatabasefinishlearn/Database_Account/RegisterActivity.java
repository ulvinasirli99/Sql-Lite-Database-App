package devloper.game.sqldatabasefinishlearn.Database_Account;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import devloper.game.sqldatabasefinishlearn.R;
import devloper.game.sqldatabasefinishlearn.SQL_MODEL.SqlHelper;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtName;
    private EditText txtPassword;
    private EditText txtMail;
    Context context;
    SqlHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;

        db = new SqlHelper(context);


//        TODO TEXT FILLERIN SET OLMASI//......

        txtName = findViewById(R.id.txtName);
        txtPassword = findViewById(R.id.txtPass);
        txtMail = findViewById(R.id.edtMail);


        final TextView txtLogCome = findViewById(R.id.txtLogCome);
        CheckBox chcShow = findViewById(R.id.chcShowes);
        Button btnsRegister = findViewById(R.id.btnSave);

        btnsRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Namee = txtName.getText().toString().trim();
                String maill = txtMail.getText().toString().trim();
                String passwords = txtPassword.getText().toString().trim();


                if (TextUtils.isEmpty(Namee) && TextUtils.isEmpty(maill) && TextUtils.isEmpty(passwords)) {
                    Toast.makeText(context, "Enter your information !!!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(Namee)) {
                    txtName.setError("Enter your Name !!!");
                    return;
                }
                if (TextUtils.isEmpty(maill)) {
                    txtMail.setError("Enter your Mail !!!");
                    return;
                }
                if (TextUtils.isEmpty(passwords)) {
                    txtPassword.setError("Enter your Password !!!");
                    return;
                }

                if (passwords.length() < 6) {
                    Toast.makeText(context, "Password too short, enter minimum 6 characters!", Toast.LENGTH_LONG).show();
                    return;
                }


                db.InsertColumn(

                        txtName.getText().toString().trim(),
                        txtMail.getText().toString().trim(),
                        txtPassword.getText().toString().trim()

                );


                long task = db.InsertColumn(Namee, maill, passwords);

                if (task > 0) {
                    Intent intentl = new Intent(context, LoginActivity.class);
                    startActivity(intentl);
                    Toast.makeText(context, "You have Registered !!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Registered Failed !!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        chcShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    txtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    txtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        txtLogCome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
