package kr.ac.kpu.ce2018152010.corona_kpu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class radioActivity extends AppCompatActivity {

    Button btnBack, btnGetResult, findHos;
    TextView resultTxt;

    CheckBox dis1_1,dis1_2,dis1_3,dis2_1,dis2_2,dis2_3,dis2_4;

    Integer weight;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio);


        
        
        btnGetResult = (Button)findViewById(R.id.btnGetMap);    // 진단 확인하기
        btnBack =(Button)findViewById(R.id.btnBack);            // 뒤로 돌아가기
        findHos = (Button)findViewById(R.id.findHos);           // 주변 보건소 찾기 버튼

        resultTxt = (TextView)findViewById(R.id.resultTxt); //약한 증상
        dis1_1 = (CheckBox)findViewById(R.id.dis1_1);
        dis1_2 = (CheckBox)findViewById(R.id.dis1_2);
        dis1_3 = (CheckBox)findViewById(R.id.dis1_3);
        dis2_1 = (CheckBox)findViewById(R.id.dis2_1);   // 심한 증상
        dis2_2 = (CheckBox)findViewById(R.id.dis2_2);
        dis2_3 = (CheckBox)findViewById(R.id.dis2_3);
        dis2_4 = (CheckBox)findViewById(R.id.dis2_4);

        weight = 0;             // 질병 위험도 가중치 -> 이것을 기준으로 자가진단 4점 넘으면 코로나 의심환자
    
        //약한 증상은 +1점
        dis1_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked==true){
                    weight += 1;
                }
                else weight -=1;
            }
        });

        dis1_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked==true){
                    weight += 1;
                }
                else weight -=1;
            }
        });

        dis1_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked==true){
                    weight += 1;
                }
                else weight -=1;
            }
        });
        
        //심한 증상은 +2점
        dis2_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked==true){
                    weight += 2;
                }
                else weight -=2;
            }
        });

        dis2_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked==true){
                    weight += 2;
                }
                else weight -=2;
            }
        });

        dis2_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked==true){
                    weight += 2;
                }
                else weight -=2;
            }
        });

        dis2_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked==true){
                    weight += 2;
                }
                else weight -=2;
            }
        });


        /* 자가 진단 클릭하면 주위 보건소 띄우는 버튼입니다
         각 체크버튼에 가중치를 줘서 일정 점수 (4점) 을 넘으면 텍스트를 띄움과 동시에
        보건소를 찾는 버튼을 띄워주는 형식
        */
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(weight <4)
                {
                    resultTxt.setVisibility(View.VISIBLE);
                    resultTxt.setText("위험 점수는 "+weight.toString()+"점 입니다.\n" +
                            "경과를 더 지켜봅시다.");
                }
                else{
                    resultTxt.setVisibility(View.VISIBLE);
                    findHos.setVisibility(View.VISIBLE);
                    resultTxt.setText("위험 점수는 "+weight.toString()+"점 입니다.\n" +
                            "코로나가 의심됩니다.\n주변 보건소를 찾아보세요.");
                }

            }
        });




        // 주위 보건소를 찾는 버튼
        findHos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(getApplicationContext(), kr.ac.kpu.ce2018152010.corona_kpu.mapActivity.class);

                startActivity(mapIntent);
            }
        });

        // 돌아가는 버튼
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}


