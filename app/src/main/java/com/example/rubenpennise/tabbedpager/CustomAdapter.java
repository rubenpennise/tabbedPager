package com.example.rubenpennise.tabbedpager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ruben Pennise on 04/01/2015.
 */
public class CustomAdapter extends ArrayAdapter {

    String[] lineas;
    Integer[] imagenes;
    Context context;

    public CustomAdapter(Activity context,Integer[] image_id, String[] text){
        super(context, R.layout.list_row, text);
        // TODO Auto-generated constructor stub
        this.lineas = text;
        this.imagenes = image_id;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View single_row = inflater.inflate(R.layout.list_row, null,true);
        TextView textView = (TextView) single_row.findViewById(R.id.textViewCol);
        ImageView imageView = (ImageView) single_row.findViewById(R.id.imageViewCol);
        textView.setText(lineas[position]);
        imageView.setImageResource(imagenes[position]);
        return single_row;
    }

}
