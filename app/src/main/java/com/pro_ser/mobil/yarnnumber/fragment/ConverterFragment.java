package com.pro_ser.mobil.yarnnumber.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.support.annotation.NonNull;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;
import com.pro_ser.mobil.yarnnumber.MainActivity;
import com.pro_ser.mobil.yarnnumber.R;
import org.w3c.dom.Text;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

public class ConverterFragment extends Fragment {

    Double den, ktex, tex, Nm, Ne, NeL, NeK, New, dtex, mtex;
    DecimalFormat f;
    Boolean ManAuto = true; //if ManAuto is true people send data if ManAuto is false program send data

    public ConverterFragment() {
    }

        View tasinan;


    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_converter, container, false);

        f = new DecimalFormat("##.###");


        final EditText etlenght = (EditText) v.findViewById(R.id.etlenght);
        final EditText etweight = (EditText) v.findViewById(R.id.etweight);
        final Button calculate = (Button) v.findViewById(R.id.btnconvert);
        final EditText txtdenresult = (EditText) v.findViewById(R.id.txtdenresult);
        final EditText txtktexresult = (EditText) v.findViewById(R.id.txtktexresult);
        final EditText txttexresult = (EditText) v.findViewById(R.id.txttexresult);
        final EditText txtdtexresult = (EditText) v.findViewById(R.id.txtdtexresult);
        final EditText txtmtexresult = (EditText) v.findViewById(R.id.txtmtexresult);
        final EditText txtNmresult = (EditText) v.findViewById(R.id.txtNmresult);
        final EditText txtNeresult = (EditText) v.findViewById(R.id.txtNeresult);
        final EditText txtNeLresult = (EditText) v.findViewById(R.id.txtNeLresult);
        final EditText txtNeKresult = (EditText) v.findViewById(R.id.txtNeKresult);
        final EditText txtNeWresult = (EditText) v.findViewById(R.id.txtNeWresult);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etlenght.getText().toString().isEmpty() && !etweight.getText().toString().isEmpty()){
                ManAuto = false;
                Nm = Double.parseDouble(etlenght.getText().toString()) / Double.parseDouble(etweight.getText().toString());
                den = 9000 / Nm;
                ktex = 1 / Nm;
                tex = 1000 / Nm;
                dtex = 10000 / Nm;
                mtex = 1000000 / Nm;
                Ne = (0.59) * Nm;
                NeL = (1.654) * Nm;
                NeK = (0.886) * Nm;
                New = (1.938) * Nm;

                txtdenresult.setText(f.format(den).toString());
                txtktexresult.setText(f.format(ktex).toString());
                txttexresult.setText(f.format(tex).toString());
                txtdtexresult.setText(f.format(dtex).toString());
                txtmtexresult.setText(f.format(mtex).toString());
                txtNmresult.setText(f.format(Nm).toString());
                txtNeresult.setText(f.format(Ne).toString());
                txtNeLresult.setText(f.format(NeL).toString());
                txtNeKresult.setText(f.format(NeK).toString());
                txtNeWresult.setText(f.format(New).toString());




                ManAuto = true;
                }else{

                }


            }
        });


        txtdenresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtdenresult.getText().toString().isEmpty() && ManAuto == true) {
                    den = Double.parseDouble(txtdenresult.getText().toString());
                    Nm = 9000 / den;
                    ktex = 0.00011 * den;
                    tex = 0.111 * den;
                    dtex = 1.111 * den;
                    mtex = 111 * den;
                    Ne = 5315 / den;
                    NeL = 14882 / den;
                    NeK = 7972 / den;
                    New = 17440 / den;

                    ManAuto = false;
                    //txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });

        txtktexresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtktexresult.getText().toString().isEmpty() && ManAuto == true) {
                    ktex = Double.parseDouble(txtktexresult.getText().toString());
                    Nm = 1 / ktex;
                    den = 9000 * ktex;
                    tex = 1000 * ktex;
                    dtex = 10000 * ktex;
                    mtex = 1000000 * ktex;
                    Ne =   (0.59) / ktex;
                    NeL = 1654 / ktex;
                    NeK = 0.886 / ktex;
                    New = 1.938 / ktex;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });
        txttexresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txttexresult.getText().toString().isEmpty() && ManAuto == true) {
                    tex = Double.parseDouble(txttexresult.getText().toString());
                    Nm = 1000/tex;
                    den = 9*tex;
                    dtex = 10*tex;
                    New = 1938/tex;
                    ktex = 0.001*tex;
                    mtex = 1000 * tex;
                    Ne = 590 / tex;
                    NeL = 1654 / tex;
                    NeK = 886 / tex;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    //txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto =true;
                }
            }
        });
        txtdtexresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtdtexresult.getText().toString().isEmpty() && ManAuto == true) {
                    dtex = Double.parseDouble(txtdtexresult.getText().toString());
                    Nm = 10000/dtex;
                    den = 0.9*dtex;
                    tex = 0.1*dtex;
                    New = 19380/dtex;
                    ktex = 0.0001*dtex;
                    mtex = 100*dtex;
                    Ne = 5900/dtex;
                    NeL = 16540/dtex;
                    NeK = 8860/dtex;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    txttexresult.setText(f.format(tex).toString());
                    //txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });
        txtmtexresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtmtexresult.getText().toString().isEmpty() && ManAuto == true) {
                    mtex = Double.parseDouble(txtmtexresult.getText().toString());
                    Nm = 1 / ktex;
                    den = 0.009 * mtex;
                    tex = 0.001 * mtex;
                    dtex = 0.1 * mtex;
                    ktex = 0.000001 * mtex;
                    Ne = 590000 / mtex;
                    NeL = 1654000 / mtex;
                    NeK = 886000 / mtex;
                    New = 1938000 / mtex;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    //txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });
        txtNmresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtNmresult.getText().toString().isEmpty() && ManAuto == true) {
                    Nm = Double.parseDouble(txtNmresult.getText().toString());
                    den = 9000 / Nm;
                    ktex = 1 / Nm;
                    tex = 1000 / Nm;
                    dtex = 10000 / Nm;
                    mtex = 1000000 / Nm;
                    Ne = (0.59) * Nm;
                    NeL = (1.654) * Nm;
                    NeK = (0.886) * Nm;
                    New = (1.938) * Nm;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    //txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });
        txtNeresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtNeresult.getText().toString().isEmpty() && ManAuto == true) {
                    Ne = Double.parseDouble(txtNeresult.getText().toString());
                    Nm = 1.693*Ne;
                    den = 5315 / Ne;
                    tex = 590 / Ne;
                    dtex = 5900 / Ne;
                    ktex = 0.590 / Ne;
                    mtex = 590000 / Ne;
                    NeL = 2.8 / Ne;
                    NeK = 1.5 / Ne;
                    New = 3.28 / Ne;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    //txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });
        txtNeLresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtNeLresult.getText().toString().isEmpty() && ManAuto==true) {
                    NeL = Double.parseDouble(txtNeLresult.getText().toString());
                    Nm = 0.605*NeL;
                    den = 14882/NeL;
                    tex = 1654/NeL;
                    dtex = 16540/NeL;
                    ktex = 1.654/NeL;
                    mtex = 1654000/NeL;
                    Ne = 0.357*NeL;
                    NeK = 0.536*NeL;
                    New = 1.172*NeL;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    //txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });
        txtNeKresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtNeKresult.getText().toString().isEmpty() && ManAuto == true) {
                    NeK = Double.parseDouble(txtNeKresult.getText().toString());
                    Nm =1.129*NeK;
                    den = 7972/NeK;
                    tex = 886/NeK;
                    dtex = 8860/NeK;
                    ktex = 0.886/NeK;
                    mtex = 886000/NeK;
                    Ne = 0.667*NeK;
                    NeL = 1.867*NeK;
                    New = 2.188*NeK;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    //txtNeKresult.setText(f.format(NeK).toString());
                    txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });
        txtNeWresult.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!txtNeWresult.getText().toString().isEmpty() && ManAuto == true) {
                    New = Double.parseDouble(txtNeWresult.getText().toString());
                    Nm = 0.516 * New;
                    den = 17440/New;
                    tex = 1938/New;
                    dtex = 19380/New;
                    ktex = 1.938/New;
                    mtex = 1938000/New;
                    Ne = 0.305*New;
                    NeL = 0.853*New;
                    NeK = 0.457*New;
                    ManAuto = false;
                    txtdenresult.setText(f.format(den).toString());
                    txtktexresult.setText(f.format(ktex).toString());
                    txttexresult.setText(f.format(tex).toString());
                    txtdtexresult.setText(f.format(dtex).toString());
                    txtmtexresult.setText(f.format(mtex).toString());
                    txtNmresult.setText(f.format(Nm).toString());
                    txtNeresult.setText(f.format(Ne).toString());
                    txtNeLresult.setText(f.format(NeL).toString());
                    txtNeKresult.setText(f.format(NeK).toString());
                    //txtNeWresult.setText(f.format(New).toString());
                    ManAuto = true;
                }
            }
        });






        return v;
    }



}
