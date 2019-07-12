package com.samgu.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtComPlay, txtResult;
    Button btnScissors, btnStone, btnPaper, btnMax, btnSave, btnDisplay;
    int count = 0, win = 0, lose = 0, draw = 0; //初始化 局數 贏 輸 平手

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        txtComPlay = findViewById(R.id.txtComPlay);
        txtResult = findViewById(R.id.txtResult);
        btnScissors = findViewById(R.id.btnScissors);
        btnStone = findViewById(R.id.btnStone);
        btnPaper = findViewById(R.id.btnPaper);
        btnMax = findViewById(R.id.btnMax);
        btnSave = findViewById(R.id.btnSave);
        btnDisplay = findViewById(R.id.btnDisplay);

        btnScissors.setOnClickListener(ScissorsLin);
        btnStone.setOnClickListener(StoneLin);
        btnPaper.setOnClickListener(PaperLin);
    }

    private Button.OnClickListener ScissorsLin = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            count++;
            int iComplay = (int) (Math.random() * 3 + 1);
            if (iComplay == 1) //1剪刀 2石頭 3布
            {
                draw++;
                txtComPlay.setText("剪刀");
                txtResult.setText("結果:平手");
            } else if (iComplay == 2) {
                lose++;
                txtComPlay.setText("石頭");
                txtResult.setText("結果:輸");
            } else {
                win++;
                txtComPlay.setText("布");
                txtResult.setText("結果:贏");

            }
        }
    };

    private Button.OnClickListener StoneLin = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            count++;
            int iComplay = (int) (Math.random() * 3 + 1);
            if (iComplay == 1) //1剪刀 2石頭 3布
            {
                win++;
                txtComPlay.setText("剪刀");
                txtResult.setText("結果:贏");
            } else if (iComplay == 2) {
                draw++;
                txtComPlay.setText("石頭");
                txtResult.setText("結果:平手");
            } else {
                lose++;
                txtComPlay.setText("布");
                txtResult.setText("結果:輸");

            }
        }
    };

    private Button.OnClickListener PaperLin = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            count++;
            int iComplay = (int) (Math.random() * 3 + 1);
            if (iComplay == 1) //1剪刀 2石頭 3布
            {
                lose++;
                txtComPlay.setText("剪刀");
                txtResult.setText("結果:輸");
            } else if (iComplay == 2) {
                win++;
                txtComPlay.setText("石頭");
                txtResult.setText("結果:贏");
            } else {
                draw++;
                txtComPlay.setText("布");
                txtResult.setText("結果:平手");
            }
        }
    };
}
