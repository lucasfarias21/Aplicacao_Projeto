package com.example.lucasfarias.aplicacao_projeto;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by lucasfarias on 23/05/17.
 */

public class Tab3Km extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3_km, container, false);

        final EditText kilometro_percorrido = (EditText) rootView.findViewById(R.id.txt_km_rodado_total);
        final EditText litros_total_abastecido = (EditText) rootView.findViewById(R.id.txt_litros_abastecidos_total);
        final Button botao_calcular_total = (Button) rootView.findViewById(R.id.btn_calc_tab3);

        botao_calcular_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kilometro_percorrido.getText().toString().equals("") || litros_total_abastecido.getText()
                        .toString().equals("")) {
                    Toast.makeText(getActivity(), "Os campos são obrigatórios! ", Toast.LENGTH_LONG).show();
                } else {
                    Double texto_km_total = Double.valueOf(kilometro_percorrido.getText().toString());
                    Double texto_litro_total = Double.valueOf(litros_total_abastecido.getText().toString());
                    Double resultado_calculado = texto_km_total / texto_litro_total;

                    // Toast.makeText(getActivity(), "Resultado: " + resultado_calculado, Toast.LENGTH_LONG).show();

                    //resultado_final = Double.valueOf(String.format(Locale.US, "%.2f", resultado_final));
                    resultado_calculado = Double.valueOf(String.format(Locale.US, "%.2f", resultado_calculado));
                    //imprimindo mensagem com o resultado
                    TextView texto_resultado = (TextView) rootView.findViewById(R.id.texto_resultado_tab3);
                    texto_resultado.setText(resultado_calculado + " Km/l");

                    kilometro_percorrido.setText("");
                    litros_total_abastecido.setText("");

                }

            }
        });

        return rootView;
    }

    @Override
    public void onClick(View v) {

    }
}
