package kr.ac.kpu.ce2018152010.corona_kpu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AnsimCall extends AppCompatActivity {
    Button Olive_Green, SinBul, Juicy, Paris, TIP_Food, Ucua, Hans_Deli, Zoo_Coffee, Tomato, Nadri, Moms_Touch, KPU_Restaurant;
    Button btnBack; //돌아가기 버튼
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ansimcall);

        //올리브그린 안심콜
        Olive_Green = (Button) findViewById(R.id.Olive_Green);
        Olive_Green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802308747"));
                startActivity(mIntent);
            }
        });
        //신불떡볶이 안심콜
        SinBul = (Button) findViewById(R.id.SinBul);
        SinBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802301046"));
                startActivity(mIntent);
            }
        });
        //쥬씨 안심콜
        Juicy = (Button) findViewById(R.id.Juicy);
        Juicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802301047"));
                startActivity(mIntent);
            }
        });
        //파리바게트 안심콜
        Paris = (Button) findViewById(R.id.Paris);
        Paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802301048"));
                startActivity(mIntent);
            }
        });
        //팁푸드라운지 안심콜
        TIP_Food = (Button) findViewById(R.id.TIP_Food);
        TIP_Food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802308743"));
                startActivity(mIntent);
            }
        });
        //우쿠야 안심콜
        Ucua = (Button) findViewById(R.id.Ucua);
        Ucua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802308754"));
                startActivity(mIntent);
            }
        });
        //한스델리 안심콜
        Hans_Deli = (Button) findViewById(R.id.Hans_Deli);
        Hans_Deli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802308750"));
                startActivity(mIntent);
            }
        });
        //zoo커피 안심콜
        Zoo_Coffee = (Button) findViewById(R.id.Zoo_Coffee);
        Zoo_Coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802308748"));
                startActivity(mIntent);
            }
        });
        //토마토도시락 안심콜
        Tomato = (Button) findViewById(R.id.Tomato);
        Tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802300576"));
                startActivity(mIntent);
            }
        });
        //나드리김밥 안심콜
        Nadri = (Button) findViewById(R.id.Nadri);
        Nadri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802300058"));
                startActivity(mIntent);
            }
        });
        //맘스터치 안심콜
        Moms_Touch = (Button) findViewById(R.id.Moms_touch);
        Moms_Touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802300514"));
                startActivity(mIntent);
            }
        });
        //KPU 레스토랑 안심콜
        KPU_Restaurant = (Button) findViewById(R.id.KPU_Restaurant);
        KPU_Restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/0802300591"));
                startActivity(mIntent);
            }
        });
        btnBack = (Button)findViewById(R.id.btnBack); //돌아가기 버튼 등록
        // 돌아가는 버튼
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
