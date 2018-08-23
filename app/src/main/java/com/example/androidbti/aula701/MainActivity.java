package com.example.androidbti.aula701;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;
    private Button btnProcessar;
    //    private Handler handler = new Handler();
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_status);
        btnProcessar = findViewById(R.id.btn_processar);

        myHandler = new MyHandler(textView, btnProcessar);
    }

    public void processar(View view) {
        textView.setText("Processando...");
        btnProcessar.setEnabled(false);
        executarAlgoDemorado();

    }

    private void executarAlgoDemorado() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(10000);

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("Processamento finalizado");
//                        btnProcessar.setEnabled(true);
//                    }
//                })
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("Processamento finalizado");
//                        btnProcessar.setEnabled(true);
//                    }
//                });
//            }

                Message msg = Message.obtain();
                msg.what = 100;
                myHandler.sendMessage(msg);

            }

        }).start();
    }
}
