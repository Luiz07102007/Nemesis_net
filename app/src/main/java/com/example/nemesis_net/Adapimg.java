package com.example.nemesis_net;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapimg extends BaseAdapter {
    Context context;
    String nomejogos[];
    int iconejogos[];
    LayoutInflater inflater;

    public Adapimg(Context ctx, String[] jogos, int [] icones){
        this.context = ctx;
        this.nomejogos = jogos;
        this.iconejogos=icones;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return iconejogos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_item, null);
        TextView nomejogo=(TextView) view.findViewById(R.id.nomejogo);
        ImageView iconejogo=(ImageView) view.findViewById(R.id.iconejogo);
        nomejogo.setText(nomejogos[i]);
        iconejogo.setImageResource(iconejogos[i]);
        return view;
    }
}
