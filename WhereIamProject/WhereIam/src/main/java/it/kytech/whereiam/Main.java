package it.kytech.whereiam;


import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import it.kytech.whereiam.adapters.TagListAdapter;
import it.kytech.whereiam.utils.Tag;

public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. pass context and data to the custom adapter
        TagListAdapter adapter = new TagListAdapter(this, generateData());

        // 2. Get ListView from activity_main.xml
        ListView listView = (ListView) findViewById(R.id.tag_list);

        // 3. setListAdapter
        listView.setAdapter(adapter);

        listView.setFastScrollEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            listView.setFastScrollAlwaysVisible(true);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Tag> generateData(){
        ArrayList<Tag> items = new ArrayList<Tag>();
        items.add(new Tag("New York","40.716667", "-74"));
        items.add(new Tag("Venice", "45.439722", "12.331944"));
        items.add(new Tag("Tokyo","35.689506", "139.6917"));

        Random r=new Random();
        for(int i=0;i<50;i++){
            items.add(items.get(r.nextInt(items.size())));
        }

        return items;
    }
}
