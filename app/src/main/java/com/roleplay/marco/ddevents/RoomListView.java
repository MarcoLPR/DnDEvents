package com.roleplay.marco.ddevents;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class RoomListView extends ArrayAdapter<String> {

    private String[] tiles;

    public final static String EXTRA_ROOM = "ROOM";
    public final static String EXTRA_ACTUALZONE = RoomActivity.EXTRA_ZONE;

    private Activity context;

    public RoomListView(Activity context, String[] tiles) {
        super(context, R.layout.roomlistview_layout, tiles);

        this.context = context;
        this.tiles = tiles;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;

        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.roomlistview_layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.tile.setText(tiles[position]);
        return r;
    }
    class ViewHolder {
        TextView tile;

        ViewHolder(View v) {
            tile = (TextView) v.findViewById(R.id.tile);
            tile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View VIew) {
                    Intent intent = new Intent(getContext(), DescriptionActivity.class);
                    String name = tile.getText().toString();
                    intent.putExtra(EXTRA_ROOM,name);
                    intent.putExtra(EXTRA_ACTUALZONE, RoomActivity.EXTRA_ZONE);
                    context.startActivity(intent);
                }

            });
        }
    }
}