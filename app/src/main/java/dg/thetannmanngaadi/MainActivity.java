package dg.thetannmanngaadi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.widget.TextView;
import dg.thetannmanngaadi.R;

public class MainActivity extends AppCompatActivity {
    
	SharedPreferences mPrefs;
	final String welcomeScreenShownPref = "welcomeScreenShown";

	private DrawerLayout drawerLayout;

	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		//Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
		
		mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

		if (!mPrefs.getBoolean(welcomeScreenShownPref, false)) {
			
			startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
			
			SharedPreferences.Editor editor = mPrefs.edit();
			editor.putBoolean(welcomeScreenShownPref, true);
			editor.commit(); // Very important to save the preference
		}
		
		
		Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
		toolbar.setTitle(getApplicationContext().getResources().getString(R.string.app_name));
		setSupportActionBar(toolbar);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		
		
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
		NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
				@Override
				public boolean onNavigationItemSelected(MenuItem menuItem)
				{
					drawerLayout.closeDrawer(GravityCompat.START);
					displaySelectedScreen(menuItem);
					return true;
				}
			});
		
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,0,0);
		drawerLayout.setDrawerListener(toggle);
		toggle.syncState();
		
	  TextView tv1 = (TextView)findViewById(R.id.homeTextView1);
		Spanned text = Html.fromHtml("We are a "+'"'+"</b>Not for Profit</b>"+'"'+" trust venture building Wellness on wheels (<b>The Tann Mann Gaadi</b>) to address the serious problem of open defecation which is a major health risk for all in developing countries." );
			
        tv1.setText(text);
	
		
    }
	
	private void displaySelectedScreen(MenuItem menuItem)
	{

		menuItem.setChecked(true);
		switch (menuItem.getItemId())
		{

			case R.id.contectus:
				startActivity(new Intent(this, ContectUs.class));
				break;
			case R.id.oursolution:
				startActivity(new Intent(this, OurSolution.class));
				break;
			case R.id.signupa:
				startActivity(new Intent(this, Signup.class));
				break;
			case R.id.taktous:
				startActivity(new Intent(this, TalkToUs.class));
				break;
			case R.id.event:
				startActivity(new Intent(this, Event.class));
				break;
			case R.id.logina:
				startActivity(new Intent(this, Login.class));
				break;
			
	        case R.id.send_feadback:
				Intent Email = new Intent(Intent.ACTION_SEND);
				Email.setType("text/email");
				Email.putExtra(Intent.EXTRA_EMAIL, new String[] { getResources().getString(R.string.email) });
				Email.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name) + " Feedback");
				Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
				startActivity(Intent.createChooser(Email, "Send Feedback:"));
				break;
			case R.id.share:
				Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
				sharingIntent.setType("text/plain");
				sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Trading Virtual Live Free");
				sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Best Live Virtual trading with Macd crossing and price alerts app for Android   : https://play.google.com/store/apps/details?id=" + getPackageName());
				startActivity(Intent.createChooser(sharingIntent, "Share using"));
				break;
			case R.id.exit:
				finish();
				break; 



		}
	}
	
  
}
