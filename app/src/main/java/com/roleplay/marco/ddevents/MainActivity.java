package com.roleplay.marco.ddevents;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mainTool);
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
