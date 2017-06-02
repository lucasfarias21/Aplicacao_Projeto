package com.example.lucasfarias.aplicacao_projeto;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by lucasfarias on 23/05/17.
 */

public class Tab1Kml extends Fragment implements View.OnClickListener {

    private int contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab1_kml, container, false);


        final EditText km_autonomia = (EditText) rootView.findViewById(R.id.txt_autonomia_veiculo);
        final EditText km_trajeto = (EditText) rootView.findViewById(R.id.txt_distancia_trajeto);
        final EditText valor_combustivel = (EditText) rootView.findViewById(R.id.txt_valor_combustivel);
        final Button btn_calcular_tab1 = (Button) rootView.findViewById(R.id.btn_calc_kml);

        btn_calcular_tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                KML = (Quilometragem B - Quilometragem A) ÷ Litros.
                Subtraia a Quilometragem A da Quilometragem B. Isso dará a você o número de
                quilômetros que você rodou desde a última vez que encheu o tanque.
                Divida o resultado pelo número de Litros necessários para encher o seu tanque.
                O resultado final será o KML do seu carro.
                 */

                if (km_autonomia.getText().toString().equals("") || km_trajeto.getText().toString().equals("")
                        || valor_combustivel.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Os são campos obrigatórios! ", Toast.LENGTH_LONG).show();
                } else {
                    Double autonomia = Double.valueOf(km_autonomia.getText().toString());
                    Double trajeto = Double.valueOf(km_trajeto.getText().toString());
                    Double valorCombustivel = Double.valueOf(valor_combustivel.getText().toString());

                    Double resultado_kml = trajeto / autonomia;
                    Double resultado_final = resultado_kml / valorCombustivel;

                    resultado_final = Double.valueOf(String.format(Locale.US, "%.2f", resultado_final));

                    //imprimindo mensagem com o resultado
                    TextView texto_resultado = (TextView) rootView.findViewById(R.id.texto_resultado);
                    texto_resultado.setText("R$ " + resultado_final + " Km/l");

                    km_autonomia.setText("");
                    km_trajeto.setText("");
                    valor_combustivel.setText("");
                }
            }
        });
        return rootView;
    }


    @Override
    public void onClick(View v) {

    }

}
