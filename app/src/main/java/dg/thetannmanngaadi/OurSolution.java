package dg.thetannmanngaadi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import dg.thetannmanngaadi.R;

public class OurSolution extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oursolution);
		
		
		
    }
    public void back(View v) {
		 finish();
	}
}
