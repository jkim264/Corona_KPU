package kr.ac.kpu.ce2018152010.corona_kpu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class mapActivity extends AppCompatActivity {

    Button btnGetBack;
    ImageView img1shihwa, img2bogun, img3cent, img4jung, img5shinchun;
    /*TextView txtTelshihwa,txtTelsiheung,txtTeljungwang, txtTelcentral, txtTelsinchun
            , txtLocshihwa, txtLocsiheung, txtLocjungwang, txtLocCentral,txtLocsinchun;*/
    // Tel은 전화번호, 누르면 전화 액티비티 Loc은 위치 액티비티 (네이버 지도 URL로 연결)

    TextView[] telArr = new TextView[5];
    Integer[] telID = {R.id.txtTelshihwa, R.id.txtTelsiheung, R.id.txtTelsinchun,
            R.id.txtTelcentral, R.id.txtTeljungwang};

    String[] telNum = {"1811-7000", "031-310-5815", "031-310-6300", "1588-9339", "031-310-5901"};
    //시화, 시흥, 신천, 센트럴 , 정왕 전화번호

    TextView[] locateArr = new TextView[5];
    Integer[] locateID = {R.id.txtFindshihwa, R.id.txtFindsiheung, R.id.txtFindsinchun,
            R.id.txtFindcentral, R.id.txtFindjungwang};

    String[] locateUrl = {"https://m.map.naver.com/search2/search.naver?query=%EC%8B%9C%ED%99%94%EB%B3%91%EC%9B%90&siteLocation=&queryRank=&type=#/map/1/1094488604",
            "https://m.map.naver.com/search2/search.naver?query=%EC%8B%9C%ED%9D%A5%EC%8B%9C%20%EB%B3%B4%EA%B1%B4%EC%86%8C&siteLocation=&queryRank=&type=#/map/1/11668023",
            "https://m.map.naver.com/search2/search.naver?query=%EC%8B%A0%EC%B2%9C%EC%97%B0%ED%95%A9%EB%B3%91%EC%9B%90&siteLocation=&queryRank=&type=#/map/1/11618185",
            "https://m.map.naver.com/search2/search.naver?query=%EC%84%9D%EA%B2%BD%20%EC%9D%98%EB%A3%8C%EC%9E%AC%EB%8B%A8%20%EC%84%BC%ED%8A%B8%EB%9F%B4%20%EB%B3%91%EC%9B%90&siteLocation=&queryRank=&type=#/map/1/12809336",
            "https://m.map.naver.com/search2/search.naver?query=%EC%8B%9C%ED%9D%A5%EC%8B%9C%20%EB%B3%B4%EA%B1%B4%EC%86%8C&siteLocation=&queryRank=&type=#/map/1/19523405"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bowgunsaw);

        btnGetBack = (Button) findViewById(R.id.btnGetBacktoRadio);

        for (int i = 0; i < telArr.length; i++) {
            telArr[i] = (TextView) findViewById(telID[i]);
        }                                                   // 전화번호 텍스트 버튼 선언

        for (int i = 0; i < telArr.length; i++)                  // 전화 번호 텍스트버튼 클릭 이벤트 설정
        {
            final int index;
            index = i;

            telArr[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent phoneIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/" + telNum[index]));
                    startActivity(phoneIntent);
                }
            });
        }


        for (int i = 0; i < locateArr.length; i++)               // 위치 보기 버튼 선언
        {
            locateArr[i] = (TextView) findViewById(locateID[i]);
        }


        for (int i = 0; i < locateArr.length; i++) {
            final int indexLoc;
            indexLoc = i;

            locateArr[indexLoc].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse(locateUrl[indexLoc]);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        }


        //자가진단 탭으로 넘어가는 버튼입니다. (뒤로가기)
        btnGetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
