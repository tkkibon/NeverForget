package com.example.takak.neverforget;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MysizeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MysizeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public MysizeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MysizeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment newInstance(Context context) {
        MysizeFragment f = new MysizeFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_mysize, null);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();;
        SharedPreferences prefs = this.getActivity().getSharedPreferences("mysize",
                Context.MODE_PRIVATE);
        int neck = prefs.getInt("neck", 0);
        int sleeve = prefs.getInt("sleeve", 0);
        int waist = prefs.getInt("waist", 0);
        int insideleg = prefs.getInt("insideleg", 0);
        EditText edText1 = (EditText) getView().findViewById(R.id.editText1);
        if(neck != 0){
            edText1.setText(Integer.toString(neck));
        }
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        if(sleeve != 0){
            edText2.setText(Integer.toString(sleeve));
        }
        EditText edText3 = (EditText) getView().findViewById(R.id.editText3);
        if(waist != 0){
            edText3.setText(Integer.toString(waist));
        }
        EditText edText4 = (EditText) getView().findViewById(R.id.editText4);
        if(insideleg != 0){
            edText4.setText(Integer.toString(insideleg));
        }
    }
    @Override
    public void onPause(){
        super.onPause();
        EditText edText1 = (EditText) getView().findViewById(R.id.editText1);
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        EditText edText3 = (EditText) getView().findViewById(R.id.editText3);
        EditText edText4 = (EditText) getView().findViewById(R.id.editText4);

        int neck;
        try{
            neck = Integer.parseInt(edText1.getText().toString());
        }
        catch(NumberFormatException e){
            neck = 0;
        }

        int sleeve;
        try{
            sleeve = Integer.parseInt(edText2.getText().toString());
        }
        catch(NumberFormatException e){
            sleeve = 0;
        }

        int waist;
        try{
            waist = Integer.parseInt(edText3.getText().toString());
        }
        catch(NumberFormatException e){
            waist = 0;
        }

        int insideleg;
        try{
            insideleg = Integer.parseInt(edText4.getText().toString());
        }
        catch(NumberFormatException e){
            insideleg = 0;
        }

        //保存
        SharedPreferences prefs = this.getActivity().getSharedPreferences("mysize",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("neck", neck);
        editor.putInt("sleeve", sleeve);
        editor.putInt("waist", waist);
        editor.putInt("insideleg", insideleg);
        editor.apply();
    }


}
