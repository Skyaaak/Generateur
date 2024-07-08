package cj.generateur;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultatLettre, resultatNb;
    private EditText saisieMin, saisieMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Saisie des nombre min et max
        this.saisieMin = findViewById(R.id.id_editNb_min);
        this.saisieMax = findViewById(R.id.id_editNb_max);

        // Vue des résultats
        this.resultatLettre = findViewById(R.id.id_txtView_resultat_lettre);
        this.resultatNb = findViewById(R.id.id_txtView_resultat_nombre);

        // Vider le texte
        this.saisieMin.setText("");
        this.saisieMax.setText("");
        this.resultatLettre.setText("");
        this.resultatNb.setText("");

    }

    public void onClickGenererNombre(View view) {

        int min = 0, max = 0;

        // Récupérer le nombre saisie au format chaine de caractères
        String minString = saisieMin.getText().toString();

        // Vérifier que la saisie n'est pas vide
        if (!TextUtils.isEmpty(minString)) {
            // Transformer la chaine de caractère en un nombre entier
            min = Integer.parseInt(minString);
        } else {
            Toast.makeText(MainActivity.this, "Veuillez saisir un nombre minimal", Toast.LENGTH_SHORT).show();
        }

        // On recommence mais avec le nombre max
        String maxString = saisieMax.getText().toString();
        if (!TextUtils.isEmpty(maxString)) {
            max = Integer.parseInt(maxString);
        } else {
            Toast.makeText(MainActivity.this, "Veuillez saisir un nombre maximal", Toast.LENGTH_SHORT).show();
        }

        int nombre = (int) (Math.random() * (max - min + 1 ))+min;
        this.resultatNb.setText(String.valueOf(nombre));
    }

    public void onClickGenererLettre(View view) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random random = new Random();
        int index = random.nextInt(alphabet.length());

        String lettre = String.valueOf(alphabet.charAt(index));
        this.resultatLettre.setText(lettre);
    }
}