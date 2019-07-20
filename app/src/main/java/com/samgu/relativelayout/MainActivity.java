package com.samgu.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtComPlay, txtResult;
    Button btnScissors, btnStone, btnPaper, btnMax, btnSave, btnDisplay, btnClear;
    int count = 0, win = 0, lose = 0, draw = 0; //初始化 局數 贏 輸 平手,

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
        btnClear = findViewById(R.id.btnClear);

        btnScissors.setOnClickListener(ScissorsLin);
        btnStone.setOnClickListener(StoneLin);
        btnPaper.setOnClickListener(PaperLin);
        btnSave.setOnClickListener(SaveLin);
        btnDisplay.setOnClickListener(DisplayLin);
        btnClear.setOnClickListener(ClearLin);
        btnMax.setOnClickListener(MaxLin);
    }

    private Button.OnClickListener MaxLin = new Button.OnClickListener() {
        public void onClick(View view) {
            SharedPreferences gameResult = getSharedPreferences("game", 0);
            int max = gameResult.getInt("Win", 0); //(存檔裡的)得到Win的值 初始值為0
            if (win >= max) //如果贏數 >= 最高分
                max = win; //那最高分就= 贏數
            //Toast.makeText(getApplicationContext(), max, Toast.LENGTH_SHORT).show();
            txtResult.setText("最高分為:" + max + "分");
        }
    };

    private Button.OnClickListener ClearLin = new Button.OnClickListener() {
        public void onClick(View view) {
            SharedPreferences gameResult = getSharedPreferences("gmae", 0);
            gameResult.edit().remove("Win").commit(); //清除
//gameReslut.edit().remove("Win").commit(); 可以移除""某個key

        }
    };


    private Button.OnClickListener DisplayLin = new Button.OnClickListener() {
        public void onClick(View view) {
            StringBuilder sb = new StringBuilder();

            float b = (float) win / count * 100;
            //勝率 浮點數
            sb.append("局數:" + count + "\n");
            sb.append("贏:" + win + "\n");
            sb.append("輸:" + lose + "\n");
            sb.append("平手:" + draw + "\n");
            sb.append("勝率為:" + String.valueOf(b) + "%");  // float b 浮點數轉字串 > Stirng.valueOf()


            Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
            txtResult.setText(sb.toString());
        }
    };


    private Button.OnClickListener SaveLin = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences gameResult = getSharedPreferences("game", 0);
            //String "檔名" ,mode 0 只能供讀 1可給別人讀取但是需要知道位置 2可讀寫給別人但需要知道位置
            //SharedPreferences 存取偏好檔案的內容，該檔案儲存在內部儲存體中
            gameResult.edit()//編輯  <-return this回傳物件本身 故能可以直接接下去寫方法
                    .putInt("Count", count)
                    .putInt("Win", win)
                    .putInt("Lose", lose)
                    .putInt("Draw", draw)
                    .apply();//提交
            Toast.makeText(getApplicationContext(), "存檔成功", Toast.LENGTH_SHORT).show();
        }
    };


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
