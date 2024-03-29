package com.etiyeti.yeticalls.events.list;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etiyeti.yeticalls.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemEvent extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "Soon events";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemEvent() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemEvent newInstance(int columnCount) {
        ItemEvent fragment = new ItemEvent();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }
    public MyItemRecyclerViewAdapter.myItem getInfoFromDB(int i){
        MyItemRecyclerViewAdapter.myItem mi=new MyItemRecyclerViewAdapter.myItem("6:"+(30+i),true,"MY "+i+" EVENT!");
        return mi;

    }

    /***
     * actually here Murad will fight his demons
     * @return
     * TODO: DB Connection
     */
    public MyItemRecyclerViewAdapter.myItem getInfoFromDB2(){
        MyItemRecyclerViewAdapter.myItem mi=new MyItemRecyclerViewAdapter.myItem("6:"+(30),true,"MY "+0+" EVENT!");
        return mi;

    }

    @Override
    /***
     * If/when Murad succeds with the server it must be here
     * TODO: Add server's queries here
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_item_list, container, false);
        List<MyItemRecyclerViewAdapter.myItem> myList=new ArrayList<MyItemRecyclerViewAdapter.myItem>();

        for(int i=0;i<10;i++){
            MyItemRecyclerViewAdapter.myItem mi=new MyItemRecyclerViewAdapter.myItem(getInfoFromDB(i));
            myList.add(mi);
        }

        // Set the adapter
      //  if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(myList, mListener));//(myContent.ITEMS, mListener));
       // }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(MyItemRecyclerViewAdapter.myItem item);
    }
}
