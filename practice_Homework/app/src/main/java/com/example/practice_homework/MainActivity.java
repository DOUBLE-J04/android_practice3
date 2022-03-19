package com.example.practice_homework;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //각 아이디로 부터 값을 가져와서 변숭에 할당
    Button button1;
    Button button2;
    RadioButton radio_button1;
    RadioButton radio_button2;
    EditText editText1 ;
    Intent intent;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar에 사진 추가
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
        ab.setIcon(R.drawable.my);

        //변수 - id 매칭
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        radio_button1=(RadioButton)findViewById(R.id.radio_button1);
        radio_button2=(RadioButton)findViewById(R.id.radio_button2);
        editText1 = (EditText)findViewById(R.id.EditText1);
        imageView = (ImageView)findViewById(R.id.imageView);
    }
    public void onClick(View view)
    {
        switch (view.getId()){
            case R.id.button1:
                //edit text 부분에 있는 값을 가져오려면 클래스변수에 gettext를 이용해서 가져온다
                Toast.makeText(getApplicationContext(),editText1.getText(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                String middle_url = editText1.getText().toString();
                String url = "https://"+middle_url;
                //   http:// 부분이 반드시들어가야 연결이 되었다.
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                //인텐트를 사용해서 안드로이드 커뮤니케이션을 한바 뷰, 서비스 컴포넌트 호출 메시지 전달 (url)정보를 전달
                startActivity(intent);
               break;
            case R.id.radio_button1:
                imageView.setImageResource(R.drawable.my);
                break;

            case R.id.radio_button2:
                imageView.setImageResource(R.drawable.work);
                break;
        }
    }
}