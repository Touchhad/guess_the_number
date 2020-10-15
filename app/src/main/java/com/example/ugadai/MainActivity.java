package com.example.ugadai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int guess;
    boolean gameFinished;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//задаем переменные
        tvInfo = (TextView) findViewById(R.id.textView2);
        etInput = (EditText) findViewById(R.id.editText);
        bControl = (Button) findViewById(R.id.button2);
//Задает разброс рандома
        guess = (int) (Math.random() * 100);
        gameFinished = false;

    }

// событе при нажатии
    public void OnClick(View v){
        //не позволяет закончиться игре
        if (!gameFinished){
            int inp=Integer.parseInt(etInput.getText().toString());
            //условие которое показывает перелет
            if (inp > guess)
                tvInfo.setText(getResources().getString(R.string.ahead));
            //условие которое показывает недолет
            if (inp < guess)
                tvInfo.setText(getResources().getString(R.string.behind));
            //условие которое показывает что попали в точку
            if (inp == guess)
            {
                //показывает что мы угадали с числом
                tvInfo.setText(getResources().getString(R.string.hit));
                //дает сыграть еще
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        }
        else
           //занов запускает игра при нажатии "сыграть еще"
        {
            // задает новый разброс
            guess = (int)(Math.random()*200);
            //обновляет значение кнопки
            bControl.setText(getResources().getString(R.string.input_value));
            //берет из strings начение input_value там условие нового уровня
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");
    }
}


