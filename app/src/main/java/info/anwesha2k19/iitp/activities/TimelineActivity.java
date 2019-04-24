package info.anwesha2k19.iitp.activities;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import info.anwesha2k19.iitp.R;
import info.anwesha2k19.iitp.adapters.TimelineFragmentAdapter;

public class TimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        getSupportActionBar().setElevation(0);

        ViewPager viewPager = (ViewPager) findViewById(R.id.timeline_viewpager);
        TimelineFragmentAdapter pagerAdapter = new TimelineFragmentAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.timeline_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
