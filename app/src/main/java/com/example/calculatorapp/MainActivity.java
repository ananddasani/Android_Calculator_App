package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView input_text, output_text;

    private String input, output, newOutput;

    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonMultiply, buttonSubtract, buttonDivision, buttonPoint, buttonPower, buttonClear, buttonPercent, buttonEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding all the id's of button and textview
        input_text = findViewById(R.id.input_text);
        output_text = findViewById(R.id.output_text);

        button0 = findViewById(R.id.zero_button);
        button1 = findViewById(R.id.one_button);
        button2 = findViewById(R.id.two_button);
        button3 = findViewById(R.id.three_button);
        button4 = findViewById(R.id.four_button);
        button5 = findViewById(R.id.five_button);
        button6 = findViewById(R.id.six_button);
        button7 = findViewById(R.id.seven_button);
        button8 = findViewById(R.id.eight_button);
        button9 = findViewById(R.id.nine_button);

        buttonPoint = findViewById(R.id.dot_button);
        buttonEqual = findViewById(R.id.equal_button);
        buttonClear = findViewById(R.id.clear_button);

        buttonAdd = findViewById(R.id.add_button);
        buttonMultiply = findViewById(R.id.multiply_button);
        buttonSubtract = findViewById(R.id.subtract_button);
        buttonDivision = findViewById(R.id.divide_button);
        buttonPercent = findViewById(R.id.percent_button);
        buttonPower = findViewById(R.id.power_button);
    }

    public void onButtonClicked(View view) {

        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {
            case "C":
                input = null;
                output = null;
                output_text.setText("");
                ;
                break;

            case "^":
                input += "^";
                solve();
                break;

            case "X":
                input += "X";
                solve();
                break;

            case "=":
                solve();
                break;

            case "%":
                input += "%";
                double d = Double.parseDouble(input_text.getText().toString()) / 100;
                output_text.setText(String.valueOf(d));
                solve();
                break;

            default:
                if (input == null)
                    input = "";

                if (data.equals("+") || data.equals("-") || data.equals("/"))
                    solve();

                input += data;
        }
        input_text.setText(input);
    }

    public void solve() {

        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                output_text.setText(newOutput);
            } catch (Exception e) {
                output_text.setText(e.getMessage().toString());
            }
        }
    }

    private String cutDecimal(String number) {
        String n[] = number.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                number = n[0];
            }
        }
        return number;
    }
}