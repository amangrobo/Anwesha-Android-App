package info.anwesha2k19.iitp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.material.appbar.AppBarLayout;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//
//import info.anwesha2k18.iitp.R;
//
//public class EventInfoActivity extends AppCompatActivity {
//
//    public static final String EXTRA_HEADER = "Header",
//            EXTRA_LONG_DESCRIPTION = "LongDescription",
//            EXTRA_RULES = "Rules",
//            EXTRA_VENUE = "Venue",
//            EXTRA_TIME = "Time",
//            EXTRA_IMAGE_ID = "ImageId",
//            EXTRA_ORGANIZERS = "Organizers",
//            EXTRA_CONTACTS = "Contacts",
//            EXTRA_ID = "ID",
//            EXTRA_CODE = "Code",
//            EXTRA_DAY = "Day",
//            EXTRA_SIZE = "Size",
//            EXTRA_FEE = "Fee",
//            EXTRA_DATE = "Date",
//            EXTRA_REG_URL = "RegURL";
//    RequestQueue mQueue;
//    Set<String> eventsReg;
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        Glide.get(getApplicationContext()).clearMemory();
//        Glide.get(getApplicationContext()).trimMemory(TRIM_MEMORY_COMPLETE);
//        System.gc();
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event_info);
//
//        mQueue = Volley.newRequestQueue(this);
//        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_tb_event_info);
//        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        // Get the Intent that started this activity and extract the strings needed
//        final Intent intent = getIntent();
//        final String header = intent.getStringExtra(EXTRA_HEADER);
//        String text = intent.getStringExtra(EXTRA_LONG_DESCRIPTION);
//        String rules = intent.getStringExtra(EXTRA_RULES);
//        final String dateTime = intent.getStringExtra(EXTRA_DATE) + ", " + intent.getStringExtra(EXTRA_TIME);
//        String venue = intent.getStringExtra(EXTRA_VENUE);
//        String imageURL = intent.getStringExtra(EXTRA_IMAGE_ID);
//        String regURL = intent.getStringExtra(EXTRA_REG_URL);
//
//        if (!regURL.equals("To be updated soon.") && !regURL.equals("") && !regURL.equals("null")) {
//            ((TextView) findViewById(R.id.event_reg_link)).setText(
//                    Html.fromHtml("<a href=\"" + regURL + "\">Register here!!</a>")
//            );
//            ((TextView) findViewById(R.id.event_reg_link)).setMovementMethod(LinkMovementMethod.getInstance());
////            Log.e("muks", "RegURL: <a href=\"" + regURL + "\">Register here!!</a>");
//        } else {
//            ((TextView) findViewById(R.id.event_reg_link)).setText(getString(R.string.will_be_updated_soon));
////            Log.e("muks", "else here");
//        }
//
//        AppBarLayout appBarLayout = findViewById(R.id.appbar_event_info);
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbarLayout.setTitle(header);
//                    isShow = true;
//                } else if (isShow) {
//                    collapsingToolbarLayout.setTitle(" ");//careful there should a space between double quote otherwise it wont work
//                    isShow = false;
//                }
//            }
//        });
//
//        ((TextView) findViewById(R.id.event_info_name)).setText(header);
//        Glide.with(this)
//                .load(imageURL)
//                .apply(new RequestOptions().error(R.drawable.anwesha_placeholder))
//                .into((ImageView) findViewById(R.id.event_info_imageview));
//
//        if (text.equals("-1"))
//            text = "No Information Available";
//        final String finalText = text;
//        ((TextView) findViewById(R.id.event_info_textview)).setText(text);
//
////        Log.e("muks", "rules = " + rules);
//        if (!rules.equals("To be updated soon.") && !rules.equals("") && !rules.equals("null")) {
//            TextView rulesTextView = findViewById(R.id.event_rules_textview);
//            rulesTextView.setText(Html.fromHtml("<a href=\"" + rules + "\">Find the rules here.</a>"));
//            Log.e("muks", "Rules: <a href=\"" + rules + "\">Find the rules here.</a>");
//            rulesTextView.setMovementMethod(LinkMovementMethod.getInstance());
//        }
//
//        String organizers = intent.getStringExtra(EXTRA_ORGANIZERS);
////        final String contacts = intent.getStringExtra(EXTRA_CONTACTS);
////        if (organizers.equals("-1"))
////            organizers = "No information available";
//        ((TextView) findViewById(R.id.event_organizers)).setText(organizers);
////        ((TextView) findViewById(R.id.event_contact)).setText(contacts);
//
//        ((TextView) findViewById(R.id.event_date_time)).setText(dateTime);
//        ((TextView) findViewById(R.id.event_venue)).setText(venue);
//
//        FloatingActionButton fab = findViewById(R.id.fab_share_event);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Resources resources = getResources();
//                String shareString = resources.getText(R.string.share_message) + "\n"
//                        + resources.getText(R.string.name) + ": " + header + "\n"
//                        + resources.getText(R.string.date_time) + ": " + dateTime + "\n"
//                        + finalText;
//                Intent shareIntent = new Intent();
//                shareIntent.setAction(Intent.ACTION_SEND);
//                shareIntent.putExtra(Intent.EXTRA_TEXT, shareString);
//                shareIntent.setType("text/plain");
//                startActivity(Intent.createChooser(shareIntent, resources.getText(R.string.share_to)));
//            }
//        });
//
//        final Button button = findViewById(R.id.btn_register);
//        final TextView alreadyReg = findViewById(R.id.event_already_registered);
//        eventsReg = sharedPreferences.getStringSet(getString(R.string.events_list), null);
//
//
//        if (!header.equals("MR. AND MS. ANWESHA"))
//            findViewById(R.id.event_reg_link).setVisibility(View.GONE);
//        else
//            button.setVisibility(View.INVISIBLE);
//
//        if (!header.equals("MR. AND MS. ANWESHA") && eventsReg != null && eventsReg.contains(header)) {
//            button.setVisibility(View.INVISIBLE);
//            alreadyReg.setVisibility(View.VISIBLE);
//        } else {
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (!sharedPreferences.getBoolean(getString(R.string.login_status), false))
//                        Toast.makeText(getApplicationContext(), R.string.sign_in_first, Toast.LENGTH_LONG).show();
//                    else {
//                        button.setVisibility(View.INVISIBLE);
//                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anwesha.info/register/" + intent.getIntExtra(EXTRA_ID, -1),
//                                new Response.Listener<String>() {
//                                    @Override
//                                    public void onResponse(String response) {
//                                        Log.v("Response:", response);
//                                        try {
//                                            JSONObject jsonObject = new JSONObject(response);
//                                            boolean status = jsonObject.getBoolean(getString(R.string.JSON_status));
//
//                                            if (status) {
//                                                alreadyReg.setVisibility(View.VISIBLE);
//                                                eventsReg.add(header);
//                                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                                editor.putStringSet(getString(R.string.events_list), eventsReg);
//                                                editor.apply();
//                                            }
//
//                                            Toast.makeText(getApplicationContext(), jsonObject.getString("msg"), Toast.LENGTH_LONG).show();
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                            button.setVisibility(View.VISIBLE);
//                                        }
//                                    }
//                                },
//                                new Response.ErrorListener() {
//                                    @Override
//                                    public void onErrorResponse(VolleyError error) {
//                                        Log.v("Error : ", error.toString());
//                                        error.printStackTrace();
//                                        button.setVisibility(View.VISIBLE);
//                                        Toast.makeText(getApplicationContext(), "Please ensure that you have an active internet conection", Toast.LENGTH_LONG).show();
//                                    }
//                                }
//                        ) {
//                            @Override
//                            protected Map<String, String> getParams() throws AuthFailureError {
//                                Map<String, String> params = new HashMap<>();
//                                params.put("userID", sharedPreferences.getString(getString(R.string.anwesha_id), ""));
//                                params.put("authKey", sharedPreferences.getString(getString(R.string.key), ""));
//                                return params;
//                            }
//
//                            @Override
//                            public Map<String, String> getHeaders() throws AuthFailureError {
//                                Map<String, String> headers = new HashMap<>();
//                                headers.put("Accept", "application/json");
//                                return headers;
//                            }
//                        };
//                        mQueue.add(stringRequest);
//                    }
//                }
//            });
//        }
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // Respond to the action bar's Up/Home button
//            case android.R.id.home:
//                supportFinishAfterTransition();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

import info.anwesha2k19.iitp.R;

public class EventInfoActivity extends AppCompatActivity
        implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;

    public static final String EXTRA_HEADER = "Header",
            EXTRA_LONG_DESCRIPTION = "LongDescription",
            EXTRA_RULES = "Rules",
            EXTRA_VENUE = "Venue",
            EXTRA_TIME = "Time",
            EXTRA_IMAGE_ID = "ImageId",
            EXTRA_ORGANIZERS = "Organizers",
            EXTRA_CONTACTS = "Contacts",
            EXTRA_ID = "ID",
            EXTRA_CODE = "Code",
            EXTRA_DAY = "Day",
            EXTRA_SIZE = "Size",
            EXTRA_FEE = "Fee",
            EXTRA_DATE = "Date",
            EXTRA_REG_URL = "RegURL";
    RequestQueue mQueue;
    Set<String> eventsReg;

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(getApplicationContext()).clearMemory();
        Glide.get(getApplicationContext()).trimMemory(TRIM_MEMORY_COMPLETE);
        System.gc();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        mQueue = Volley.newRequestQueue(this);
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // Get the Intent that started this activity and extract the strings needed
        final Intent intent = getIntent();
        final String header = intent.getStringExtra(EXTRA_HEADER);
        String text = intent.getStringExtra(EXTRA_LONG_DESCRIPTION);
        String rules = intent.getStringExtra(EXTRA_RULES);
        final String dateTime = intent.getStringExtra(EXTRA_DATE) + ", " + intent.getStringExtra(EXTRA_TIME);
        String venue = intent.getStringExtra(EXTRA_VENUE);
        String imageURL = intent.getStringExtra(EXTRA_IMAGE_ID);
        String regURL = intent.getStringExtra(EXTRA_REG_URL);

        if (!regURL.equals("To be updated soon.") && !regURL.equals("") && !regURL.equals("null")) {
            ((TextView) findViewById(R.id.event_reg_link)).setText(
                    Html.fromHtml("<a href=\"" + regURL + "\">Register here!!</a>")
            );
            ((TextView) findViewById(R.id.event_reg_link)).setMovementMethod(LinkMovementMethod.getInstance());
//            Log.e("muks", "RegURL: <a href=\"" + regURL + "\">Register here!!</a>");
        } else {
            ((TextView) findViewById(R.id.event_reg_link)).setText(getString(R.string.will_be_updated_soon));
//            Log.e("muks", "else here");
        }
        ((TextView) findViewById(R.id.event_info_name)).setText(header);
        ((TextView) findViewById(R.id.main_textview_title)).setText(header);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/timetable-grobo.appspot.com/o/Black%20v2%5B536%5D.jpg?alt=media&token=f55229c3-d3ff-4f5b-b3db-68808947f8e7")
                .apply(new RequestOptions().error(R.drawable.anwesha_placeholder))
                .into((ImageView) findViewById(R.id.event_info_imageview));

        if (text.equals("-1"))
            text = "No Information Available";
        final String finalText = text;
        ((TextView) findViewById(R.id.event_info_textview)).setText(text);

//        Log.e("muks", "rules = " + rules);
        if (!rules.equals("To be updated soon.") && !rules.equals("") && !rules.equals("null")) {
            TextView rulesTextView = findViewById(R.id.event_rules_textview);
            rulesTextView.setText(Html.fromHtml("<a href=\"" + rules + "\">Find the rules here.</a>"));
            Log.e("muks", "Rules: <a href=\"" + rules + "\">Find the rules here.</a>");
            rulesTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }

        String organizers = intent.getStringExtra(EXTRA_ORGANIZERS);
//        final String contacts = intent.getStringExtra(EXTRA_CONTACTS);
//        if (organizers.equals("-1"))
//            organizers = "No information available";
        ((TextView) findViewById(R.id.event_organizers)).setText(organizers);
//        ((TextView) findViewById(R.id.event_contact)).setText(contacts);

        ((TextView) findViewById(R.id.event_date_time)).setText(dateTime);
        ((TextView) findViewById(R.id.event_venue)).setText(venue);

        bindActivity();

        mAppBarLayout.addOnOffsetChangedListener(this);

        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
        final Button button = findViewById(R.id.btn_register);
        final TextView alreadyReg = findViewById(R.id.event_already_registered);
        eventsReg = sharedPreferences.getStringSet(getString(R.string.events_list), null);


        if (!header.equals("MR. AND MS. ANWESHA"))
            findViewById(R.id.event_reg_link).setVisibility(View.GONE);
        else
            button.setVisibility(View.INVISIBLE);

        if (!header.equals("MR. AND MS. ANWESHA") && eventsReg != null && eventsReg.contains(header)) {
            button.setVisibility(View.INVISIBLE);
            alreadyReg.setVisibility(View.VISIBLE);
        } else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!sharedPreferences.getBoolean(getString(R.string.login_status), false))
                        Toast.makeText(getApplicationContext(), R.string.sign_in_first, Toast.LENGTH_LONG).show();
                    else {
                        button.setVisibility(View.INVISIBLE);
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anwesha.info/register/" + intent.getIntExtra(EXTRA_ID, -1),
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.v("Response:", response);
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            boolean status = jsonObject.getBoolean(getString(R.string.JSON_status));

                                            if (status) {
                                                alreadyReg.setVisibility(View.VISIBLE);
                                                eventsReg.add(header);
                                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                                editor.putStringSet(getString(R.string.events_list), eventsReg);
                                                editor.apply();
                                            }

                                            Toast.makeText(getApplicationContext(), jsonObject.getString("msg"), Toast.LENGTH_LONG).show();
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                            button.setVisibility(View.VISIBLE);
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.v("Error : ", error.toString());
                                        error.printStackTrace();
                                        button.setVisibility(View.VISIBLE);
                                        Toast.makeText(getApplicationContext(), "Please ensure that you have an active internet conection", Toast.LENGTH_LONG).show();
                                    }
                                }
                        ) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                params.put("userID", sharedPreferences.getString(getString(R.string.anwesha_id), ""));
                                params.put("authKey", sharedPreferences.getString(getString(R.string.key), ""));
                                return params;
                            }

                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                Map<String, String> headers = new HashMap<>();
                                headers.put("Accept", "application/json");
                                return headers;
                            }
                        };
                        mQueue.add(stringRequest);
                    }
                }
            });

        }
    }
    private void bindActivity() {
        mToolbar        = (Toolbar) findViewById(R.id.main_toolbar);
        mTitle          = (TextView) findViewById(R.id.main_textview_title);
        mTitleContainer = (LinearLayout) findViewById(R.id.main_linearlayout_title);
        mAppBarLayout   = (AppBarLayout) findViewById(R.id.main_appbar);
    }



    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}