package it.kytech.whereiam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import it.kytech.whereiam.R;
import it.kytech.whereiam.utils.Tag;

public class TagListAdapter extends ArrayAdapter<Tag> implements SectionIndexer {

    private final Context context;
    private final ArrayList<Tag> itemsArrayList;

    HashMap<String, Integer> alphaIndexer;
    String[] sections;

    public TagListAdapter(Context context, ArrayList<Tag> itemsArrayList) {

        super(context, R.layout.list_row, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
        int size = itemsArrayList.size();

        alphaIndexer = new HashMap<String, Integer>();

        Collections.sort(this.itemsArrayList);

        for (int x = 0; x < size; x++) {
            String s = itemsArrayList.get(x).getTag();

            String ch = s.substring(0, 1);
            ch = ch.toUpperCase();

            if (!alphaIndexer.containsKey(ch)){
                alphaIndexer.put(ch, x);
            }
        }

        Set<String> sectionLetters = alphaIndexer.keySet();

        // create a list from the set to sort
        ArrayList<String> sectionList = new ArrayList<String>(sectionLetters);

        Collections.sort(sectionList);

        sections = new String[sectionList.size()];

        sectionList.toArray(sections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.list_row, parent, false);

        // 3. Get the two text view from the rowView
        TextView labelView = (TextView) rowView.findViewById(R.id.list_row_label);
        TextView latitudeView = (TextView) rowView.findViewById(R.id.list_row_latitude);
        TextView longitudeView = (TextView) rowView.findViewById(R.id.list_row_longitude);

        // 4. Set the text for textView
        labelView.setText(itemsArrayList.get(position).getTag());
        latitudeView.setText(itemsArrayList.get(position).getLatitude() + "°");
        longitudeView.setText(itemsArrayList.get(position).getLongitude()+ "°");

        // 5. retrn rowView
        return rowView;
    }

    @Override
    public Object[] getSections() {
        return sections;
    }

    @Override
    public int getPositionForSection(int i) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int i) {
        if(i < sections.length){
            return alphaIndexer.get(sections[i]);
        }
        return 0;
    }
}
