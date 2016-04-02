package com.etiyeti.yeticalls;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.etiyeti.yeticalls.ItemEvent.OnListFragmentInteractionListener;
import com.etiyeti.yeticalls.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<myItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<myItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTime.setText(mValues.get(position).time);
        holder.mImage.setImageResource(R.drawable.yeti_internet);
        holder.mText.setText(mValues.get(position).text);
        holder.mButton.setText("OK");
      //  holder.mIdView.setText(mValues.get(position).id);
      //  holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTime;
        public final Button mButton;
        public final ImageView mImage;
        public final TextView mText;
       // public final TextView mContentView;
        public myItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTime=(TextView) view.findViewById(R.id.timeEventItem);
            mButton=(Button) view.findViewById(R.id.buttonEventItem);
            mText = (TextView) view.findViewById(R.id.timeEventItem);
            mImage=(ImageView) view.findViewById(R.id.imageEventItem);
           // mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString();// + " '" + mContentView.getText() + "'";
        }
    }
    public static class myItem{
        public final String time;
        public final boolean isMale;
        public final String text;
        public myItem(String time, boolean isMale, String text) {
            this.time = time;
            this.isMale = isMale;
            this.text = text;
        }
        @Override
        public String toString() {
            return "1";// content;
        }
    }
}
