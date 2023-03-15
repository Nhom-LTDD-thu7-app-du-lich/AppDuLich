package com.example.doan_tourdulich;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Binder;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.doan_tourdulich.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import Fragment.AdapterView;
import Fragment.Fragment_ListTour;

public class MainActivity extends AppCompatActivity{


    ActivityMainBinding binding;
    private ViewPager viewPager;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         int[] imageId= {R.drawable.chau_doc, R.drawable.chua_vinh_trang, R.drawable.du_lich_can_gio, R.drawable.du_lich_da_lat, R.drawable. du_lich_nha_trang, R.drawable.du_lich_phu_quoc, R.drawable.du_lich_vung_tau, R.drawable.my_tho_ben_tre, R.drawable.nui_ba_den, R.drawable.phan_thiet};
         String[] name={"Châu Đốc 2 ngày 1 đêm", "Vĩnh Tràng 2 ngày 1 đêm", "Cần Giờ 1 ngày", "Đà Lạt 3 ngày 2 đêm", "Nha Trang 4 ngày 3 đêm", "Phú Quốc 4 ngày 3 đêm", "Vũng Tàu 1 ngày", "MT - BT 2 ngày 1 đêm", "Bà Đen 2 ngày 1 đêm", "Phan Thiết 4 ngày 3 đêm"};
         String[] price={"3.500.000đ","3.400.000đ", "3.200.000đ", "5.500.000đ", "6.500.000đ", "7.400.000đ", "8.000.000đ", "2.500.000đ", "3.200,000đ", "4.000.000đ", "8.700.000đ"};
         ArrayList<TourTravel> tourTravelArrayList=new ArrayList<>();
         for(int i = 0; i<imageId.length;i++){
             TourTravel tourTravel=new TourTravel(name[i], price[i], imageId[i]);
             tourTravelArrayList.add(tourTravel);
         }
         AdapterTravelTour adapterTravelTour=new AdapterTravelTour(MainActivity.this, tourTravelArrayList);
         //binding.listView.setAdapter(adapterTravelTour);
         //binding.listView.setClickable(true);







        viewPager=findViewById(R.id.viewpager);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        AdapterView adapterView=new AdapterView(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapterView);



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.action_dn).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.action_tour).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Trang chủ", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_dn:
                        Toast.makeText(MainActivity.this, "Đăng nhập", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.action_tour:
                        Toast.makeText(MainActivity.this, "Danh sách tour", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }


}