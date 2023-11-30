package com.example.exam2023android_davidgeorgievpetrunov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private ArrayList<String> names;
    private ArrayList<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate", "HEYYYYY");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "HEYYYYY");
        addNamesToList();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (names.get(position).equals("frag1")){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView2, Fragment1.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack("name")
                            .commit();
                } else if (names.get(position).equals("frag2")){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView2, Fragment2.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack("name")
                            .commit();
                }else if (names.get(position).equals("frag3")){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView2, Fragment3.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack("name")
                            .commit();
                }else if (names.get(position).equals("frag4")){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView2, Fragment4.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack("name")
                            .commit();
                }
                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                } else {
                    findViewById(R.id.fragmentContainerView).setVisibility(View.GONE);
                }
                findViewById(R.id.fragmentContainerView2).setVisibility(View.VISIBLE);
            }
        });

    }

    private void addNamesToList() {
        listview = (ListView) findViewById(R.id.listView);
        names = new ArrayList<String>();
        names.add("frag1");
        names.add("frag2");
        names.add("frag3");
        names.add("frag4");

        images = new ArrayList<Integer>();
        images.add( R.drawable.chimeneaapagada);
        images.add(R.drawable.descarga);
        images.add(R.drawable.imagen3);
        images.add(R.drawable.imagen);

        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, names, images);
        listview.setAdapter(myAdapter);
    }

    public void fragmentStart(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, FragmentStart.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
        findViewById(R.id.fragmentContainerView2).setVisibility(View.GONE);
    }
}
