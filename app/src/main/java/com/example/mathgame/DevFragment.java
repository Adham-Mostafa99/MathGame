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
    public DevFragment() {
    }

    private ListView dev_list;
    private int color_list = (R.color.devTextLList);

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i) {
                case 0:
//                    moveToPlay();
//                    break;
//                case 1:
//                    moveToPlay();
//                    break;
//                case 2:
//                    moveToPlay();
//                    break;
//                case 3:
//                    moveToPlay();
//                    break;
//                case 4:
//                    moveToPlay();
//                    break;
//                case 5:
//                    moveToPlay();
//                    break;
//                case 6:
//                    moveToPlay();
//                    break;
//                case 7:
//                    moveToPlay();
//                    break;
//                case 8:
//                    moveToPlay();
//                    break;
//                case 9:
//                    moveToPlay();
                    break;
            }
        }
    };


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
}
