package com.roleplay.marco.ddevents;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class DungeonActivity extends AppCompatActivity {

    String[] rooms = {
            "Bastion de Magma",
            "Cavernas",
            "Fortaleza",
            "La Ciudadela Oscura",
            "Liceo de los Elementos",
            "Oraculo del Tiempo",
            "Universidad Desolada"
    };
    ListView listRooms;


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.dungeon_menu, menu);
            return true;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dungeon);

            listRooms = (ListView) findViewById(R.id.ListRooms);
            DungeonListView dungeonListView = new DungeonListView(this, rooms);
            listRooms.setAdapter(dungeonListView);

            Toolbar toolbar = (Toolbar) findViewById(R.id.dungeonTool);
            setSupportActionBar(toolbar);
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.roll: {
                    Intent rollIntent = new Intent(getApplicationContext(), RollActivity.class);
                    startActivity(rollIntent);
                    break;
                }

                default:
                    return super.onOptionsItemSelected(item);

            }
            return true;
        }
    }
