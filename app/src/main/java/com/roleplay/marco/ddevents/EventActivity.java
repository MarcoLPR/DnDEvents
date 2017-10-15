package com.roleplay.marco.ddevents;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class EventActivity extends AppCompatActivity {

    String caverns[][] = {
            //Underground River
            {"Notas que el agua brilla a causa de una extraña variedad de hongos.",
                    "Al acercarte al agua te sientes mejor, más concentrado (Advantage)",
                    "Encuentras 100 G en el agua, pero al meter la mano el agua se agita y se forma un elemental."},
            //Dark Chasm
            {"Las sombras se arrastran hasta tus pies sujetandolos (Inmovilizado)",
                    "El abismo arroja a todos fuera del puente y lo devora  (Colocar Pit sobre el abismo)",
                    "Encuentras una Healing potion junto a unas marcas de que alguien fue arrastrado al abismo.",
                    "La oscuridad le llama al Rogue de su equipo, ves como lo engulle sin poder hacer nada. (El jugador desaparece durante dos turnos, si tiene 20 XP cambia de clase a Nightingale). Al regresar, tu compañero no parece el mismo."},
            //Drow Glyph
            {"La marca maldice a todos los que se encuentran en la habitación.",
                    "Las energías arcanas del glifo se disipan en el aire.",
                    "Al tocar el glifo, un enjambre de arañas cae frente a ti.",
                    "Te llenas de la magia ancestral, obteniendo 4 XP"},
            //Crystal Shard
            {"El mineral parece ser algo común.",
                    "Al tocar el cristal, se crea una onda que sana las heridas de todos los presentes. (+2 HP todos en la tile).",
                    "Logras extraer un fragmento de cristal, parece tener propiedades mágicas"},
            //Secret Cave
            {"Solo encuentras basura en el lugar, quien haya venido seguro cargó con todo lo de valor.",
                    "Logras descansar un poco en el lugar pero te hace sentir aletargado. (2 HP y Dazed)",
                    "Entre algunos objetos rotos encuentras lo que parece un frasco. (Obtienes flask of oil)"},
            //Rocky Lair
            {"Solo encuentras basura entre los adornos.",
                    "Uno de los adornos parece un amuleto con propiedades mágicas (Obtienes Scrimshaw charm)",
                    "Sientes la presencia de espíritus atrapados en este lugar, te piden que los ayudes. (Si eres Barbarian gastas 1 turno en aplacarlos, con 20 XP desbloqueas Shaman)"}
    };
    String fortress[][] = {
            //Vault
            {"Entre todas las cosas solo encuentras basura.",
                    "Entre toda la basura, descubres un grueso tomo, al abrirlo, brotan de el tentáculos de oscuridad que te envuelven causandote daño. (-2 HP, si eres Warlock el grimorio te extermina, si tienes 20 XP cuando te reviven, resurges como Necromancer)",
                    "Descubres un compartimiento oculto (Obtienes Heavy cloak y 100G)"},
            //Ancient Battlefield
            {"Algo en este lugar te produce malestar, si guardas silencio te parece escuchar llantos. (Disvantage)",
                    "Nada en este lugar parece de valor, probablemente sea mejor salir pronto de aquí."},
            //Horrid Chamber
            {"Los desmembramientos que ocurrieron en este lugar te provocan arcadas, intentas contenerte cuando observas que hay movimiento entre la pila de cadáveres. (Coloca 3 Gibbering mouther con DL+2 de lo normal)",
                    "Parece que la matanza atrajo a otro grupo de aventureros, sin embargo, algo en ellos parece mal. (Colocar 3 heroes, solo usan at-will y 1 daily)",
                    "El jugador que entro al cuarto lee. - A sido demasiado fácil engañarlos. El jugador se transforma en Artemis y lo controlará por el resto de la partida."}
    };
    String oracle[][] = {
            //Dire Chamber
            {"Ves a una mujer en una esquina acosada por tres cultistas, rápidamente los sujetos voltean y parecen saborear tu carne. (Si la salvas obtienes 100 G).",
                    "Ves un cadáver en medio de la sala que estalla enviando una oleada de corrupción (Tira dados para cada estado -10 lo sufres)",
                    "Al entrar a la cámara ves  "},
            //Vault
            {"Buscas entre los destrozos cuando un tentáculo sujeta tu brazo. (Coloca 1 Grell y el jugador queda Inmovilizado).",
                    "No es posible encontrar algo aparte de libros ilegibles y relojes rotos.",
                    " Al abrir la habitación ves un goblin cargando un saco enorme. Cuando te acercas, un sello mágico se activa, enviando a cada miembro de tu grupo a los extremos más alejados del mapa. (Goblin con 4 HP intenta huir, matarlo da 200 G, Oil Flask y un extraño té rojo)."}
    };
    String elements[][] = {
            //Air Altar
            {"Este lugar perdió su poder hace bastante tiempo.",
                    "Tocas el altar y un feroz aullido recorre el lugar. Inmediatamente observas como se aproximan dos seguidores del viento.",
                    "Al acercarte, sientes como empieza a imbuirte la energía elemental."},
            //Earth Altar
            {"Parece que el lugar es mera decoración.",
                    "",
                    "",
                    ""},
            //Fire Altar
            {"",
                    "",
                    "",
                    ""},
            //Water Altar
            {"",
                    "",
                    ""},
            //Guard Room
            {"",
                    "",
                    ""},
            //Air Node
            {"",
                    "",
                    ""},
            //Fire Node
            {"",
                    "",
                    ""},
            //Earth Node
            {"",
                    "",
                    ""},
            //Water Node
            {"",
                    "",
                    ""},
            //Massacre Site
            {"",
                    "",
                    ""}
    };
    String university[][] = {
            //Furnance Room
            {"",
                    "",
                    ""},
            //Ollyndra Well
            {"",
                    "",
                    ""},
            //Guard Room
            {"",
                    "",
                    ""},
            //Horrid Chamber
            {"",
                    "",
                    ""},
            //Massacre Site
            {"",
                    "",
                    ""},
    };
    String citadel[][] = {
            //Rocky Lair
            {"",
                    "",
                    ""},
            //Underground River
            {"",
                    "",
                    ""},
            //Crystal Shard
            {"",
                    "",
                    ""},
            //Dark Chasm
            {"",
                    "",
                    ""},
            //Secret Cave
            {"",
                    "",
                    ""},
            //Dwarven Statue
            {"",
                    "",
                    ""},
            //Broken Door
            {"",
                    "",
                    ""},
            //Drow Glyph
            {"",
                    "",
                    ""},
            //Ancient Throne
            {"",
                    "",
                    ""},
    };

    String bastion[][] = {
            //Horrid Chamber
            {"",
                    "",
                    ""},
            //Dire Chamber
            {"",
                    "",
                    ""},
            //Vault
            {"",
                    "",
                    ""},
            //Ancient Battlefield
            {"",
                    "",
                    ""}
    };


    TextView nameTXT;
    TextView descriptionTXT;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        String room = intent.getStringExtra(DescriptionActivity.EXTRA_EVENT);
        String actualZone = intent.getStringExtra(DescriptionActivity.EXTRA_ACTUALZONE);
        Random r = new Random();
        int event =  r.nextInt(21 - 1) + 1;

        nameTXT = (TextView) findViewById(R.id.nameTXT);
        nameTXT.setText(room);
        descriptionTXT = (TextView) findViewById(R.id.descriptionTXT);
        descriptionTXT.setText(actualZone);
        switch (actualZone) {
            case "Cavernas": {
                switch (room) {
                    case "Underground River": {
                        if (event < 9) {
                            descriptionTXT.setText(caverns[0][0]);
                        } else if (event < 16) {
                            descriptionTXT.setText(caverns[0][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(caverns[0][2]);
                        }
                        break;
                    }
                    case "Dark Chasm": {
                        if (event < 11) {
                            descriptionTXT.setText(caverns[1][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(caverns[1][1]);
                        } else if (event < 20) {
                            descriptionTXT.setText(caverns[1][2]);
                        } else if (event < 21) {
                            descriptionTXT.setText(caverns[1][3]);
                        }
                        break;
                    }
                    case "Drow Glyph": {
                        if (event < 9) {
                            descriptionTXT.setText(caverns[2][0]);
                        } else if (event < 13) {
                            descriptionTXT.setText(caverns[2][1]);
                        } else if (event < 19) {
                            descriptionTXT.setText(caverns[2][2]);
                        } else if (event < 21) {
                            descriptionTXT.setText(caverns[2][3]);
                        }
                        break;
                    }
                    case "Crystal Shard": {
                        if (event < 1) {
                            descriptionTXT.setText(caverns[3][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(caverns[3][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(caverns[3][2]);
                        }
                        break;
                    }
                    case "Secret Cave": {
                        if (event < 10) {
                            descriptionTXT.setText(caverns[4][0]);
                        } else if (event < 16) {
                            descriptionTXT.setText(caverns[4][1]);
                        } else if (event < 19) {
                            descriptionTXT.setText(caverns[4][2]);
                        } else if (event < 21) {
                            descriptionTXT.setText(caverns[4][3]);
                        }
                        break;
                    }
                    case "Rocky Lair": {
                        if (event < 15) {
                            descriptionTXT.setText(caverns[5][0]);
                        } else if (event < 19) {
                            descriptionTXT.setText(caverns[5][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(caverns[5][2]);
                        }
                        break;
                    }
                }
                break;
            }
            case "Fortaleza": {
                switch (room) {
                    case "Vault": {
                        if (event < 9) {
                            descriptionTXT.setText(fortress[0][0]);
                        } else if (event < 16) {
                            descriptionTXT.setText(fortress[0][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(fortress[0][2]);
                        }
                        break;
                    }
                    case "Ancient Battlefield": {
                        if (event < 10) {
                            descriptionTXT.setText(fortress[1][0]);
                        } else if (event < 18) {
                            descriptionTXT.setText(fortress[1][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(fortress[1][2]);
                        }
                        break;
                    }
                    case "Horrid Chamber": {
                        if (event < 9) {
                            descriptionTXT.setText(fortress[2][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(fortress[2][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(fortress[2][2]);
                        }
                        break;
                    }
                }
                break;
            }
            case "Oraculo del Tiempo": {
                switch (room) {
                    case "Dire Chamber": {
                        if (event < 9) {
                            descriptionTXT.setText(oracle[0][0]);
                        } else if (event < 16) {
                            descriptionTXT.setText(oracle[0][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(oracle[0][2]);
                        }
                        break;
                    }
                    case "Vault": {
                        if (event < 9) {
                            descriptionTXT.setText(oracle[1][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(oracle[1][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(oracle[1][2]);
                        }
                        break;
                    }
                }
                break;
            }
            case "Liceo de los Elementos": {
                switch (room) {
                    case "Air Altar": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[0][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[0][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[0][2]);
                        }
                        break;
                    }
                    case "Earth Altar": {
                        if (event < 6) {
                            descriptionTXT.setText(elements[1][0]);
                        } else if (event < 18) {
                            descriptionTXT.setText(elements[1][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[1][2]);
                        }
                        break;
                    }
                    case "Fire Altar": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[2][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[2][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[2][2]);
                        }
                        break;
                    }
                    case "Water Altar": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[3][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[3][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[3][2]);
                        }
                        break;
                    }
                    case "Guard Room": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[4][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[4][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[4][2]);
                        }
                        break;
                    }
                    case "Air Node": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[5][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[5][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[5][2]);
                        }
                        break;
                    }
                    case "Fire Node": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[6][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[6][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[6][2]);
                        }
                        break;
                    }
                    case "Earth Node": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[7][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[7][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[7][2]);
                        }
                        break;
                    }
                    case "Water Node": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[8][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[8][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[8][2]);
                        }
                        break;
                    }
                    case "Massacre Site": {
                        if (event < 9) {
                            descriptionTXT.setText(elements[9][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(elements[9][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(elements[9][2]);
                        }
                        break;
                    }
                }
                break;
            }
            case "Universidad Desolada": {
                switch (room) {
                    case "Furnance Room": {
                        if (event < 9) {
                            descriptionTXT.setText(university[0][0]);
                        } else if (event < 16) {
                            descriptionTXT.setText(university[0][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(university[0][2]);
                        }
                        break;
                    }
                    case "Ollyndra Well": {
                        if (event < 11) {
                            descriptionTXT.setText(university[1][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(university[1][1]);
                        } else if (event < 20) {
                            descriptionTXT.setText(university[1][2]);
                        } else if (event < 21) {
                            descriptionTXT.setText(university[1][3]);
                        }
                        break;
                    }
                    case "Guard Room": {
                        if (event < 9) {
                            descriptionTXT.setText(university[2][0]);
                        } else if (event < 13) {
                            descriptionTXT.setText(university[2][1]);
                        } else if (event < 19) {
                            descriptionTXT.setText(university[2][2]);
                        } else if (event < 21) {
                            descriptionTXT.setText(university[2][3]);
                        }
                        break;
                    }
                    case "Massacre Site": {
                        if (event < 1) {
                            descriptionTXT.setText(university[3][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(university[3][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(university[3][2]);
                        }
                        break;
                    }
                }
                break;
            }
                case "La Ciudadela Oscura": {
                    switch (room) {
                        case "Rocky Lair": {
                            if (event < 9) {
                                descriptionTXT.setText(citadel[0][0]);
                            } else if (event < 16) {
                                descriptionTXT.setText(citadel[0][1]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[0][2]);
                            }
                            break;
                        }
                        case "Underground River": {
                            if (event < 11) {
                                descriptionTXT.setText(citadel[1][0]);
                            } else if (event < 17) {
                                descriptionTXT.setText(citadel[1][1]);
                            } else if (event < 20) {
                                descriptionTXT.setText(citadel[1][2]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[1][3]);
                            }
                            break;
                        }
                        case "Crystal Shard": {
                            if (event < 9) {
                                descriptionTXT.setText(citadel[2][0]);
                            } else if (event < 13) {
                                descriptionTXT.setText(citadel[2][1]);
                            } else if (event < 19) {
                                descriptionTXT.setText(citadel[2][2]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[2][3]);
                            }
                            break;
                        }
                        case "Dark Chasm": {
                            if (event < 1) {
                                descriptionTXT.setText(citadel[3][0]);
                            } else if (event < 17) {
                                descriptionTXT.setText(citadel[3][1]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[3][2]);
                            }
                            break;
                        }
                        case "Secret Cave": {
                            if (event < 1) {
                                descriptionTXT.setText(citadel[4][0]);
                            } else if (event < 17) {
                                descriptionTXT.setText(citadel[4][1]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[4][2]);
                            }
                            break;
                        }
                        case "Dwarven Statue": {
                            if (event < 1) {
                                descriptionTXT.setText(citadel[5][0]);
                            } else if (event < 17) {
                                descriptionTXT.setText(citadel[5][1]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[5][2]);
                            }
                            break;
                        }
                        case "Broken Door": {
                            if (event < 1) {
                                descriptionTXT.setText(citadel[6][0]);
                            } else if (event < 17) {
                                descriptionTXT.setText(citadel[6][1]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[6][2]);
                            }
                            break;
                        }
                        case "Drow Glyph": {
                            if (event < 1) {
                                descriptionTXT.setText(citadel[7][0]);
                            } else if (event < 17) {
                                descriptionTXT.setText(citadel[7][1]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[7][2]);
                            }
                            break;
                        }
                        case "Ancient Throne": {
                            if (event < 1) {
                                descriptionTXT.setText(citadel[8][0]);
                            } else if (event < 17) {
                                descriptionTXT.setText(citadel[8][1]);
                            } else if (event < 21) {
                                descriptionTXT.setText(citadel[8][2]);
                            }
                            break;
                        }

                    }
                    break;
                }
            case "Bastion de Magma": {
                switch (room) {
                    case "Horrid Chamber": {
                        if (event < 9) {
                            descriptionTXT.setText(bastion[0][0]);
                        } else if (event < 16) {
                            descriptionTXT.setText(bastion[0][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(bastion[0][2]);
                        }
                        break;
                    }
                    case "Dire Chamber": {
                        if (event < 11) {
                            descriptionTXT.setText(bastion[1][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(bastion[1][1]);
                        } else if (event < 20) {
                            descriptionTXT.setText(bastion[1][2]);
                        } else if (event < 21) {
                            descriptionTXT.setText(bastion[1][3]);
                        }
                        break;
                    }
                    case "Vault": {
                        if (event < 9) {
                            descriptionTXT.setText(bastion[2][0]);
                        } else if (event < 13) {
                            descriptionTXT.setText(bastion[2][1]);
                        } else if (event < 19) {
                            descriptionTXT.setText(bastion[2][2]);
                        } else if (event < 21) {
                            descriptionTXT.setText(bastion[2][3]);
                        }
                        break;
                    }
                    case "Ancient Battlefield": {
                        if (event < 1) {
                            descriptionTXT.setText(bastion[3][0]);
                        } else if (event < 17) {
                            descriptionTXT.setText(bastion[3][1]);
                        } else if (event < 21) {
                            descriptionTXT.setText(bastion[3][2]);
                        }
                        break;
                    }
                }
                break;
            }
            }
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

