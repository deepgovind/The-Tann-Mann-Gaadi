package dg.thetannmanngaadi;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

	private ViewPager viewPager;
	private MyViewPagerAdapter myViewPagerAdapter;
	private int[] layouts;
	private Button btnSkip, btnNext;
    private TextView dot_0,dot_1,dot_2;

	private ProgressBar ProgressBar;
	private LinearLayout dot_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Build.VERSION.SDK_INT >= 21) {
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		}
 
		setContentView(R.layout.welcome_activity);

		viewPager = (ViewPager) findViewById(R.id.view_pager);
		btnSkip = (Button) findViewById(R.id.btnSkip);
		btnNext = (Button) findViewById(R.id.btnNext);
		ProgressBar = (ProgressBar) findViewById(R.id.firstscreenpb);
		dot_layout = (LinearLayout)findViewById(R.id.firstscreen_dot_Ll);

		dot_0 = (TextView)findViewById(R.id.firsts_dot_0);
		dot_1 = (TextView)findViewById(R.id.firsts_dot_1);
		dot_2 = (TextView)findViewById(R.id.firsts_dot_2);

		layouts = new int[]{
			R.layout.screen_1,
			R.layout.screen_2,
			R.layout.screen_3};


		myViewPagerAdapter = new MyViewPagerAdapter();
		viewPager.setAdapter(myViewPagerAdapter);
		viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

		btnSkip.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					btnSkip.setVisibility(View.GONE);
					btnNext.setVisibility(View.GONE);
					ProgressBar.setVisibility(View.VISIBLE);
					launchHomeScreen();
				}
			});

		btnNext.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// checking for last page
					// if last page home screen will be launched
					int current = getItem(+1);
					if (current < layouts.length) {
						// move to next screen
						viewPager.setCurrentItem(current);
					} else {
						btnNext.setVisibility(View.GONE);
						dot_layout.setVisibility(View.GONE);
						ProgressBar.setVisibility(View.VISIBLE);
						launchHomeScreen();
					}
				}
			});
	}

	private int getItem(int i) {
		return viewPager.getCurrentItem() + i;
	}

	private void launchHomeScreen() {
		//startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
		finish();
	}

	//	viewpager change listener
	ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
		@Override
		public void onPageSelected(int position) {

			// changing the next button text 'NEXT' / 'GOT IT'
			if (position == layouts.length - 1) {
				btnSkip.setVisibility(View.GONE);
			} else {
				btnSkip.setVisibility(View.VISIBLE);
			}
			if (position == 0) {
				dot_0.setText("⬤");
				dot_1.setText("⭘");
				dot_2.setText("⭘");
			} else if (position == 1) {
				dot_0.setText("⭘");
				dot_1.setText("⬤");
				dot_2.setText("⭘");
			} else if (position == 2) {
				dot_0.setText("⭘");
				dot_1.setText("⭘");
				dot_2.setText("⬤");
			} 
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}

		@Override
		public void onPageScrollStateChanged(int arg0) {}
	};

	public class MyViewPagerAdapter extends PagerAdapter {
		private LayoutInflater layoutInflater;
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View view = layoutInflater.inflate(layouts[position], container, false);
			container.addView(view);

			return view;
		}

		@Override
		public int getCount() {
			return layouts.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == obj;
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			View view = (View) object;
			container.removeView(view);
		}
	}
}


