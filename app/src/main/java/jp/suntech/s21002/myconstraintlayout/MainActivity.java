package jp.suntech.s21002.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Buttonlistener listener = new Buttonlistener();

        Button btConfirm = findViewById(R.id.btConfirm);
        Button btSend = findViewById(R.id.btSend);
        Button btClear = findViewById(R.id.btClear);
        btConfirm.setOnClickListener(listener);
        btSend.setOnClickListener(listener);
        btClear.setOnClickListener(listener);
    }

//    ボタン押下の処理
    private class Buttonlistener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            TextView Name = findViewById(R.id.tvName);
            EditText inputName = findViewById(R.id.etName);
            TextView MailAddress = findViewById(R.id.tvMail);
            EditText inputMailAddress = findViewById(R.id.etMail);
            TextView MailTitle = findViewById(R.id.tvMailtitle);
            EditText inputMailTitle = findViewById(R.id.etMailtitle);
            TextView Comment = findViewById(R.id.tvComment);
            EditText inputComment = findViewById(R.id.etComment);

            String toastMessage =
                Name.getText().toString() + " : " + inputName.getText().toString() + "\n"
                + MailAddress.getText().toString() + " : " + inputMailAddress.getText().toString() + "\n"
                + MailTitle.getText().toString() + " : " + inputMailTitle.getText().toString() + "\n"
                + Comment.getText().toString() + " : " + inputComment.getText().toString();



            int id = view.getId();
            switch (id){
                case R.id.btConfirm:
                    ConfirmDialog dialogFlagment = new ConfirmDialog();
                    dialogFlagment.setToastMessage(toastMessage);
                    dialogFlagment.show(getSupportFragmentManager(), "ConfirmDialog");
                    break;
                case R.id.btSend:
                    Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_LONG).show();
                    break;
                case R.id.btClear:
                    inputName.setText("");
                    inputMailAddress.setText("");
                    inputMailTitle.setText("");
                    inputComment.setText("");
                    break;
            }
        }
    }
}