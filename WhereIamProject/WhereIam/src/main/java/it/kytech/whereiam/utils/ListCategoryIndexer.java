package it.kytech.whereiam.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by M2K on 19/11/13.
 */
public class ListCategoryIndexer <E> {

    private HashMap<E, Integer> startIndexer;
    private HashMap<E, Integer> endIndexer;

    ArrayList <E> sections;

    private E previusKey;

    public ListCategoryIndexer(){
        startIndexer = new HashMap<E, Integer>();
        endIndexer = new HashMap<E, Integer>();
        sections = new ArrayList<E>();
        previusKey = null;
    }

    public void put(E key, int value){
        if(previusKey != null){
            endIndexer.put(previusKey, value - 1);
        }
        previusKey = key;

        startIndexer.put(key, value);
        sections.add(key);
    }

    public void endInsert(int last){
        if(previusKey != null){
            endIndexer.put(previusKey, last);
        }
        previusKey = null;
    }


    public boolean containsKey(E key){
        return startIndexer.containsKey(key);
    }

    public Object[] getSections() {
        return sections.toArray();
    }

    public int getPositionForSection(int section) {
        if(section < sections.size()){
            return startIndexer.get(sections.get(section));
        }
        return 0;
    }

    public int getSectionForPosition(int pos) {
        for (int i = 0; i < sections.size(); i++){

            E el = sections.get(i);

            int start = startIndexer.get(el);
            int end = endIndexer.get(el);

            if(pos >= start && pos<=end){
                return i;
            }
        }
        return 0;
    }

}
