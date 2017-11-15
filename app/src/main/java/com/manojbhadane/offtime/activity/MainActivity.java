package com.manojbhadane.offtime.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.manojbhadane.offtime.App;
import com.manojbhadane.offtime.R;
import com.manojbhadane.offtime.adapter.ProfileAdapter;
import com.manojbhadane.offtime.database.Profile;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProfileAdapter.OnItemClickListener
{
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Profile> mArrayList;
    private ProfileAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        mArrayList = new ArrayList<>();

        insertData();

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(mLayoutManager);
        getData();

    }

    private void insertData()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5; i++)
                {
                    Profile model = new Profile();
                    model.setProfileName("Profile " + i);
                    mArrayList.add(model);
                }
                App.get().getDBInstance().profileDao().insertAll(mArrayList);
            }
        }).start();

    }

    private void getData()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                mArrayList = (ArrayList<Profile>) App.get().getDBInstance().profileDao().getAllProfiles();
                mAdapter = new ProfileAdapter(MainActivity.this, mArrayList,MainActivity.this);
                mRecyclerView.setAdapter(mAdapter);
            }
        }).start();
    }

    @Override
    public void onItemClick(int position)
    {
        startActivity(new Intent(this, DetailsActivity.class));
    }
}
