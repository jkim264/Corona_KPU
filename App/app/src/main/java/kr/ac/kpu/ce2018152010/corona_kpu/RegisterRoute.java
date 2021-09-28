package kr.ac.kpu.ce2018152010.corona_kpu;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class RegisterRoute extends AppCompatActivity {
    Button registerBtn, editBtn, btnBack; //동선 등록 버튼, 수정하기 버튼, 돌아가기 버튼
    View registerDialogView, routeView; //동선 등록창, 저장된 파일 내용을 출력하는 창
    CalendarView calView; //달력을 띄우기 위한 뷰
    EditText edtPlace, edtTime, edtDay; //동선 등록창의 장소, 시간, 날짜
    EditText viewRoute; //등록된 목록
    int selectYear, selectMonth, selectDay; //선택한 날짜
    int selectHour, selectMinuate; //선택한 시간, 분
    String fname; //파일이름

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        setTitle("동선 등록");

        registerBtn = (Button)findViewById(R.id.registerPlace); //동선 등록 버튼
        calView = (CalendarView)findViewById(R.id.calendarView1); //CalendarView 등록
        btnBack = (Button)findViewById(R.id.btnBack); //돌아가기 버튼 등록

        Date mDate = Calendar.getInstance().getTime(); //default 현재 시간 가져오기
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd"); //데이터 형식 맞춤
        String getTime = simpleDate.format(mDate); //String getTime은 현재 시간
        fname = getTime; //기본으로 현재 날짜로 설정

        //처음은 현재 시간을 선택한 상태로 초기화
        selectYear = Integer.parseInt(getTime.substring(0, 4));
        selectMonth = Integer.parseInt(getTime.substring(5, 7));
        selectDay = Integer.parseInt(getTime.substring(8, 10));

        // 돌아가는 버튼
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //날짜를 클릭했을 떄 일어나는 이벤트 - 등록한 내용 열람
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //선택한 날짜로 초기화
                selectYear = year;
                selectMonth = month +1;
                selectDay = dayOfMonth;

                //fname 재설정
                fname = Integer.toString(selectYear) + "." + Integer.toString(selectMonth) + "." + Integer.toString(selectDay)+".txt";
                //기록한 내용을 보여주는 새로운 dialog 읽어옴
                routeView = (View) View.inflate(RegisterRoute.this, R.layout.view_route, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(RegisterRoute.this);
                dlg.setTitle("목록 보기");
                dlg.setView(routeView);
                viewRoute = routeView.findViewById(R.id.viewRoute); //viewRoute 뷰를 등록
                editBtn = (Button)routeView.findViewById(R.id.editButton); //수정하기 버튼

                String str = readRoute(fname);
                viewRoute.setText(str); //저장된 파일 내용 EditText를 통해 보여줌

                editBtn.setOnClickListener(new View.OnClickListener()
                //수정하기 버튼을 눌렀을 때
                {
                    @Override
                    public void onClick(View view) {
                        try {
                            FileOutputStream outFs = openFileOutput(fname, Context.MODE_PRIVATE); //새롭게 저장
                            String str = viewRoute.getText().toString();
                            outFs.write(str.getBytes());
                            outFs.close();
                            Toast.makeText(getApplicationContext(), fname + "이 수정됨", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {

                        }
                    }
                });
                dlg.show();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener()
        //처음에 등록하기 버튼을 눌렀을 때
        {
            @Override
            public void onClick(View v) {
                registerDialogView = (View) View.inflate(RegisterRoute.this, R.layout.register_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(RegisterRoute.this);
                dlg.setTitle("장소 등록");
                dlg.setView(registerDialogView);

                edtDay = (EditText)registerDialogView.findViewById(R.id.edtDay); //날짜 입력
                edtPlace = (EditText)registerDialogView.findViewById(R.id.edtPlace); //장소 입력
                edtTime = (EditText)registerDialogView.findViewById(R.id.edtTime); //시간 입력

                //날짜는 수정할 수 있으나, 기본적으로 선택한 날짜에 맞추어 출력
                edtDay.setText(Integer.toString(selectYear)+"."+Integer.toString(selectMonth)+"."+Integer.toString(selectDay));
                edtTime.setOnClickListener(new View.OnClickListener()
                //시간 입력을 하기 위해 눌렀을 때, TimePicker가 나오도록 함
                {
                    @Override
                    public void onClick(View view) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(RegisterRoute.this, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                edtTime.setText(Integer.toString(i)+"시"+Integer.toString(i1)+"분");
                            }
                        }, selectHour, selectMinuate, false);
                        timePickerDialog.show();
                    }
                });

                //내용을 등록하는 부분
                dlg.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        FileInputStream fis = null;
                        try {
                            fname = edtDay.getText().toString() + ".txt";
                            FileOutputStream outFs = openFileOutput(fname, Context.MODE_APPEND); //기존 파일이 있을경우 이어서 작성후, 저장

                            String str = "\n날짜 :" +edtDay.getText().toString() +"\n시간 :" + edtTime.getText().toString() +"\n장소 :" + edtPlace.getText().toString() +"\n\n";
                            outFs.write(str.getBytes());
                            outFs.close();
                            Toast.makeText(getApplicationContext(), fname + "이 저장됨", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {

                        }

                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
    }
    //파일 내용을 읽어주는 함수
    String readRoute(String fname) {
        String routeStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fname);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            routeStr = (new String(txt)).trim();
        } catch(IOException e) {

        }
        return routeStr;
    }

}
