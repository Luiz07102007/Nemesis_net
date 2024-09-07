package com.example.nemesis_net;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainLista extends AppCompatActivity {
    private MediaPlayer clickSound;

    String dicas[] = {"ROTA DO METRÔ:\n" +
            "1. FA-02\n" +
            "2. RA-03\n" +
            "3. SA-02\n" +
            "4. FO-01\n" +
            "\n" +
            "VACINA:\n" +
            "MID-HIGH-LOW\n" +
            "\n" +
            "ARMÁRIOS DA R.P.D:\n" +
            "1. CAP(Chuveiro)\n" +
            "2. DCM (3°Andar)\n" +
            "\n" +
            "1°COFRE:9E 3D 7E\n" +
            "2°COFRE:9E 15D 7E\n" +
            "3°COFRE:9D 3E","SENHAS DOS COFRES:\n" +
            "Sala de Espera 2F: 6E 2D 11E\n" +
            "Corredor nos Esgotos: 2E 12D 8E\n" +
            "\n" +
            "SENHAS DOS CADEADOS:\n" +
            "Mesa do Leon: NED(esquerda),MRG(direita)\n" +
            "Escritório nos Esgotos: SZF\n" +
            "\n" +
            "HERBICIDA:\n" +
            "RGBRGBRG\n" +
            "(R=red,B=blue,G=green)\n" +
            "\n" +
            "Teclado Numérico:\n" +
            "3213(escada)\n" +
            "2067(máquina)","ARMAS e ROUPAS:\n" +
            "\n" +
            "PRL 4.1.2:Zerar no Profissional\n" +
            "Chicago Typewriter:Zerar o Assignment Ada\n" +
            "Infinite Launcher e Matilda/Leon R.P.D e Ashley Popstar: Zerar no normal\n" +
            "Handcannon : 5 estrelas em todos os personagens no mercenaries\n" +
            "Leon mafioso e Ashley Armadura:Zerar o Separate Ways\n" +
            "\n" +
            "PUZZLES:\n" +
            "\n" +
            "Green Catseye: 3,3,3,4,4,4,3\n" +
            "Church Color Light:R2, G3, B1\n" +
            "Portrait Puzzle: 1,3,2,4\n" +
            "Green Orb Door: Up,Left","CÓDIGOS:\n" +
            "\n" +
            "Cofre da Oficina da Vila: 07-04-08.\n" +
            "Porta da Casa Beneviento: 05-29-11.\n" +
            "\n" +
            "PUZZLES:\n" +
            "\n" +
            "Braseiro na Masmorra do Castelo: Empurre ou ataque o braseiro para balançá-lo e acender as 2 tochas.\n" +
            "Puzzle das Estátuas: Gire todas as Estátuas uma vez, exceto o Cavalo.\n" +
            "Puzzle do Piano: Basta pressionar todas as teclas do piano, você só precisa acertar cada nota uma vez.","ARMAS:\n" +
            "\n" +
            "Albert-01: Liberada ao zerar em qualquer dificuldade\n" +
            "Serra Circular: Zerar em 4 horas em qualquer dificuldade\n" +
            "Munição Infinita: Zerar no hospício\n" +
            "\n" +
            "ACESSÓRIOS:\n" +
            "\n" +
            "Sapatos: Destrua todas as estátuas do Sr. Onipresente\n" +
            "Óculos raio-x: Zerar em 4 horas em qualquer dificuldade\n" +
            "Segredos da defesa: Liberada ao zerar no normal(provavelmente em todas as dificuldades)\n" +
            "Essência da defesa: Destrua todas as estátuas do Sr. Onipresente"};

    String nomejogos[] = {"RESIDENT EVIL 3 - REMAKE", "RESIDENT EVIL 2 - REMAKE", "RESIDENT EVIL 4 - 2005", "RESIDENT EVIL 8 - VILLAGE","RESIDENT EVIL 7 - BIOHAZARD"};
    int iconejogos[] = {R.drawable.re3icon, R.drawable.re2icon, R.drawable.re4icon, R.drawable.re8icon,R.drawable.re7icon};
    int fototips[] = {R.drawable.tipsre3,R.drawable.tipsre2,R.drawable.tipsre4,R.drawable.tipsre8,R.drawable.tipsre7};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lista);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        ImageView imageView = findViewById(R.id.starslogo);

        listView = (ListView) findViewById(R.id.lista);
        Adapimg adap = new Adapimg(getApplicationContext(), nomejogos, iconejogos);
        listView.setAdapter(adap);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        clickSound = MediaPlayer.create(this, R.raw.click);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clickSound != null) {
                    clickSound.start();
                }
                Intent intent = new Intent(MainLista.this, MainPresentation.class);
                startActivity(intent);
                finish();
            }
        });
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (clickSound != null) {
                clickSound.start();
            }
            Intent detalhesIntent = new Intent(MainLista.this, MainDetails.class);
            detalhesIntent.putExtra("FOTOTIPS", fototips[position]);
            detalhesIntent.putExtra("DICA_JOGO", dicas[position]);
            startActivity(detalhesIntent);
        });

    }
}