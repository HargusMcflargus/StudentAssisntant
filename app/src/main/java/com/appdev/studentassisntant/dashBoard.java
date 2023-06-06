package com.appdev.studentassisntant;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dashBoard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dashBoard extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public dashBoard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dashBoard.
     */
    // TODO: Rename and change types and number of parameters
    public static dashBoard newInstance(String param1, String param2) {
        dashBoard fragment = new dashBoard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        String[] list = new String[]{
                "printer",
                "Kidney",
                "Jowa"
        };
        super.onActivityCreated(savedInstanceState);

        final ListView listView = getView().findViewById(R.id.borrowedList);
        final ImageView imageView = getView().findViewById(R.id.imageView);

        imageView.setImageResource(R.mipmap.tempiconloona_foreground);

        List<String> listedItems = new ArrayList<String>(Arrays.asList(list));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getView().getContext(), R.layout.listviewitemborrowed, list);
        listView.setAdapter(arrayAdapter);
    }
}