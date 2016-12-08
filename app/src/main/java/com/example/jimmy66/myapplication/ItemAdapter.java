package com.example.jimmy66.myapplication;

import android.content.Context;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import java.util.List;

/**
 * Created by Jimmy66 on 2016/12/9.
 */

public class ItemAdapter extends BaseAdapter{


    private Context mContext;

    private List<Item> mDatas;

    private ItemAdapter mAdapter = this;


    public ItemAdapter(Context mContext, List<Item> mDatas){
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Item getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    class ViewHolder {
        TextView textContent;

        RelativeLayout buttonDelete;
        RelativeLayout buttonSearch;
        RelativeLayout buttonStar;

        public ViewHolder(View view) {
            textContent = (TextView) view.findViewById(R.id.text_content);

            buttonDelete = (RelativeLayout) view.findViewById(R.id.delete_button);
            buttonSearch = (RelativeLayout)view.findViewById(R.id.view_button);
            buttonStar = (RelativeLayout) view.findViewById(R.id.star_button);



            view.setTag(this);
        }
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_template, null);
            new ViewHolder(convertView);
        }
        final ViewHolder holder = (ViewHolder) convertView.getTag();
        final Item item = mDatas.get(position);
        holder.textContent.setText(item.raw_content);

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Delete"+position,Toast.LENGTH_SHORT).show();
                mDatas.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });


        holder.buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Search"+position,Toast.LENGTH_SHORT).show();
                mDatas.add(item);
                mAdapter.notifyDataSetChanged();
            }
        });


        holder.buttonStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Star"+position,Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }



}
