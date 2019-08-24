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

public class MultiFragment extends Fragment {
    public MultiFragment() {
    }

    private ListView multi_list;
    private int color_list = (R.color.multiTextLList);

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i) {
                case 0:
                    setLevelInfo(10, 20, 1);
                    moveToPlay(GameActivity.class);
                    break;
                case 1:
                    setLevelInfo(20, 30, 2);
                    moveToPlay(GameActivity.class);
                    break;
                case 2:
                    setLevelInfo(30, 40, 3);
                    moveToPlay(GameActivity.class);
                    break;
                case 3:
                    setLevelInfo(40, 50, 4);
                    moveToPlay(GameActivity.class);
                    break;
                case 4:
                    setLevelInfo(50, 60, 5);
                    moveToPlay(GameActivity.class);
                    break;
                case 5:
                    setLevelInfo(60, 70, 6);
                    moveToPlay(GameActivity.class);
                    break;
                case 6:
                    setLevelInfo(70, 80, 7);
                    moveToPlay(GameActivity.class);
                    break;
                case 7:
                    setLevelInfo(80, 90, 8);
                    moveToPlay(GameActivity.class);
                    break;
                case 8:
                    setLevelInfo(90, 100, 9);
                    moveToPlay(GameActivity.class);
                    break;
                case 9:
                    setLevelInfo(100, 110, 10);
                    moveToPlay(GameActivity.class);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_multi, container, false);
        //define ListView by it's ID
        multi_list = (ListView) view.findViewById(R.id.MultiList);

        //make items on ListView able
        multi_list.setOnItemClickListener(onItemClickListener);

        //create ArrayAdapter
        ListViewContent multi_levels = new ListViewContent(getActivity(), arrayList());
        multi_list.setAdapter(multi_levels);
        return view;
    }

    //create ArrayList to carry Levels's Name
    private ArrayList<ContentOfList> arrayList() {
        ArrayList<ContentOfList> levels = new ArrayList<>();
        levels.add(new ContentOfList("Level 1", R.drawable.onemulti, color_list));
        levels.add(new ContentOfList("Level 2", R.drawable.twomulti, color_list));
        levels.add(new ContentOfList("Level 3", R.drawable.threemulti, color_list));
        levels.add(new ContentOfList("Level 4", R.drawable.fourmulti, color_list));
        levels.add(new ContentOfList("Level 5", R.drawable.fivemulti, color_list));
        levels.add(new ContentOfList("Level 6", R.drawable.sixmulti, color_list));
        levels.add(new ContentOfList("Level 7", R.drawable.sevenmulti, color_list));
        levels.add(new ContentOfList("Level 8", R.drawable.eightmulti, color_list));
        levels.add(new ContentOfList("Level 9", R.drawable.ninemulti, color_list));
        levels.add(new ContentOfList("Level 10", R.drawable.tenmulti, color_list));
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
