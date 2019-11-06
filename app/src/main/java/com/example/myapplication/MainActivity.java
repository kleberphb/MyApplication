package com.example.myapplication;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText alt_antena_1;
    private EditText alt_antena_2;

    private Double d1, d2, visada;
    private TextView dist_ant01, dist_ant02, visadas, tv_visada, tv_dist_01, tv_dist_02, questao, resposta;
    private ImageView duvida;
    private ConstraintLayout cl_vis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alt_antena_1 = findViewById(R.id.antena_01);
        alt_antena_2 = findViewById(R.id.antena_02);
        dist_ant01 = findViewById(R.id.distancia1);
        dist_ant02 = findViewById(R.id.distancia2);
        visadas = findViewById(R.id.visada);
        tv_dist_01 = findViewById(R.id.tv_dist_01);
        tv_dist_02 = findViewById(R.id.tv_dist_02);
        tv_visada = findViewById(R.id.tv_visada);
        questao = findViewById(R.id.questao);
        resposta = findViewById(R.id.resposta);
        duvida = findViewById(R.id.duvida);
        cl_vis = findViewById(R.id.cl_vis);

        dist_ant01.setVisibility(View.GONE);
        dist_ant02.setVisibility(View.GONE);
        visadas.setVisibility(View.GONE);
        questao.setVisibility(View.VISIBLE);
        resposta.setVisibility(View.GONE);
        duvida.setVisibility(View.VISIBLE);
        cl_vis.setVisibility(View.GONE);

        tv_dist_01.setText("");
        tv_dist_02.setText("");
        tv_visada.setText("");

        alt_antena_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                calculo();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        alt_antena_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                calculo();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void calculo() {

        if (!alt_antena_1.getText().toString().isEmpty() &&
                !alt_antena_2.getText().toString().isEmpty()) {

            d1 = Double.parseDouble(alt_antena_1.getText().toString());
            d2 = Double.parseDouble(alt_antena_2.getText().toString());

            double distancia_1 = Math.sqrt(12.7 * d1);
            double distancia_2 = Math.sqrt(12.7 * d2);
            visada = distancia_1 + distancia_2;

            String dist_01 = String.format("%.3f", distancia_1);
            String dist_02 = String.format("%.3f", distancia_2);
            String visad = String.format("%.3f", visada);

            dist_ant01.setText("O alcance da antena A é de " + dist_01 + " m");
            dist_ant02.setText("O alcance da antena B é de " + dist_02 + " m");
            visadas.setText("A visada entre elas é de " + visad + " m");
            tv_dist_01.setText("d=" + dist_01 + "m");
            tv_dist_02.setText("d=" + dist_02 + "m");
            tv_visada.setText("Visada=" + visad + "m");

            dist_ant01.setVisibility(View.VISIBLE);
            dist_ant02.setVisibility(View.VISIBLE);
            visadas.setVisibility(View.VISIBLE);
            resposta.setVisibility(View.VISIBLE);
            questao.setVisibility(View.GONE);
            duvida.setVisibility(View.GONE);
            cl_vis.setVisibility(View.VISIBLE);

        } else {

            dist_ant01.setText("");
            dist_ant02.setText("");
            visadas.setText("");
            tv_dist_01.setText("");
            tv_dist_02.setText("");
            tv_visada.setText("");

            dist_ant01.setVisibility(View.GONE);
            dist_ant02.setVisibility(View.GONE);
            visadas.setVisibility(View.GONE);
            resposta.setVisibility(View.GONE);
            questao.setVisibility(View.VISIBLE);
            duvida.setVisibility(View.VISIBLE);
            cl_vis.setVisibility(View.GONE);


        }

    }
}
