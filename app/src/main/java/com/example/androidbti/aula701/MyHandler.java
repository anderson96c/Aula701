package com.example.androidbti.aula701;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class MyHandler extends Handler {

    private TextView textView;
    private Button button;

    public  MyHandler(TextView textView, Button button){
        this.button = button;
        this.textView = textView;
    }

    @Override
    public void handleMessage(Message msg) {
        if(msg.what == 100){
            textView.setText("Processamento finalizado");
            button.setEnabled(true);
        }
    }
}
