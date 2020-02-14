package devloper.game.sqldatabasefinishlearn.Database_Account;

import androidx.appcompat.app.AppCompatActivity;

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
import android.os.Bundle;
import android.widget.Toast;

import org.w3c.dom.Text;

import devloper.game.sqldatabasefinishlearn.BASIC_PART.MainActivity;
import devloper.game.sqldatabasefinishlearn.BASIC_PART.Restore;
import devloper.game.sqldatabasefinishlearn.R;
import devloper.game.sqldatabasefinishlearn.SQL_MODEL.SqlHelper;

public class LoginActivity extends AppCompatActivity {
    private EditText edtMail;
    private EditText edtPassword;
    Context context;
    SqlHelper db;
    String user;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;

//        TODO DATABASEMIZIN MOVCUD YOXLANISI
        db = new SqlHelper(context);


        TextView remove=findViewById(R.id.txtRemove);
        Button btnLOgin = findViewById(R.id.btnLogin);
        edtMail = findViewById(R.id.edtMail);
        edtPassword = findViewById(R.id.edtPassword);
        CheckBox chcShow = findViewById(R.id.chcShow);
        TextView txtGet = findViewById(R.id.txtRegCome);


//        TODO LOGIN OLMA HADISESI//////.....\\\\\\\
        btnLOgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = edtMail.getText().toString().trim();
                pass = edtPassword.getText().toString().trim();


//               TODO EGER lOGIN TEXTLER BOS OLARSA O ZAMAN MESAJ VERILSIN////.....\\\\
                if (TextUtils.isEmpty(user) && TextUtils.isEmpty(pass)) {
                    Toast.makeText(LoginActivity.this, "Enter your information !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(user)) {
                    edtMail.setError("Enter your Mail");
                    return;
                } else if (TextUtils.isEmpty(pass)) {
                    edtPassword.setError("Enter your Password");
                    return;
                }




                checkUsers();
                return;


            }
        });


//        TODO REMOVE HISSESI ILE ACCOUBTUN YENI HESABIN SILNMESI/////.....\\\\\
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent remove =new Intent(context,ResetPassword.class);
                startActivity(remove);
            }
        });






//TODO MOVCUD GESAB OLMADIQDA QEYDIYYAT SEYFESIN GIRIS TEXTII//////.....\\\\\\
        txtGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 1);
            }
        });


        txtGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        chcShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }


    public void checkUsers() {

        Boolean res = db.checkUser(user, pass);

        if (res == true) {
            Intent intent= new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);

        } else {

            Intent intento= new Intent(LoginActivity.this,Restore.class);
            startActivity(intento);

        }


    }


}
