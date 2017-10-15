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



public class DungeonListView extends ArrayAdapter<String> {

    private String[] rooms;

    public final static String EXTRA_MESSAGE = "ZONE";

    private Activity context;

    public DungeonListView(Activity context, String[] rooms) {
        super(context, R.layout.dungeonlistview_layout, rooms);

        this.context = context;
        this.rooms = rooms;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;

        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.dungeonlistview_layout, null, true);

            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
            //return super.getView(position, convertView, parent);
        }else{
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.room.setText(rooms[position]);
        return r;
    }
    class ViewHolder {
        TextView room;

        ViewHolder(View v) {
            room = (TextView) v.findViewById(R.id.room);
            room.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View VIew) {
                    Intent intent = new Intent(getContext(), RoomActivity.class);
                    String name = room.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE,name);
                    context.startActivity(intent);
                }

            });
            }

        }

    }


