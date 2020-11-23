package com.tatv.tffcaculator.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tatv.tffcaculator.R;

public class CurrencyFragment extends Fragment implements View.OnClickListener{
    private TextView expr,result,ce,openBrc,closeBrc,div,mul,minus,plus,dot,back,equals;
    private TextView zero,one,two,three,four,five,six,seven,eight,nine;
    private TextView topLvl,btmLvl,rev,sin,cos,tan,pow,sqroot,fact;

    private boolean bdt2dollar = true;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_currency, container, false);
        init();
        return view;
    }
    private void init() {
        expr = view.findViewById(R.id.expr);
        result = view.findViewById(R.id.result);
        ce = view.findViewById(R.id.ce);
        dot = view.findViewById(R.id.dot);
        back = view.findViewById(R.id.back);
        equals = view.findViewById(R.id.equals);
        //fact = view.findViewById(R.id.fact);

        zero = view.findViewById(R.id.zero);
        one = view.findViewById(R.id.one);
        two = view.findViewById(R.id.two);
        three = view.findViewById(R.id.three);
        four = view.findViewById(R.id.four);
        five = view.findViewById(R.id.five);
        six = view.findViewById(R.id.six);
        seven = view.findViewById(R.id.seven);
        eight = view.findViewById(R.id.eight);
        nine = view.findViewById(R.id.nine);
        topLvl = view.findViewById(R.id.topLvl);
        btmLvl = view.findViewById(R.id.btmLvl);
        rev = view.findViewById(R.id.rev);

        // Numbers
//        one.setOnClickListener(this);
//        two.setOnClickListener(this);
//        three.setOnClickListener(this);
//        four.setOnClickListener(this);
//        five.setOnClickListener(this);
//        six.setOnClickListener(this);
//        seven.setOnClickListener(this);
//        eight.setOnClickListener(this);
//        nine.setOnClickListener(this);
//        zero.setOnClickListener(this);
//        dot.setOnClickListener(this);
//        rev.setOnClickListener(this);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("1",true);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("2",true);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("3",true);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("4",true);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("5",true);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("6",true);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("7",true);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("8",true);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("9",true);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("0",true);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr(".",true);
            }
        });


        rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bdt2dollar) {
                    topLvl.setText("$");
                    btmLvl.setText("Tk");
                } else {
                    topLvl.setText("Tk");
                    btmLvl.setText("$");
                }
                bdt2dollar = !bdt2dollar;
                try {
                    double input = Double.parseDouble(expr.getText().toString());
                    double reslt;
                    if(bdt2dollar){
                        reslt = input * 0.012; // Celcious to Faren
                    } else {
                        reslt = input * 84.50 ;
                    }
                    int intres = (int) reslt;
                    if (reslt == intres) {
                        result.setText(Integer.toString(intres));
                    } else {
                        result.setText(Double.toString(reslt));
                    }
                } catch (Exception e) {
                    result.setText("Invalid Op!");
                }
            }
        });




        //Operators
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText("");
                result.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = expr.getText().toString();
                if(!string.isEmpty()){
                    expr.setText(string.substring(0,string.length()-1));
                }
                result.setText("");
            }
        });


        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double input = Double.parseDouble(expr.getText().toString());
                    double reslt;
                    String calcType;
                    if(bdt2dollar){
                        calcType = " (BDT 2 DOLLAR)";
                        reslt = input * 0.012; // Celcious to Faren
                    } else {
                        calcType = " (DOLLAR 2 BDT)";
                        reslt = input * 84.50 ;
                    }
                    int intres = (int) reslt;
                    String finalResult;
                    if (reslt == intres) {
                        result.setText(Integer.toString(intres));
                        finalResult = Integer.toString(intres);
                    } else {
                        result.setText(Double.toString(reslt));
                        finalResult = Double.toString(reslt);
                    }
                } catch (Exception e) {
                    result.setText("Invalid Op!");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    void appendOnExpr(String string , Boolean canClear){
        if(!result.getText().toString().isEmpty()){
            expr.setText("");
        }

        if(canClear){
            result.setText("");
            expr.append(string);
        }else{
            expr.append(result.getText());
            expr.append(string);
            result.setText("");
        }
    }
}
