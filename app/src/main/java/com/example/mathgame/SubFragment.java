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

public class SubFragment extends Fragment {
    public SubFragment() {
    }

    private ListView sub_list;
    private int color_list = (R.color.subTextLList);

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
        View view = inflater.inflate(R.layout.activity_sub, container, false);

        //define ListView by it's ID
        sub_list = (ListView) view.findViewById(R.id.SubList);

        //make items on ListView able
        sub_list.setOnItemClickListener(onItemClickListener);

        //create ArrayAdapter
        ListViewContent sub_levels = new ListViewContent(getActivity(), arrayList());
        sub_list.setAdapter(sub_levels);
        return view;
    }
    //create ArrayList to carry Levels's Name
    private ArrayList<ContentOfList> arrayList() {
        ArrayList<ContentOfList> levels = new ArrayList<>();
        levels.add(new ContentOfList("Level 1", R.drawable.onesub, color_list));
        levels.add(new ContentOfList("Level 2", R.drawable.twosub, color_list));
        levels.add(new ContentOfList("Level 3", R.drawable.threesub, color_list));
        levels.add(new ContentOfList("Level 4", R.drawable.foursub, color_list));
        levels.add(new ContentOfList("Level 5", R.drawable.fivesub, color_list));
        levels.add(new ContentOfList("Level 6", R.drawable.sixsub, color_list));
        levels.add(new ContentOfList("Level 7", R.drawable.sevensub, color_list));
        levels.add(new ContentOfList("Level 8", R.drawable.eightsub, color_list));
        levels.add(new ContentOfList("Level 9", R.drawable.ninesub, color_list));
        levels.add(new ContentOfList("Level 10", R.drawable.tensub, color_list));
        return levels;
    }

    private void moveToPlay(Class cls) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        startActivity(intent);
    }
}
