package dg.thetannmanngaadi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Event extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
		
    }
	public void submite(View v) {
		finish();
	}
    public void back(View v) {
		finish();
	}
}
