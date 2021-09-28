package kr.ac.kpu.ce2018152010.corona_kpu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton registerRoute, btnCall, btnCheck, btnNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerRoute = (ImageButton)findViewById(R.id.btnRegisterRoute);
        btnCall = (ImageButton)findViewById(R.id.btnCall);
        btnCheck = (ImageButton)findViewById(R.id.btnCheck);
        btnNotice = (ImageButton)findViewById(R.id.btnNotice);

        btnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 버튼 클릭 시 홈페이지를 띄움
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("http://www.kpu.ac.kr/front/boardlist.do?currentPage=&" +
                                "menuGubun=1&siteGubun=1&bbsConfigFK=357&searchField=D.TITLE&searchValue=%C8%AE%C1%F8"));
                startActivity(mIntent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AnsimCall.class);
                startActivity(intent);
            }
        });

        registerRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterRoute.class);
                startActivity(intent);
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent radiointent = new Intent(getApplicationContext(), radioActivity.class);
                startActivity(radiointent);
            }
        });
    }
}