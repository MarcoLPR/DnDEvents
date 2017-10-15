package com.roleplay.marco.ddevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RollActivity extends AppCompatActivity {

    String events[] = {
            "DESCRIPTION",
            "RANDOM QUEST",
            "DESCRIPTION",
            "SKILL CHALLENGE",
            "DESCRIPTION",
            "ROLEPLAY",
            "DESCRIPTION",
            "SIDEQUEST",
            "DESCRIPTION",
            "NOTHING",
            "DESCRIPTION",
            "SKILL CHALLENGE",
            "DESCRIPTION",
            "ROLEPLAY",
            "DESCRIPTION",
            "SIDEQUEST",
            "DESCRIPTION",
            "NOTHING",
            "DESCRIPTION",
            "RANDOM QUEST"
    };
    String randomQuestList[][] = {
            {"Fuga del Fuego", "Robo", "Las Profunidades", "Maldicion de Sangre"},
            {"Secuestro", "Búsqueda de Tesoros", "Liceo", "El Heroe del Pueblo"},
            {"Mision1", "Mision2", "Mision3", "Mision4"},
            {"Fuego contra Fuego", "Cae la Oscuridad", "Mision3", "Sombras del Pasado"}
    };
    TextView eventTXT;
    TextView randomTXT;
    Button eventBTN;
    EditText rpINPUT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);

        Toolbar toolbar = (Toolbar) findViewById(R.id.rollTool);
        setSupportActionBar(toolbar);

        eventBTN = (Button) findViewById(R.id.eventBTN);
        eventTXT = (TextView) findViewById(R.id.eventTXT);
        rpINPUT = (EditText) findViewById(R.id.rpINPUT);
        randomTXT = (TextView) findViewById(R.id.randomTXT);

        eventBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomTXT.setText(" ");

                Random r = new Random();
                int eventNumber = r.nextInt(21 - 1) + 1;
                int eventRQNumber = r.nextInt(5 - 1) + 1;
                int eventSideNumber = r.nextInt(21 - 1) + 1;
                int rp = Integer.parseInt(rpINPUT.getText().toString());

                if (rp < 4) {
                    rp = 0;
                } else if (rp < 7) {
                    rp = 1;
                } else if (rp < 11) {
                    rp = 2;
                } else if (rp < 16) {
                    rp = 3;
                }

                eventTXT.setText(events[eventNumber - 1]);
                Toast.makeText(RollActivity.this, "Roll: " + eventNumber, Toast.LENGTH_SHORT).show();

                if (eventNumber == 2 || eventNumber == 20) {
                    for (int i = 1; i < 5; i++) {
                        if (eventRQNumber == i) {
                            randomTXT.setText(randomQuestList[rp][i]);
                        }
                    }
                } else if (eventNumber == 8 || eventNumber == 10 || eventNumber == 16 || eventNumber == 18) {

                } else {
                    randomTXT.setText(String.valueOf(eventSideNumber));
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.dungeon: {
                Intent dungeonIntent = new Intent(getApplicationContext(), DungeonActivity.class);
                startActivity(dungeonIntent);
                break;
            }

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }
}
