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
}
