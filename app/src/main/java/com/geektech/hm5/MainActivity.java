package com.geektech.hm5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.geektech.hm5.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private HomeFragment homeFragment = new HomeFragment();
    private DashFragment dashFragment = new DashFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();
    private FragmentManager fn = getSupportFragmentManager();
    Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolBar);

        binding.bottomNavig.setOnNavigationItemSelectedListener(listener);

        fn.beginTransaction().add(R.id.cont, notificationFragment, "notification").hide(notificationFragment).commit();
        fn.beginTransaction().add(R.id.cont, dashFragment, "dash").hide(dashFragment).commit();
        fn.beginTransaction().add(R.id.cont,homeFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        fn.beginTransaction().hide(active).hide(active).show(homeFragment).commit();
                        binding.title.setText("Home");
                        active = homeFragment;
                        return true;
                    case R.id.dashboard_fragment:
                        fn.beginTransaction().hide(active).hide(active).show(dashFragment).commit();
                        binding.title.setText("Dash Board");
                        active = dashFragment;
                        return true;
                    case R.id.notification_fragment:
                        fn.beginTransaction().hide(active).hide(active).show(notificationFragment).commit();
                        binding.title.setText("Notification");
                        active = notificationFragment;
                        return true;
                }
                return false;
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void hideBottomNav(){
        binding.bottomNavig.setVisibility(View.GONE);
    }

    public void visibleBottomNav(){
        binding.bottomNavig.setVisibility(View.VISIBLE);
    }
}