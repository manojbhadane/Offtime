package com.manojbhadane.offtime.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.manojbhadane.offtime.R;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView mTxtSun, mTxtMon, mTxtTue, mTxtWed, mTxtThr, mTxtFri, mTxtSat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setTitle("Working days");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTxtSun = (TextView) findViewById(R.id.sun);
        mTxtMon = (TextView) findViewById(R.id.mon);
        mTxtTue = (TextView) findViewById(R.id.tue);
        mTxtWed = (TextView) findViewById(R.id.wed);
        mTxtThr = (TextView) findViewById(R.id.Thr);
        mTxtFri = (TextView) findViewById(R.id.fri);
        mTxtSat = (TextView) findViewById(R.id.sat);

        mTxtSun.setOnClickListener(this);
        mTxtMon.setOnClickListener(this);
        mTxtTue.setOnClickListener(this);
        mTxtWed.setOnClickListener(this);
        mTxtThr.setOnClickListener(this);
        mTxtFri.setOnClickListener(this);
        mTxtSat.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {

    }
}
