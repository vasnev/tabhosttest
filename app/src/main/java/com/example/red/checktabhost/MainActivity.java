package com.example.red.checktabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // получаем TabHost
        //TabHost tabHost = getTabHost();

        // инициализация была выполнена в getTabHost
        // метод setup вызывать не нужно
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            public void onTabChanged(String tabId) {
                //Now what?
                //Object.refreshDrawableState();
                TextView tw = (TextView)findViewById(R.id.textView);
                tw.setText(tabId);
            }
        });
        mTabHost.addTab(mTabHost.newTabSpec("Evnt").setIndicator("Events"),
                EventsActivity.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Clnt").setIndicator("Clients"),
                ClientsActivity.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Gds").setIndicator("Goods"),
                GoodsActivity.class, null);
        /*
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("Evnt");
        tabSpec.setIndicator("Events");
        tabSpec.setContent(new Intent(this, EventsActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Clnt");
        tabSpec.setIndicator("Clients");
        tabSpec.setContent(new Intent(this, ClientsActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Gds");
        tabSpec.setIndicator("Goods");
        tabSpec.setContent(new Intent(this, GoodsActivity.class));
        tabHost.addTab(tabSpec);*/

    }
}