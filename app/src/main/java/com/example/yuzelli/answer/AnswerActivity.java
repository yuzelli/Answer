package com.example.yuzelli.answer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AnswerActivity extends Activity implements View.OnClickListener {
    ImageView imgBack;
    TextView tv_title;
    TextView tv_content;
    TextView tv_next;
    TextView tv_last;
    RadioButton rb_a;
    RadioButton rb_b;
    RadioButton rb_c;
    RadioButton rb_d;
    RadioGroup rg_select_answer;

    private ArrayList<DataAnswer> dataList = new ArrayList<>();
    private int selectPostion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        initData();
        initView();
        setData();
    }


    private void initView() {
        imgBack = (ImageView) this.findViewById(R.id.img_back);
        tv_title = (TextView) this.findViewById(R.id.tv_title);
        tv_content = (TextView) this.findViewById(R.id.tv_content);
        tv_last = (TextView) this.findViewById(R.id.tv_last);
        tv_next = (TextView) this.findViewById(R.id.tv_next);
        rg_select_answer = (RadioGroup) this.findViewById(R.id.rg_select_answer);
        rb_a = (RadioButton) this.findViewById(R.id.rb_a);
        rb_b = (RadioButton) this.findViewById(R.id.rb_b);
        rb_c = (RadioButton) this.findViewById(R.id.rb_c);
        rb_d = (RadioButton) this.findViewById(R.id.rb_d);
        tv_last.setOnClickListener(this);
        tv_next.setOnClickListener(this);
        imgBack.setOnClickListener(this);
    }


    private void initData() {
        dataList.add(new DataAnswer("在沧海桑田的宏伟历史变迁中。盐阜先民们在古老的盐阜平原上创造出灿烂的文明。在今天东台溱东、阜宁板湖等地都曾发现过六七千年前新石器时代人类生活的遗迹。并出土了一批磨制石器和玉器等。盐阜先民的新石器时代约相当于",
                "元谋人时期", "北京人时期", "河姆渡时期", "尧舜禹时期", 3));
        dataList.add(new DataAnswer("2013年9月习近平主席在哈萨克斯坦纳扎尔巴耶夫大学发表演讲，提出了共建“丝绸之路经济带”的战略构想，关于丝绸之路说法正确的是",
                "最初开通于唐朝 ", "起点在洛阳", "中转站是大秦", "张骞是功臣", 4));
        dataList.add(new DataAnswer("中国古代各族人民为维护祖国统一作出了不可磨灭的贡献。下列军事斗争得到维吾尔族人民大力支持的是",
                "戚继光抗倭 ", "郑成功收复台湾", "雅克萨之战", "平定大小和卓叛乱", 4));
        dataList.add(new DataAnswer("史学家陈旭麓认为鸦片战争是中国历史的一块界碑。这是因为，鸦片战争",
                "揭开了中国近代史的序幕", "激化了中国社会的矛盾", "使中国完全沦为半殖民地半封建社会", "标志着新民主主义革命的开端", 1));

        dataList.add(new DataAnswer("1915年陈独秀在《敬告青年》一文中倡导“自主、进步务实、开放、富于进取和科学精神”。这篇文章发表在",
                "洋务运动期间", "戊戌变法期间", "新文化运动期间", "五四运动期间", 3));
        dataList.add(new DataAnswer("被鲁迅称为“19世纪最敏感的人”的严复在其译著《天演论》中提出了“物竞天择，适者生存”的进步思想。这表明他主张",
                "学习西方先进技术，抵抗外国侵略", "效仿西方政治制度，实行维新变法", "推翻满清政府，建立民主共和国", "兴办工厂，实业救国", 2));
        dataList.add(new DataAnswer("古城南京是中国历史一位特殊“见证者”，它见证了\n①中华民国的建立 ②五四运动的爆发 ③日军大屠杀 ④蒋家王朝的覆灭",
                "①②③", "①②③", "①③④", "③④", 3));
        dataList.add(new DataAnswer("全面内战爆发的标志是",
                "重庆谈判", "国民党进攻中原解放区", "中共中央转战陕北", "刘邓大军挺进大别山", 2));

        dataList.add(new DataAnswer("1980年著名作曲家施光南深入安徽．四川农村体验生活，满怀激情地谱写经典歌曲《在希望的田野上》。他选择赴上述农村体验生活的最主要理由是",
                "当地山川峻美，风景秀丽宜人", "少数民族众多，民俗文化丰富", "同属革命老区，富有红色传统", "率先包产到户，农民生活改善", 4));

        dataList.add(new DataAnswer("20世纪70年代中美关系开始走向正常化的标志性事件是",
                "26届联大的召开", "《中美联合公报》的发表", "中美正式建立外交关系", "亚太经合组织建立", 2));
    }

    private void setData() {
        tv_title.setText("第" + Utils.toHanzi(selectPostion + 1 + "") + "题");
        tv_content.setText(dataList.get(selectPostion).getName());
        rb_a.setText("A:  "+dataList.get(selectPostion).getSelect_a());
        rb_b.setText("B:  "+dataList.get(selectPostion).getSelect_b());
        rb_c.setText("C:  "+dataList.get(selectPostion).getSelect_c());
        rb_d.setText("D:  "+dataList.get(selectPostion).getSelect_d());
        rg_select_answer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_a:
                        dataList.get(selectPostion).setIs_select_postion(1);
                        break;
                    case R.id.rb_b:
                        dataList.get(selectPostion).setIs_select_postion(2);
                        break;
                    case R.id.rb_c:
                        dataList.get(selectPostion).setIs_select_postion(3);
                        break;
                    case R.id.rb_d:
                        dataList.get(selectPostion).setIs_select_postion(4);
                        break;
                    default:
                        break;
                }
            }
        });
        if (dataList.get(selectPostion).getIs_select_postion() != 0) {
            switch (dataList.get(selectPostion).getIs_select_postion()) {
                case 1:
                    rb_a.setChecked(true);
                    break;
                case 2:
                    rb_b.setChecked(true);
                    break;
                case 3:
                    rb_c.setChecked(true);
                    break;
                case 4:
                    rb_d.setChecked(true);
                    break;
                default:
                    break;
            }
        }else {
            rg_select_answer.clearCheck();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_next:
                if (selectPostion == 9) {
                    new DialogUtils(AnswerActivity.this, R.layout.view_dialog) {
                        @Override
                        public void initLayout(ViewHelper helper, final Dialog dialog) {
                            helper.setViewClick(R.id.tv_cancel, new ViewHelper.ViewClickCallBack() {
                                @Override
                                public void doClickAction(View v) {
                                    dialog.dismiss();
                                }
                            });
                            helper.setViewClick(R.id.tv_ok, new ViewHelper.ViewClickCallBack() {
                                @Override
                                public void doClickAction(View v) {
                                    dialog.dismiss();
                                    Intent intent = new Intent();
                                    intent.putParcelableArrayListExtra("result", dataList);
                                    setResult(1002, intent);
                                    finish();
                                }
                            });
                        }
                    };
                    return;
                }
                selectPostion++;
                setData();
                break;
            case R.id.tv_last:
                if (selectPostion == 0) {
                    Toast.makeText(AnswerActivity.this, "这是第一题", Toast.LENGTH_SHORT).show();
                    return;
                }
                selectPostion--;
                setData();
                break;
            case R.id.img_back:
                finish();
                break;
        }
    }
}
