package com.pro_ser.mobil.yarnnumber.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.pro_ser.mobil.yarnnumber.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;


public class CalculatorFragment extends Fragment {

    private String[] arrayType;
    private String[] arrayNumber;
    DecimalFormat f;

    public CalculatorFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculator, container, false);

        f = new DecimalFormat("##.##");

        final Spinner spType=(Spinner) v.findViewById(R.id.spType);
        final Spinner spNumber=(Spinner) v.findViewById(R.id.spNumber);
        final EditText etNmbr1 = (EditText) v.findViewById(R.id.etNmbr1);
        final EditText etNmbr2 = (EditText) v.findViewById(R.id.etNmbr2);
        final EditText etNmbr3 = (EditText) v.findViewById(R.id.etNmbr3);
        final EditText etNmbr4 = (EditText) v.findViewById(R.id.etNmbr4);
        final EditText etNmbr5 = (EditText) v.findViewById(R.id.etNmbr5);
        final EditText etNmbr6 = (EditText) v.findViewById(R.id.etNmbr6);
        final Button btnCalculate = (Button) v.findViewById(R.id.btncalculate);
        final TextView txtresult = (TextView) v.findViewById(R.id.txtresult);




        this.arrayType = new String[] {
                "den", "ktex", "tex", "Nm", "Ne", "NeL", "NeK", "New", "dtex", "mtex"
        };
        this.arrayNumber = new String[]{
                "2", "3", "4", "5", "6"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arrayType);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spType.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arrayNumber);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spNumber.setAdapter(adapter2);

        spNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0 :
                        etNmbr1.setEnabled(true);
                        etNmbr2.setEnabled(true);
                        etNmbr3.setEnabled(false);
                        etNmbr4.setEnabled(false);
                        etNmbr5.setEnabled(false);
                        etNmbr6.setEnabled(false);

                        etNmbr3.setText("0");
                        etNmbr4.setText("0");
                        etNmbr5.setText("0");
                        etNmbr6.setText("0");

                        break;

                    case 1 :
                        etNmbr1.setEnabled(true);
                        etNmbr2.setEnabled(true);
                        etNmbr3.setEnabled(true);
                        etNmbr4.setEnabled(false);
                        etNmbr5.setEnabled(false);
                        etNmbr6.setEnabled(false);

                        etNmbr4.setText("0");
                        etNmbr5.setText("0");
                        etNmbr6.setText("0");

                        break;

                    case 2 :
                        etNmbr1.setEnabled(true);
                        etNmbr2.setEnabled(true);
                        etNmbr3.setEnabled(true);
                        etNmbr4.setEnabled(true);
                        etNmbr5.setEnabled(false);
                        etNmbr6.setEnabled(false);

                        etNmbr5.setText("0");
                        etNmbr6.setText("0");

                        break;

                    case 3 :
                        etNmbr1.setEnabled(true);
                        etNmbr2.setEnabled(true);
                        etNmbr3.setEnabled(true);
                        etNmbr4.setEnabled(true);
                        etNmbr5.setEnabled(true);
                        etNmbr6.setEnabled(false);

                        etNmbr6.setText("0");
                        break;

                    case 4 :
                        etNmbr1.setEnabled(true);
                        etNmbr2.setEnabled(true);
                        etNmbr3.setEnabled(true);
                        etNmbr4.setEnabled(true);
                        etNmbr5.setEnabled(true);
                        etNmbr6.setEnabled(true);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                etNmbr1.setEnabled(true);
                etNmbr2.setEnabled(true);
                etNmbr3.setEnabled(false);
                etNmbr4.setEnabled(false);
                etNmbr5.setEnabled(false);
                etNmbr6.setEnabled(false);
            }

        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String choosenType = spType.getSelectedItem().toString();
                String choosenNumber = spNumber.getSelectedItem().toString();

                if(!etNmbr1.getText().toString().isEmpty()&&!etNmbr2.getText().toString().isEmpty()&&!etNmbr3.getText().toString().isEmpty()&&!etNmbr4.getText().toString().isEmpty()&&!etNmbr5.getText().toString().isEmpty()&&!etNmbr6.getText().toString().isEmpty()){
                final double N1 = Double.parseDouble(etNmbr1.getText().toString());
                final double N2 = Double.parseDouble(etNmbr2.getText().toString());
                final double N3 = Double.parseDouble(etNmbr3.getText().toString());
                final double N4 = Double.parseDouble(etNmbr4.getText().toString());
                final double N5 = Double.parseDouble(etNmbr5.getText().toString());
                final double N6 = Double.parseDouble(etNmbr6.getText().toString());

                if (choosenType.equals("NeL") || choosenType.equals("NeK") || choosenType.equals("New") || choosenType.equals("dtex") || choosenType.equals("mtex"))
                {
                    if (choosenNumber.equals("2"))
                    {
                        txtresult.setText(f.format((N1 * N2) / (N1 + N2))+ " " + choosenType);
                    }
                    else if (choosenNumber.equals("3"))
                    {
                        txtresult.setText(f.format((N1 * N2 * N3) / (((N1) * (N2)) + ((N2) * (N3)) + ((N1) * (N3))))+ " " + choosenType);
                    }
                    else if (choosenNumber.equals("4"))
                    {
                        txtresult.setText(f.format((N1 * N2 * N3 * N4) / ((N1 * N2 * N3) + (N1 * N2 * N4) + (N2 * N3 * N4) + (N1 * N3 * N4)))+ " " + choosenType);
                    }
                    else if (choosenNumber.equals("5"))
                    {
                        txtresult.setText(f.format((N1 * N2 * N3 * N4 * N5) / ((N1 * N2 * N3 * N4) + (N1 * N3 * N4 * N5) + (N1 * N2 * N4 * N5) + (N1 * N2 * N3 * N5) + (N2 * N3 * N4 * N5)))+ " " + choosenType);
                    }
                    else if (choosenNumber.equals("6"))
                    {
                        txtresult.setText(f.format((N1 * N2 * N3 * N4 * N5 * N6) / ((N1 * N2 * N3 * N4 * N5) + (N1 * N3 * N4 * N5 * N6) + (N1 * N2 * N4 * N5 * N6) + (N1 * N2 * N3 * N5 * N6) + (N1 * N2 * N3 * N4 * N6) + (N2 * N3 * N4 * N5 * N6)))+ " " + choosenType);
                    }
                }
                else
                {
                    if (choosenNumber.equals("2"))
                    {
                        txtresult.setText(f.format(((N1 * N2) / (N1 + N2))*4)+ " " + choosenType);
                    }
                    else if (choosenNumber.equals("3"))
                    {
                        txtresult.setText(f.format(((N1 * N2 * N3) / (((N1) * (N2)) + ((N2) * (N3)) + ((N1) * (N3))))*9)+ " " + choosenType);
                    }
                    else if (choosenNumber.equals("4"))
                    {
                        txtresult.setText(f.format((N1 * N2 * N3 * N4) / ((N1 * N2 * N3) + (N1 * N2 * N4) + (N2 * N3 * N4) + (N1 * N3 * N4))*16)+ " " + choosenType);
                    }
                    else if (choosenNumber.equals("5"))
                    {
                        txtresult.setText(f.format((N1 * N2 * N3 * N4 * N5) / ((N1 * N2 * N3 * N4) + (N1 * N3 * N4 * N5) + (N1 * N2 * N4 * N5) + (N1 * N2 * N3 * N5) + (N2 * N3 * N4 * N5))*25)+ " " + choosenType);
                    }
                    else if (choosenNumber.equals("6"))
                    {
                        txtresult.setText(f.format((N1 * N2 * N3 * N4 * N5 * N6) / ((N1 * N2 * N3 * N4 * N5) + (N1 * N3 * N4 * N5 * N6) + (N1 * N2 * N4 * N5 * N6) + (N1 * N2 * N3 * N5 * N6) + (N1 * N2 * N3 * N4 * N6) + (N2 * N3 * N4 * N5 * N6))*36)+ " " + choosenType);
                    }
                }
            }
            }
        });



        return v;
    }

}
