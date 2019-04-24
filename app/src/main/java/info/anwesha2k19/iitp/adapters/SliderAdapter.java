package info.anwesha2k19.iitp.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SliderAdapter extends PagerAdapter {
        Context context;
        TypedArray images;

        public SliderAdapter(Context context, TypedArray images) {
            this.context=context;
            this.images=images;
        }

    @Override
    public int getCount() {
        return images.length();
    }

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view==((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context)
                .load(images.getResourceId(position, -1))
                .into(imageView);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}
