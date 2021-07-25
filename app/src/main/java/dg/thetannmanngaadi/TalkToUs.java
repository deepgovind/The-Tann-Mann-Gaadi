package dg.thetannmanngaadi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TalkToUs extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taktous);
		
    }
    public void back(View v) {
		finish();
	}
}
