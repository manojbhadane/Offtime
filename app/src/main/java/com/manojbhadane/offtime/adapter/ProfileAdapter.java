package com.manojbhadane.offtime.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manojbhadane.offtime.R;
import com.manojbhadane.offtime.database.Profile;
import com.manojbhadane.offtime.model.ProfileModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by manoj.bhadane on 15-11-2017.
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder>
{
    private Context mContext;
    private ArrayList<Profile> arrayList;
    OnItemClickListener mListener;

    public ProfileAdapter(Context context, ArrayList<Profile> arrayList, OnItemClickListener listener)
    {
        mListener = listener;
        mContext = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_profile, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        holder.txt_profile_name.setText(arrayList.get(position).getProfileName());

        holder.txt_profile_name.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_profile_name;

        public ViewHolder(View itemView)
        {
            super(itemView);
            txt_profile_name = (TextView) itemView.findViewById(R.id.txt_profile_name);
        }
    }

    public interface OnItemClickListener
    {
        public void onItemClick(int position);
    }
}
