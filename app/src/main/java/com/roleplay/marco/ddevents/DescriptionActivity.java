package com.roleplay.marco.ddevents;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class DescriptionActivity extends AppCompatActivity {

    TextView nameTXT;
    TextView descriptionTXT;
    Button eventBTN;
    public static String EXTRA_EVENT = "ROOM";
    public static String EXTRA_ACTUALZONE = "ZONE";

    String description[][] = {
            // 1 Caverns
            /*Underground River*/           {"El sonido del agua hace eco a través de las cavernas, un puente desgastado cuelga encima del paso del rio, el agua parece cristalina y resplandece de una forma antinatural.",
            /*Dark Chasm*/                  "Las sombras crepitan por el interior de un foso ante ti, al acercarte percibes algunos sonidos saliendo de las profundidades, sin embargo, no logras distinguir nada concreto.",
            /*Drow Glyph*/                  "Frente a ti se encuentra uno de los antiguos simbolos usados para representar a la Diosa Aracnida. A pesar de ser un culto primitivo y olvidado, es evidente que la magia fluye a traves de sus trazos. ",
            /*Crystal Shard*/               "Un brillante cristal, que muestra señales de haber sido resquebrajado emana un aura mistica, al ver tu reflejo sobre el, la imagen parece borrosa.",
            /*Secret Cave*/                 "Murciélagos vuelan fuera de esta caverna cuando te aproximas. Sientes que aún hay alguna presencia dentro de este lugar, los rescoldos de lo que parece una fogata todavía emiten calor y entre la tierra ves lo que pudo ser una pieza de una armadura.",
            /*Rocky Lair*/                  "Al final de la caverna notas lo que podría ser un primitivo altar de piedra. La roca está pintada con algún tipo de pintura verde y algunos adornos sencillos de plumas y huesos se encuentran desperdigados."},
            // 2 Fortress
            /*Vault*/                       {"Detrás de las puertas se encuentra un alijo, parece que fue saqueado apresuradamente hace ya bastante tiempo.",
            /*Ancient Battlefield*/         "Los antiguos esqueletos que se encuentran en esta sala aún portan retazos de armaduras oxidadas, las paredes muestran manchas oscuras de lo que pudo haber sido salpicaduras de sangre.",
            /*Horrid Chamber*/              "Al entrar a esta sala notas el aroma dulzón de carne en descomposición, el suelo bajo tus pies se siente pegajoso, algo tenebroso acecha más adelante."},
            // 3 Time Oracle
            /*Dire Chamber*/                {"La carnicería que sucedió en este lugar aún está fresca, charcos de sangre cubren el suelo y comienzas a escuchar que algo sigue goteando sangre.",
            /*Vault*/                       "Detrás de las puertas se encuentra un alijo, parece que fue saqueado apresuradamente hace ya bastante tiempo."},
            // 4 Elements
            /*Air Altar*/                   {"Antes de entrar notas el aullido del viento que sale de esta habitación, una criatura alada se encuentra en el centro de lo que parece un altar reconstruido.",
            /*Earth Altar*/                 "Este altar posee uno de los demonios familiares de los que hablaban en antaño los elementalistas. La pieza está labrada de una roca desconocida.",
            /*Fire Altar*/                  "Los elementalistas de fuego habían desarrollado un medio para mantener pequeños fuegos ardiendo indefinidamente, sobre este  sencillo altar se encuentran dos pequeñas flamas que dan una sensación de amenaza. ",
            /*Water Altar*/                 "Al mirar a este pedestal con agua, pareciera que el fondo no existe, incluso al meter la mano en el agua, parece que está no tiene fin.",
            /*Guard Room*/                  "Un juego de sencillas sillas y una pequeña mesa muestran lo que pudo ser un cuarto de guardia, los pocos objetos sobre la mesa muestran una partida de cartas que nunca termino.",
            /*Air Node*/                    "Undefined",
            /*Fire Node*/                   "Undefined",
            /*Earth Node*/                  "Undefined",
            /*Water Node*/                  "Undefined",
            /*Massacre Site*/               "La matanza acaecida en este lugar aún mantiene sus rastros. Poco ha sido lo que los saqueadores han dejado de estos cuerpos."},
            // 5 University
            /*Furnance Room*/               {"La forja brilla tanto que tus ojos tardan un poco en acostumbrarse a la luz. Diversas herramientas y materiales se encuentran por el cuarto, sin embargo parece que han sido usados recientemente.",
            /*Ollyndra Well*/               "El enorme pozo cubre gran parte de la cámara, su agua posee un ligero resplandor que provoca que las paredes se vean en movimiento.",
            /*Guard Room*/                  "Un juego de sencillas sillas y una pequeña mesa muestran lo que pudo ser un cuarto de guardia, los pocos objetos sobre la mesa muestran una partida de cartas que nunca termino.",
            /*Horrid Chamber*/              "Undefined",
            /*Massacre Site*/               "La matanza acaecida en este lugar aún mantiene sus rastros. Poco ha sido lo que los saqueadores han dejado de estos cuerpos."},
            // 6 Citadel
            /*Rocky Lair*/                  {"La caverna se ensancha hasta que el techo desaparece en la oscuridad. El ambiente se torna caliente mientras avanzas y contemplas una formación elevada de rocas que parece tener en su superficie algunos objetos y rastrojos.",
            /*Underground River*/           "El río genera una ligera niebla sobre el, al tocar el agua te quemas la mano. Dentro del agua notas algo brillante",
            /*Crystal Shard*/               "Undefined",
            /*Dark Chasm*/                  "Una gran fisura se encuentra frente a ti, de su interior emana lo que parecen exhalaciones de aire muy caliente y seco. Sientes la necesidad de alejarte rápidamente de ese lugar",
            /*Secret Cave*/                 "Undefined",
            /*Dwarven Statue*/              "Pocos rastros se mantienen de lo que una vez fueron las ciudades subterraneas de los enanos, no obstante, una ancestral estatua de esas epocas se mantiene erguida sobre su pedestal.",
            /*Broken Door*/                 "Undefined",
            /*Drow Glyph*/                  "Undefined",
            /*Ancient Throne*/              "Undefined"},
            // 7 Bastion
            /*Rocky Lair*/                  {"Undefined",
            /*Underground River*/           "Undefined",
            /*Crystal Shard*/               "Undefined",
            /*Dark Chasm*/                  "Undefined"}
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        eventBTN = (Button) findViewById(R.id.eventBTN);

        Intent intent = getIntent();
        final String actualRoom = intent.getStringExtra(RoomListView.EXTRA_ROOM);
        final String actualZone = intent.getStringExtra(RoomListView.EXTRA_ACTUALZONE);
        nameTXT = (TextView) findViewById(R.id.nameTXT);
        nameTXT.setText(actualRoom);
        descriptionTXT = (TextView) findViewById(R.id.descriptionTXT);
        descriptionTXT.setText(actualZone);

        switch (actualZone) {
            case "Cavernas": {
                switch (actualRoom) {
                    case "Underground River":{
                        descriptionTXT.setText(description[0][0]);
                        break;
                    }
                    case "Dark Chasm":{
                        descriptionTXT.setText(description[0][1]);
                        break;
                    }
                    case "Drow Glyph":{
                        descriptionTXT.setText(description[0][2]);
                        break;
                    }
                    case "Crystal Shard":{
                        descriptionTXT.setText(description[0][3]);
                        break;
                    }
                    case "Secret Cave":{
                        descriptionTXT.setText(description[0][4]);
                        break;
                    }
                    case "Rocky Lair":{
                        descriptionTXT.setText(description[0][5]);
                        break;
                    }
                }
                break;
            }
            case "Fortaleza": {
                switch (actualRoom) {
                    case "Vault":{
                        descriptionTXT.setText(description[1][0]);
                        break;
                    }
                    case "Ancient Battlefield":{
                        descriptionTXT.setText(description[1][1]);
                        break;
                    }
                    case "Horrid Chamber":{
                        descriptionTXT.setText(description[1][2]);
                        break;
                    }
                }
                break;
            }
            case "Bastion de Magma": {
                switch (actualRoom) {
                    case "Horrid Chamber":{
                        descriptionTXT.setText(description[6][0]);
                        break;
                    }
                    case "Dire Chamber":{
                        descriptionTXT.setText(description[6][1]);
                        break;
                    }
                    case "Vault":{
                        descriptionTXT.setText(description[6][2]);
                        break;
                    }
                    case "Ancient Battlefield":{
                        descriptionTXT.setText(description[6][3]);
                        break;
                    }
                }
                break;
            }
            case "La Ciudadela Oscura": {
                switch (actualRoom) {
                    case "Rocky Lair":{
                        descriptionTXT.setText(description[5][0]);
                        break;
                    }
                    case "Underground River":{
                        descriptionTXT.setText(description[5][1]);
                        break;
                    }
                    case "Crystal Shard":{
                        descriptionTXT.setText(description[5][2]);
                        break;
                    }
                    case "Dark Chasm":{
                        descriptionTXT.setText(description[5][3]);
                        break;
                    }
                    case "Secret Cave":{
                        descriptionTXT.setText(description[5][4]);
                        break;
                    }
                    case "Dwarven Statue":{
                        descriptionTXT.setText(description[5][5]);
                        break;
                    }
                    case "Broken Door":{
                        descriptionTXT.setText(description[5][6]);
                        break;
                    }
                    case "Drow Glyph":{
                        descriptionTXT.setText(description[5][7]);
                        break;
                    }
                    case "Ancient Throne":{
                        descriptionTXT.setText(description[5][8]);
                        break;
                    }
                }
                break;
            }
            case "Liceo de los Elementos": {
                switch (actualRoom) {
                    case "Air Altar":{
                        descriptionTXT.setText(description[3][0]);
                        break;
                    }
                    case "Earth Altar":{
                        descriptionTXT.setText(description[3][1]);
                        break;
                    }
                    case "Fire Altar":{
                        descriptionTXT.setText(description[3][2]);
                        break;
                    }
                    case "Water Altar":{
                        descriptionTXT.setText(description[3][3]);
                        break;
                    }
                    case "Guard Room":{
                        descriptionTXT.setText(description[3][4]);
                        break;
                    }
                    case "Air Node":{
                        descriptionTXT.setText(description[3][5]);
                        break;
                    }
                    case "Fire Node":{
                        descriptionTXT.setText(description[3][6]);
                        break;
                    }
                    case "Earth Node":{
                        descriptionTXT.setText(description[3][7]);
                        break;
                    }
                    case "Water Node":{
                        descriptionTXT.setText(description[3][8]);
                        break;
                    }
                    case "Massacre Site":{
                        descriptionTXT.setText(description[3][9]);
                        break;
                    }
                }
                break;
            }
            case "Oraculo del Tiempo": {
                switch (actualRoom) {
                    case "Dire Chamber":{
                        descriptionTXT.setText(description[2][0]);
                        break;
                    }
                    case "Vault":{
                        descriptionTXT.setText(description[2][1]);
                        break;
                    }
                }
                break;
            }
            case "Universidad Desolada": {
                switch (actualRoom) {
                    case "Furnance Room":{
                        descriptionTXT.setText(description[4][0]);
                        break;
                    }
                    case "Ollyndra Well":{
                        descriptionTXT.setText(description[4][1]);
                        break;
                    }
                    case "Guard Room":{
                        descriptionTXT.setText(description[4][2]);
                        break;
                    }
                    case "Horrid Chamber":{
                        descriptionTXT.setText(description[4][3]);
                        break;
                    }
                    case "Massacre Site":{
                        descriptionTXT.setText(description[4][4]);
                        break;
                    }
                }
                break;
            }
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.dungeonTool);
        setSupportActionBar(toolbar);

        eventBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View VIew) {
                Intent intent = new Intent(DescriptionActivity.this, EventActivity.class);
                intent.putExtra(EXTRA_EVENT, actualRoom);
                intent.putExtra(EXTRA_ACTUALZONE, actualZone);
                startActivity(intent);
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