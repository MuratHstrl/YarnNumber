package com.pro_ser.mobil.yarnnumber;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pro_ser.mobil.yarnnumber.fragment.CalculatorFragment;
import com.pro_ser.mobil.yarnnumber.fragment.ContactFragment;
import com.pro_ser.mobil.yarnnumber.fragment.ConverterFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;
    private FragmentManager fragmentManager;

    public void dene(View view){

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        Intent intent = new Intent(MainActivity.this,ConverterFragment.class);
        startActivity(intent);

        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, new ConverterFragment()).commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                fragment = new ConverterFragment();
                                break;
                            case R.id.navigation_dashboard:
                                fragment = new CalculatorFragment();
                                break;
                            case R.id.navigation_notifications:
                                fragment = new ContactFragment();
                                break;
                        }
                        final FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.content, fragment).commit();
                        return true;
                    }
                });

    }

}
