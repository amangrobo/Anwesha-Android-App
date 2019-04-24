package info.anwesha2k19.iitp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import info.anwesha2k19.iitp.R;
import info.anwesha2k19.iitp.adapters.EventFragmentAdapter;

public class EventsActivityNew extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_tabs);

        getSupportActionBar().setElevation(0);

        ViewPager viewPager = (ViewPager) findViewById(R.id.event_viewpager);
        EventFragmentAdapter pagerAdapter = new EventFragmentAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.event_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
