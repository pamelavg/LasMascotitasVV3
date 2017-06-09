package com.krivic.lasmascotitasv3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.krivic.lasmascotitasv3.adapter.PageAdapter;
import com.krivic.lasmascotitasv3.fragment.recyclerview;
import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> listaMascotas;
    ArrayList<Mascotas> listaMascotasFavoritas;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        if(toolbar!=null)
        {
            setSupportActionBar(toolbar);
        }

        Toolbar actionBar = (Toolbar) findViewById(R.id.ActionBar);
        setSupportActionBar(actionBar);
        setUpViewPager();

    }


    public Toolbar toolbar(int id) {
        Toolbar t = (Toolbar) findViewById(id);
        setSupportActionBar(t);
        return t;
    }
    public void clickEstrella(View v){

        Intent i = new Intent(MainActivity.this, com.krivic.lasmascotitasv3.MascotasFavoritas.class);

        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId())
        {

            case R.id.mContacto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                intent = new Intent(this, AcercaDe.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragment()
    {
        ArrayList<Fragment>fragments= new ArrayList<>();
        fragments.add(new recyclerview());
        fragments.add(new com.krivic.lasmascotitasv3.Perfil());
        return fragments;
    }
    private void setUpViewPager()
    {
viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
  tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.dog);
    }
}
