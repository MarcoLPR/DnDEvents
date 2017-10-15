package com.roleplay.marco.ddevents;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class RoomActivity extends AppCompatActivity {

    public static String EXTRA_ZONE = "";
    TextView name;

    String[] cavernsTiles = {
            "Underground River",
            "Dark Chasm",
            "Drow Glyph",
            "Crystal Shard",
            "Secret Cave",
            "Rocky Lair"
    };
    String[] fortressTiles = {
            "Vault",
            "Ancient Battlefield",
            "Horrid Chamber"
    };
    String[] oracleTiles = {
            "Dire Chamber",
            "Vault",
    };
    String[] elementsTiles = {
            "Air Altar",
            "Earth Altar",
            "Fire Altar",
            "Water Altar",
            "Guard Room",
            "Air Node",
            "Earth Node",
            "Fire Node",
            "Water Node",
            "Massacre Site"
    };
    String[] universityTiles = {
            "Furnance Room",
            "Ollyndra Well",
            "Guard Room",
            "Horrid Chamber",
            "Massacre Site"
    };
    String[] citadelTiles = {
            "Surface Hollow",
            "Rocky Lair",
            "Underground River",
            "Crystal Shard",
            "Dark Chasm",
            "Secret Cave",
            "Dwarven Statue",
            "Broken Door",
            "Drow Glyph",
            "Ancient Throne"
    };
    String[] bastionTiles = {
            "Horrid Chamber",
            "Dire Chamber",
            "Vault",
            "Ancient Battlefield"
    };
    String tiles[] = {""};
    ListView listTiles;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Intent intent = getIntent();
        String message = intent.getStringExtra(DungeonListView.EXTRA_MESSAGE);
        name = (TextView) findViewById(R.id.name);
        name.setTextSize(36);
        name.setText(message);
        EXTRA_ZONE = message;

        listTiles = (ListView) findViewById(R.id.ListTiles);
        if(message.equals("Cavernas")) {
            tiles = cavernsTiles;
        }else if(message.equals("Fortaleza")) {
            tiles = fortressTiles;
        }else if(message.equals("Bastion de Magma")) {
            tiles = bastionTiles;
        }else if(message.equals("La Ciudadela Oscura")) {
            tiles = citadelTiles;
        }else if(message.equals("Liceo de los Elementos")) {
            tiles = elementsTiles;
        }else if(message.equals("Oraculo del Tiempo")) {
            tiles = oracleTiles;
        }else if(message.equals("Universidad Desolada")) {
            tiles = universityTiles;
        }
        RoomListView roomListView = new RoomListView(this, tiles);
        listTiles.setAdapter(roomListView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.dungeonTool);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dungeon: {
                Intent dungeonIntent = new Intent(getApplicationContext(), DungeonActivity.class);
                startActivity(dungeonIntent);
                break;
            }

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
