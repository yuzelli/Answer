package com.example.yuzelli.answer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    TextView tv_begin;
    TextView tv_content;
    ListView lv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_begin = (TextView) findViewById(R.id.tv_begin);
        tv_content = (TextView) findViewById(R.id.tv_content);
        lv_list = (ListView) findViewById(R.id.lv_list);
        tv_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                startActivityForResult(intent, 1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 1002) {
            if (data == null) {
                tv_content.setVisibility(View.GONE);
                return;
            }
            tv_content.setVisibility(View.VISIBLE);
            ArrayList<DataAnswer> list = data.getParcelableArrayListExtra("result");
            int trueNum = 0;
            int falseNum = 0;
            int noNum = 0;
            for (DataAnswer dataAnswer : list) {
                if (dataAnswer.getIs_select_postion() == dataAnswer.getIs_ture()) {
                    trueNum++;
                } else if (dataAnswer.getIs_select_postion() != 0) {
                    falseNum++;
                }else {
                    noNum++;
                }
            }
            tv_content.setText("本轮答题成绩：\n"
                    + "正确：" +trueNum  + "道\n"
                    + "错误：" + falseNum  + "道\n"
                    + "未答：" +noNum  + "道\n"
                    + "成绩：" +trueNum * 10  + "分");

            lv_list.setAdapter(new CommonAdapter<DataAnswer>(MainActivity.this,list,R.layout.item) {
                @Override
                public void convert(ViewHolder helper, DataAnswer item, int position) {
                        helper.setText(R.id.tv_item,Utils.getContent(item,position));
                }
            });
        }else {
            tv_content.setVisibility(View.GONE);
        }
    }
}
