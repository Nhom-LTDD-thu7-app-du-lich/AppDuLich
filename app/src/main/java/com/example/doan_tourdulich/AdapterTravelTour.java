package com.example.doan_tourdulich;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterTravelTour  extends ArrayAdapter<TourTravel> {
    public AdapterTravelTour(Context context, ArrayList<TourTravel> tourTravelArrayList){
        super(context, R.layout.fragment__list_tour, tourTravelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TourTravel tourTravel=getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment__list_tour, parent, false);
        }
        ImageView imageView=convertView.findViewById(R.id.img_tour);
        TextView nameTour=convertView.findViewById(R.id.tv_name);
        TextView priceTour=convertView.findViewById(R.id.tv_price);

        imageView.setImageResource(tourTravel.imageId);
        nameTour.setText(tourTravel.name);
        priceTour.setText(tourTravel.price);
        return super.getView(position, convertView, parent);
    }
}
