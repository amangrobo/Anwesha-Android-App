package info.anwesha2k19.iitp.activities;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;

import info.anwesha2k19.iitp.R;
import info.anwesha2k19.iitp.adapters.AboutPageFragmentAdapter;

/**
 * Created by Muks14x on 20/8/17.
 */

public class AboutActivity extends AppCompatActivity {
    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment info memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private AboutPageFragmentAdapter aboutPageFragmentAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Menu menu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        aboutPageFragmentAdapter = new AboutPageFragmentAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(aboutPageFragmentAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

//        int tabIcons[] = {R.drawable.ic_info_white_24dp,
//                R.drawable.ic_group_white_24dp};

//        for (int i = 0; i < aboutPageFragmentAdapter.getCount(); i++) {
//            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
//        }
    }
}
