package info.anwesha2k19.iitp.adapters;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import info.anwesha2k19.iitp.fragments.TimelineFragment;

public class TimelineFragmentAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Day 1", "Day 2", "Day 3" };
    private Context mContext;

    public TimelineFragmentAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return TimelineFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
