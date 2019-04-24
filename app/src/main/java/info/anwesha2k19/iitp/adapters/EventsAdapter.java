package info.anwesha2k19.iitp.adapters;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import info.anwesha2k19.iitp.R;
import info.anwesha2k19.iitp.data.EventListData;
public class EventsAdapter extends ArrayAdapter<EventListData> {
    Context context;
    TypedArray images;

    public EventsAdapter(Context context, int resource, List<EventListData> objects){
        super(context,resource,objects);

    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView=((Activity) getContext()).getLayoutInflater().inflate(R.layout.card_view,parent,false);
        }
        EventListData currentEvent=getItem(position);

        TextView eventDescDisplay=(TextView) convertView.findViewById(R.id.card_text);
        TextView eventTextDisplay=(TextView) convertView.findViewById(R.id.card_header);


        eventTextDisplay.setText(currentEvent.geteveName());

        eventDescDisplay.setText(currentEvent.getshort_desc());



        return  convertView;
    }
}
