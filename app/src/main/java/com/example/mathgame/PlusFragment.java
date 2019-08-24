package com.example.mathgame;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlusFragment extends Fragment {


    private ListView plus_list;
    private int color_list = (R.color.plusTextLList);
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i) {
                case 0:
                    setLevelInfo(10, 30, 1);
                    moveToPlay(GameActivity.class);
                    break;
                case 1:
                    setLevelInfo(30, 50, 2);
                    moveToPlay(GameActivity.class);
                    break;
                case 2:
                    setLevelInfo(50, 70, 3);
                    moveToPlay(GameActivity.class);
                    break;
                case 3:
                    setLevelInfo(70, 90, 4);
                    moveToPlay(GameActivity.class);
                    break;
                case 4:
                    setLevelInfo(90, 110, 5);
                    moveToPlay(GameActivity.class);
                    break;
                case 5:
                    setLevelInfo(110, 130, 6);
                    moveToPlay(GameActivity.class);
                    break;
                case 6:
                    setLevelInfo(130, 150, 7);
                    moveToPlay(GameActivity.class);
                    break;
                case 7:
                    setLevelInfo(150,170, 8);
                    moveToPlay(GameActivity.class);
                    break;
                case 8:
                    setLevelInfo(170, 190, 9);
                    moveToPlay(GameActivity.class);
                    break;
                case 9:
                    setLevelInfo(190, 250, 10);
                    moveToPlay(GameActivity.class);
                    break;
            }
        }
    };

    public PlusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_plus, container, false);
        //define ListView by it's ID
        plus_list = (ListView) view.findViewById(R.id.PlusList);

        //make items on ListView able
        plus_list.setOnItemClickListener(onItemClickListener);

        //create ArrayAdapter
        ListViewContent plus_levels = new ListViewContent(getActivity(), arrayList());
        plus_list.setAdapter(plus_levels);

        return view;
    }

    //create ArrayList to carry Levels's Name
    private ArrayList<ContentOfList> arrayList() {
        ArrayList<ContentOfList> levels = new ArrayList<>();
        levels.add(new ContentOfList("Level 1", R.drawable.oneplus, color_list));
        levels.add(new ContentOfList("Level 2", R.drawable.twoplus, color_list));
        levels.add(new ContentOfList("Level 3", R.drawable.threeplus, color_list));
        levels.add(new ContentOfList("Level 4", R.drawable.fourplus, color_list));
        levels.add(new ContentOfList("Level 5", R.drawable.fiveplus, color_list));
        levels.add(new ContentOfList("Level 6", R.drawable.sixplus, color_list));
        levels.add(new ContentOfList("Level 7", R.drawable.sevenplus, color_list));
        levels.add(new ContentOfList("Level 8", R.drawable.eightplus, color_list));
        levels.add(new ContentOfList("Level 9", R.drawable.nineplus, color_list));
        levels.add(new ContentOfList("Level 10", R.drawable.ten, color_list));
        return levels;
    }

    private void moveToPlay(Class cls) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        startActivity(intent);
    }

    //set levels information
    private void setLevelInfo(int min, int max, int level) {
        GameActivity.MIN_VALUE = min;
        GameActivity.MAX_VALUE = max;
        GameActivity.LEVEL = level;
    }

}
