package com.ihm.zoopedia;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ihm.zoopedia.databinding.ActivityHorairesBinding;

public class HorairesAdapter extends AppCompatActivity {

    ActivityHorairesBinding binding;

    // tab titles
    private final String[] titles = new String[]{"Zoo", "Spectacles", "Restaurants"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Nan mais allo quoi ?");
        binding = ActivityHorairesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        // removing toolbar elevation
        binding.viewPager.setAdapter(new ViewPagerFragmentAdapter(this));

        // attaching tab mediator
        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> tab.setText(titles[position])).attach();
    }

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {

        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new HorairesZooFragment();
                case 1:
                    return new HorairesSpectaclesFragment();
                case 2:
                    return new HorairesRestaurantFragment();
            }
            return new HorairesZooFragment();
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }
}