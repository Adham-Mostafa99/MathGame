package com.example.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DevFragment extends Fragment {
    private ListView dev_list;
    private int color_list = (R.color.devTextLList);
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i) {
                case 0:
                    setLevelInfo(20, 40,2,10, 1);
                    moveToPlay(GameActivity.class);
                    break;
                case 1:
                    setLevelInfo(30, 50,3,10, 2);
                    moveToPlay(GameActivity.class);
                    break;
                case 2:
                    setLevelInfo(50, 70,5,20, 3);
                    moveToPlay(GameActivity.class);
                    break;
                case 3:
                    setLevelInfo(70, 90,7,30, 4);
                    moveToPlay(GameActivity.class);
                    break;
                case 4:
                    setLevelInfo(90, 110,9,40, 5);
                    moveToPlay(GameActivity.class);
                    break;
                case 5:
                    setLevelInfo(110, 130,11,50, 6);
                    moveToPlay(GameActivity.class);
                    break;
                case 6:
                    setLevelInfo(130, 150,13,60, 7);
                    moveToPlay(GameActivity.class);
                    break;
                case 7:
                    setLevelInfo(150, 170,15,70, 8);
                    moveToPlay(GameActivity.class);
                    break;
                case 8:
                    setLevelInfo(170, 190,17,80, 9);
                    moveToPlay(GameActivity.class);
                    break;
                case 9:
                    setLevelInfo(190, 250,19,90, 10);
                    moveToPlay(GameActivity.class);
                    break;
            }
        }
    };

    public DevFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dev, container, false);

        //define ListView by it's ID
        dev_list = (ListView) view.findViewById(R.id.DevList);

        //make items on ListView able
        dev_list.setOnItemClickListener(onItemClickListener);

        //create ArrayAdapter
        ListViewContent dev_levels = new ListViewContent(getActivity(), arrayList());
        dev_list.setAdapter(dev_levels);
        return view;
    }

    //create ArrayList to carry Levels's Name
    private ArrayList<ContentOfList> arrayList() {
        ArrayList<ContentOfList> levels = new ArrayList<>();
        levels.add(new ContentOfList("Level 1", R.drawable.onedev, color_list));
        levels.add(new ContentOfList("Level 2", R.drawable.twodev, color_list));
        levels.add(new ContentOfList("Level 3", R.drawable.threedev, color_list));
        levels.add(new ContentOfList("Level 4", R.drawable.fourdev, color_list));
        levels.add(new ContentOfList("Level 5", R.drawable.fivedev, color_list));
        levels.add(new ContentOfList("Level 6", R.drawable.sixdev, color_list));
        levels.add(new ContentOfList("Level 7", R.drawable.sevendev, color_list));
        levels.add(new ContentOfList("Level 8", R.drawable.eightdev, color_list));
        levels.add(new ContentOfList("Level 9", R.drawable.ninedev, color_list));
        levels.add(new ContentOfList("Level 10", R.drawable.tendev, color_list));
        return levels;
    }

    private void moveToPlay(Class cls) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        startActivity(intent);
    }

    //set levels information
    private void setLevelInfo(int min, int max,int min_dev,int max_dev, int level) {
        GameActivity.MIN_VALUE = min;
        GameActivity.MAX_VALUE = max;
        GameActivity.MIN_VALUE_DEV=min_dev;
        GameActivity.MAX_VALUE_DEV=max_dev;
        GameActivity.LEVEL = level;
    }
}
