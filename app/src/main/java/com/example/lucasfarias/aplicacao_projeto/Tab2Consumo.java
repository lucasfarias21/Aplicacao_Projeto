package com.example.lucasfarias.aplicacao_projeto;

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

public class Tab2Consumo extends Fragment implements View.OnClickListener {
    private int contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tab2_consumo, container, false);

        final EditText alcool = (EditText) rootView.findViewById(R.id.txt_alcool);
        final EditText gasolina = (EditText) rootView.findViewById(R.id.txt_gasolina);
        final Button btn_calc = (Button) rootView.findViewById(R.id.btn_calc);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pegamos o conteudo do campo de texto
                if (alcool.getText().toString().equals("") || gasolina.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Os campos são obrigatórios!", Toast.LENGTH_LONG).show();
                } else {
                    Double valor_alcool = Double.valueOf(alcool.getText().toString());
                    Double valor_gasolina = Double.valueOf(gasolina.getText().toString());
                    Double res = valor_alcool / valor_gasolina;
                    res = Double.valueOf(String.format(Locale.US, "%.2f", res));
                    if (res <= 0.7) {
                        // Mostramos uma mensagem na tela do usuáo
                        TextView texto_resultado = (TextView) rootView.findViewById(R.id.texto_resultado_tab2);
                        texto_resultado.setText("Etanol");
                    } else {
                        TextView texto_resultado = (TextView) rootView.findViewById(R.id.texto_resultado_tab2);
                        texto_resultado.setText("Gasolina");


                    }
                    alcool.setText("");
                    gasolina.setText("");
                }
            }
        });
        return rootView;
    }

    @Override
    public void onClick(View v) {

    }
}
