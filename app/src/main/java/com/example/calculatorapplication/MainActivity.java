package com.example.calculatorapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int MULTIPLY = 3;
    public static final int DIVISION =4;
    public static final int RESET = -1;

    int selectType = RESET;

    int a;
    boolean isSelectedType = false;
    boolean isMemoried = false;


    TextView tvTextView;
    Button btnPlus, btnMinus, btnMultiply, btnDivision, btnOnOff, btn7, btn8, btn9, btn4, btn5, btn6, btn1, btn2, btn3, btn0, btnEquals;
    ImageView ivDelete;


    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTextView = findViewById(R.id.tvTextView);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivision = findViewById(R.id.btnDivision);
        btnOnOff = findViewById(R.id.btnReset);
        btnEquals = findViewById(R.id.btnEquals);
        ivDelete = findViewById(R.id.ivDelete);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnOnOff.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        ivDelete.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPlus:
                onPlus();
                break;
            case R.id.btnMinus:
                onMinus();
                break;
            case R.id.btnMultiply:
                onMultiply();
                break;
            case R.id.btnDivision:
                onDivision();
                break;
            case R.id.btnReset:
                onReset();
                break;
            case R.id.btnEquals:
                onEquals();
                break;
            case R.id.ivDelete:
                onDelete();
                break;
            case R.id.btn0:
                onEnterNumb(0);
                break;
            case R.id.btn1:
                onEnterNumb(1);
                break;
            case R.id.btn2:
                onEnterNumb(2);
                break;
            case R.id.btn3:
                onEnterNumb(3);
                break;
            case R.id.btn4:
                onEnterNumb(4);
                break;
            case R.id.btn5:
                onEnterNumb(5);
                break;
            case R.id.btn6:
                onEnterNumb(6);
                break;
            case R.id.btn7:
                onEnterNumb(7);
                break;
            case R.id.btn8:
                onEnterNumb(8);
                break;
            case R.id.btn9:
                onEnterNumb(9);
                break;
        }
    }

    private void onPlus() {
        try {
            selectType = PLUS;
            isSelectedType = true;
            if (isMemoried) {
                onEquals();
            }
        } catch (Exception e) {
            onException(e);
        }
    }

    private void onMinus() {
        try {
            selectType = MINUS;
            isSelectedType = true;
            if (isMemoried) {
                onEquals();
            }
        } catch (Exception e) {
            onException(e);
        }
    }

    private void onMultiply() {
        try {
            selectType = MULTIPLY;
            isSelectedType = true;
            if (isMemoried) {
                onEquals();
            }
        } catch (Exception e) {
            onException (e);
        }
    }

    private void onDivision() {
        try {
            selectType = DIVISION;
            isSelectedType = true;
            if (isMemoried) {
                onEquals();
            }
        } catch (Exception e) {
            onException (e);
        }
    }

    private void onReset() {
        selectType = RESET;
        isSelectedType = false;
        isMemoried = false;
        a = 0;
        tvTextView.setText("");
    }

    private void onEquals() {
        switch (selectType) {
            case PLUS:
                int b = convertStringToInt();
                int resultPlus = a + b;
                onResult(resultPlus);
                break;
            case MINUS:
                int c = convertStringToInt();
                int resultMinus = a - c;
                onResult(resultMinus);
                break;
            case MULTIPLY:
                int d = convertStringToInt();
                int resultMultiply = a * d;
                onResult(resultMultiply);
                break;
            case DIVISION:
                int e = convertStringToInt();
                int resultDivision = a / e;
                onResult(resultDivision);
                break;
        }
    }

    private void onDelete() {
        try {
            if (tvTextView.length() > 0) {
                String result = removeLastChar(tvTextView.getText().toString());
                tvTextView.setText(result);
            }
        } catch (Exception e) {
            onException (e);
        }
    }

    private void onEnterNumb(int numb) {
        try {
            if (selectType == RESET) {
                tvTextView.append(String.valueOf(numb));
            } else if (selectType == PLUS || selectType == MINUS || selectType == MULTIPLY || selectType == DIVISION) {
                if (isSelectedType) {
                    a = Integer.parseInt(tvTextView.getText().toString());
                    tvTextView.setText(String.valueOf(numb));
                    isSelectedType = false;
                    isMemoried = true;
                } else {
                    tvTextView.append(String.valueOf(numb));
                }
            }
        } catch (Exception e) {
            onException (e);

        }
    }

    private void onResult(int result) {
        tvTextView.setText(String.valueOf(result));
        isMemoried = false;
        a = 0;
    }

    private int convertStringToInt() {
        String text = tvTextView.getText().toString();
        return Integer.parseInt(text);
    }

    private void onException(Exception e) {
        Toast.makeText(this, "Ошибка: " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private String removeLastChar(String text) {
        return text.substring(0, text.length() -1);
    }


}