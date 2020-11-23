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

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class StandardFragment extends Fragment {
    View view;
    private TextView expr,result,ce,openBrc,closeBrc,div,mul,minus,plus,dot,back,equals;
    private TextView zero,one,two,three,four,five,six,seven,eight,nine;
    private TextView sin,cos,tan,pow,sqroot,fact;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_standard, container, false);
        init();
        return view;
    }
    private void init() {
        expr = view.findViewById(R.id.expr);
        result = view.findViewById(R.id.result);
        ce = view.findViewById(R.id.ce);
        openBrc = view.findViewById(R.id.openBrc);
        closeBrc = view.findViewById(R.id.closeBrc);
        div = view.findViewById(R.id.div);
        mul = view.findViewById(R.id.mul);
        minus = view.findViewById(R.id.minus);
        plus = view.findViewById(R.id.plus);
        dot = view.findViewById(R.id.dot);
        back = view.findViewById(R.id.back);
        equals = view.findViewById(R.id.equals);
        sin = view.findViewById(R.id.sin);
        cos = view.findViewById(R.id.cos);
        tan = view.findViewById(R.id.tan);
        pow = view.findViewById(R.id.pow);
        sqroot = view.findViewById(R.id.sqroot);
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



        // Numbers
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


        // Operators
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("+",false);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("-",false);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("*",false);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("/",false);
            }
        });
        openBrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("(",false);
            }
        });
        closeBrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr(")",false);
            }
        });

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

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("sin(",false);
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("cos(",false);
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("tan(",false);
            }
        });
        sqroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("sqrt(",false);
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("^",false);
            }
        });







        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Expression expression = new ExpressionBuilder(expr.getText().toString()).build();
                    double reslt = expression.evaluate();
                    int intres = (int) reslt;
                    String inputExpr = expr.getText().toString();
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
