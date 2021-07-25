package dg.thetannmanngaadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

	private EditText un;

	private EditText ps;

	private TextView txterr;
    
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
		
		
		 un = (EditText)findViewById(R.id.username);
		 ps = (EditText)findViewById(R.id.password);
		 txterr = (TextView)findViewById(R.id.loginTextViewErr);
    }
    public void Login(View v) {
        String unn = un.getText().toString();
		String pss = ps.getText().toString();
		
		if(unn == null || unn.isEmpty()){
			txterr.setVisibility(View.VISIBLE);
			txterr.setText("Enter Username ! ");
			
		}
		if(pss == null || pss.isEmpty()){
			txterr.setVisibility(View.VISIBLE);
			txterr.setText("Enter Passward ! ");

		}
		
		Toast.makeText(getApplicationContext(),unn+" "+pss,Toast.LENGTH_LONG).show();
    } 
	
	public void back(View v) {
		finish();
	}
}
