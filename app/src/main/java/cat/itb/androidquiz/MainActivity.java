package cat.itb.androidquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import static android.net.wifi.WifiConfiguration.Status.strings;

public class MainActivity extends AppCompatActivity {

    TextView text;
    ProgressBar bar;
    TextView questionsleft;
    Button botoA; Button botoB; Button botoC; Button botoD;
    Button hintButton;
    int numPreguntes;
    AlertDialog.Builder builder;

    String[] preguntes;
    String[] respostes;
    Random rgen = new Random();
    int numeroDeHints;
    float puntuacio;
    boolean hintUsed;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                                                                                                    // inicia imports de strings
        final Resources res = getResources();
        builder = new AlertDialog.Builder(this);
        preguntes = res.getStringArray(R.array.preguntes);
        respostes = res.getStringArray(R.array.respostes);
        text = findViewById(R.id.preguntes);
        bar = findViewById(R.id.progressBar);
        questionsleft = findViewById(R.id.questionsleft);
        botoA = findViewById(R.id.botoA); botoB = findViewById(R.id.botoB); botoC = findViewById(R.id.botoC); botoD = findViewById(R.id.botoD);
        hintButton = findViewById(R.id.hintButton);

                                                                                                    // Iniciadors
        numPreguntes=1;
        numeroDeHints = 3;
        text.setText(preguntes[numPreguntes]);
        questionsleft.setText("Question "+(numPreguntes)+" out of 10.");
        botoA.setText("Europe");
        botoB.setText("Africa");
        botoC.setText("Asia");
        botoD.setText("America");
        puntuacio= 0;
        hintUsed= false;
                                                                                                    // Random number generator
        for (int i=0; i<preguntes.length; i++) {
            int randomPosition = rgen.nextInt(preguntes.length);
            String temp = preguntes[i];
            preguntes[i] = preguntes[randomPosition];
            preguntes[randomPosition] = temp;  }
                                                                                                    // Botons
        botoA.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            public void onClick(View v) {
                numPreguntes++;
                questionsleft.setText("Question "+numPreguntes+" out of 10.");
                bar.incrementProgressBy(11);
                Toast toast;
                if (respostes[numPreguntes].equals("1")){
                    toast = Toast.makeText(getApplicationContext(), "The aswer was correct.", Toast.LENGTH_SHORT);
                    if(!hintUsed) puntuacio+=1;
                }else{
                    toast = Toast.makeText(getApplicationContext(), "Wrong answer.", Toast.LENGTH_SHORT);
                    puntuacio-=0.5;
                }
                toast.show();

                if (numPreguntes>=10){
                    builder.setMessage("Quiz ended, score: "+ puntuacio*10 +". Try again?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                //                                                                 RESET DE EL QUIZ
                                numPreguntes=1;
                                text.setText(preguntes[numPreguntes]);
                                questionsleft.setText("Question "+(numPreguntes)+" out of 10.");
                                bar.setProgress(0);
                                numeroDeHints = 3;
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Well Done!");
                    alert.show();
            }else{text.setText(preguntes[numPreguntes]);}
                hintUsed= false;
            }

        });

        botoB.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            public void onClick(View v) {
                numPreguntes++;
                questionsleft.setText("Question "+numPreguntes+" out of 10.");
                bar.incrementProgressBy(11);
                Toast toast;
                if (respostes[numPreguntes].equals("2")){
                    toast = Toast.makeText(getApplicationContext(), "The aswer was correct.", Toast.LENGTH_SHORT);
                    if(!hintUsed) puntuacio+=1;
                }else{
                    toast = Toast.makeText(getApplicationContext(), "Wrong answer.", Toast.LENGTH_SHORT);
                    puntuacio-=0.5;
                }
                toast.show();

                if (numPreguntes>=10){
                    builder.setMessage("Quiz ended, score: "+ puntuacio*10 +". Try again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    //                                                                 RESET DE EL QUIZ
                                    numPreguntes=1;
                                    text.setText(preguntes[numPreguntes]);
                                    questionsleft.setText("Question "+(numPreguntes)+" out of 10.");
                                    bar.setProgress(0);
                                    numeroDeHints = 3;
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Well Done!");
                    alert.show();
                }else{text.setText(preguntes[numPreguntes]);}
                hintUsed= false;
            }

        });

        botoC.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            public void onClick(View v) {
                numPreguntes++;
                questionsleft.setText("Question "+numPreguntes+" out of 10.");
                bar.incrementProgressBy(11);
                Toast toast;
                if (respostes[numPreguntes].equals("3")){
                    toast = Toast.makeText(getApplicationContext(), "The aswer was correct.", Toast.LENGTH_SHORT);
                    if(!hintUsed) puntuacio+=1;
                }else{
                    toast = Toast.makeText(getApplicationContext(), "Wrong answer.", Toast.LENGTH_SHORT);
                    puntuacio-=0.5;
                }
                toast.show();

                if (numPreguntes>=10){
                    builder.setMessage("Quiz ended, score: "+ puntuacio*10 +". Try again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    //                                                                 RESET DE EL QUIZ
                                    numPreguntes=1;
                                    text.setText(preguntes[numPreguntes]);
                                    questionsleft.setText("Question "+(numPreguntes)+" out of 10.");
                                    bar.setProgress(0);
                                    numeroDeHints = 3;
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Well Done!");
                    alert.show();
                }else{text.setText(preguntes[numPreguntes]);}
                hintUsed= false;
            }

        });

        botoD.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            public void onClick(View v) {
                numPreguntes++;
                questionsleft.setText("Question "+numPreguntes+" out of 10.");
                bar.incrementProgressBy(11);
                Toast toast;
                if (respostes[numPreguntes].equals("4")){
                    toast = Toast.makeText(getApplicationContext(), "The aswer was correct.", Toast.LENGTH_SHORT);
                    if(!hintUsed) puntuacio+=1;
                }else{
                    toast = Toast.makeText(getApplicationContext(), "Wrong answer.", Toast.LENGTH_SHORT);
                    puntuacio-=0.5;
                }
                toast.show();

                if (numPreguntes>=10){
                    builder.setMessage("Quiz ended, score: "+ puntuacio*10 +". Try again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    //                                                                 RESET DE EL QUIZ
                                    numPreguntes=1;
                                    text.setText(preguntes[numPreguntes]);
                                    questionsleft.setText("Question "+(numPreguntes)+" out of 10.");
                                    bar.setProgress(0);
                                    numeroDeHints = 3;
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Well Done!");
                    alert.show();
                }else{text.setText(preguntes[numPreguntes]);}
                hintUsed= false;
            }

        });

        hintButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            public void onClick(View v) {

                if (numeroDeHints!=0) {
                    Toast toast;
                    toast = Toast.makeText(getApplicationContext(), "La resposta és " + respostes[numPreguntes], Toast.LENGTH_SHORT);
                    toast.show();
                    numeroDeHints -= 1;
                    hintUsed= true;
                }else{
                    Toast toast;
                    toast = Toast.makeText(getApplicationContext(), "Se't han acabat les pistes!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

        });



    }
}