package com.sudhanshu.thecalculatorapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button add,sub,mul,div,clear,equal,plus_minus,mod,del;
    Button zero,one,two,three,four,five,six,seven,eight,nine;
    EditText input;
    TextView hint_text;
    static int ans = 0;
    double dob_ans = 0;
    boolean last_equal = false;
    boolean islast = false;
    int flag = 0; // Flag value to monitor last operation, 1 for add, 2 for sub, 3 for mul, 4 for div
    boolean float_on = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);

        sub = (Button)findViewById(R.id.sub);
        sub.setOnClickListener(this);

        mul = (Button)findViewById(R.id.mul);
        mul.setOnClickListener(this);

        div = (Button)findViewById(R.id.div);
        div.setOnClickListener(this);

        equal = (Button)findViewById(R.id.equal);
        equal.setOnClickListener(this);

        mod = (Button)findViewById(R.id.mod);
        mod.setOnClickListener(this);

        clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(this);

        plus_minus = (Button)findViewById(R.id.plus_minus);

        plus_minus.setOnClickListener(this);

        zero = (Button)findViewById(R.id.zero);
        zero.setOnClickListener(this);

        one = (Button)findViewById(R.id.one);
        one.setOnClickListener(this);

        two = (Button)findViewById(R.id.two);
        two.setOnClickListener(this);

        three = (Button)findViewById(R.id.three);
        three.setOnClickListener(this);

        four = (Button)findViewById(R.id.four);
        four.setOnClickListener(this);

        five = (Button)findViewById(R.id.five);
        five.setOnClickListener(this);

        six = (Button)findViewById(R.id.six);
        six.setOnClickListener(this);

        seven = (Button)findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight = (Button)findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine = (Button)findViewById(R.id.nine);
        nine.setOnClickListener(this);

        del = (Button)findViewById(R.id.del);
        del.setOnClickListener(this);

        hint_text = (TextView)findViewById(R.id.hint_text);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        input = (EditText)findViewById(R.id.input);
        String str1 = input.getText().toString();
        double dob_num;
        double check;
        int inpnum1;
        int numset;
        String stringset;

        if (id == R.id.add){
            if(str1 == null || str1.length()==0) {
                Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            }
            else {
                inpnum1 = Integer.parseInt(str1);
                input.setText("");
                if(last_equal){
                    ans = inpnum1;
                }
                else {
                    ans += inpnum1;
                }
                hint_text.setText("" + ans);
                flag = 1;
            }
        }
        else if (id == R.id.sub){
            if(str1 == null || str1.length()==0) {
                Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            }
            else {
                inpnum1 = Integer.parseInt(str1);
                input.setText("");
                if (last_equal) {
                    ans = inpnum1;
                } else {
                    ans -= inpnum1;
                }
                hint_text.setText("" + ans);
                flag = 2;
            }
        }
        else if (id == R.id.mul){
            if(str1 == null || str1.length()==0) {
                Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            }
            else {
                inpnum1 = Integer.parseInt(str1);
                input.setText("");
                if (last_equal) {
                    ans = inpnum1;
                } else {
                    ans *= inpnum1;
                }
                hint_text.setText("" + ans);
                flag = 3;
            }
        }
        else if (id == R.id.div){
            if(str1 == null || str1.length()==0) {
                Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            }
            else {
                inpnum1 = Integer.parseInt(str1);
                input.setText("");
                if (last_equal) {
                    ans = inpnum1;
                }else {
                    ans /= inpnum1;
                }
                hint_text.setText("" + ans);
                flag = 4;
            }
        }
        else if (id == R.id.equal){
            String str2 = input.getText().toString();
            if(str2 == null || str2.length()==0) {
                Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            }
            else {
                int inpnum2 = Integer.parseInt(str2);
                if (flag == 1) {
                    ans = ans + inpnum2;
                } else if (flag == 2) {
                    ans = ans - inpnum2;
                } else if (flag == 3) {
                    ans = ans * inpnum2;
                } else if (flag == 4) {
                    ans = ans / inpnum2;
                } else if (flag == 5) {
                    ans = ans % inpnum2;
                } else {
                    Toast.makeText(this, "Wrong Entry, Flag :" + flag, Toast.LENGTH_SHORT).show();
                }
                String finalans = Integer.toString(ans);
                input.setText(finalans);
                hint_text.setText(""+finalans);
                last_equal = true;
                islast = true;
            }
        }
        else if (id == R.id.mod){
            if(str1 == null || str1.length()==0) {
                Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            }
            else {
                if (last_equal) {

                } else {
                    inpnum1 = Integer.parseInt(str1);
                    input.setText("");
                    ans %= inpnum1;
                    hint_text.setText("" + ans);
                    flag = 5;
                }
            }
        }
        else if(id == R.id.del){
            if(str1 == null || str1.length()==0){
                Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            }
            else {
                inpnum1 = Integer.parseInt(str1);
                inpnum1 = inpnum1/10;
                input.setText(inpnum1+"");
                hint_text.setText(""+inpnum1);
            }
        }
        else if (id == R.id.clear){
            input.setText("");
            ans = 0;
            hint_text.setText("");
        }
        else if (id == R.id.plus_minus){
            if(str1 == null || str1.length()==0) {
                Toast.makeText(this, "Enter a number first", Toast.LENGTH_SHORT).show();
            }
            else {
                String str2 = input.getText().toString();
                int inpnum2 = Integer.parseInt(str2);
                inpnum2 = -inpnum2;
                ans = -inpnum2;
                String rev = Integer.toString(inpnum2);
                input.setText(rev);
                hint_text.setText("" + rev);
            }
        }
        else if (id == R.id.zero){
            checkLastEqual();
            numset = 0;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.one){
            checkLastEqual();
            numset = 1;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.two){
            checkLastEqual();
            numset = 2;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.three){
            checkLastEqual();
            numset = 3;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.four){
            checkLastEqual();
            numset = 4;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.five){
            checkLastEqual();
            numset = 5;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.six){
            checkLastEqual();
            numset = 6;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.seven){
            checkLastEqual();
            numset = 7;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.eight){
            checkLastEqual();
            numset = 8;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
        else if (id == R.id.nine){
            checkLastEqual();
            numset = 9;
            stringset = Integer.toString(numset);
            input.append(stringset);
        }
    }

    private void checkLastEqual() {
        if(islast){
            ans = 0;
            hint_text.setText("");
            input.setText("");
            islast = false;
        }
    }
}