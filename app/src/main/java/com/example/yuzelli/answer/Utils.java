package com.example.yuzelli.answer;

/**
 * Created by 51644 on 2018/6/19.
 */

public class Utils {


    private static String[] num = {"零","一","二","三","四","五","六","七","八","九","十"};

    private static String[] unit = {"","十","百","千","万","十","百","千","亿"};

    private static String[] result;

    public static String toHanzi(String input) {
        String out = "";
        result = new String[input.length()];
        int length = result.length;
        for(int i = 0; i< length; i++) {
            result[i] = String.valueOf(input.charAt(i));
        }
        for(int i = 0; i< length; i++) {
            int back;
            if(!result[i].equals("0")) {
                back = length - i - 1;
                out += num[Integer.parseInt(result[i])];
                out += unit[back];
            } else {
                //最后一位不考虑
                if(i == (length - 1)) {
                    if(length > 4 && result[length - 1].equals("0") && result[length - 2].equals("0") && result[length - 3].equals("0") && result[length - 4].equals("0")){
                        out += unit[4];
                    }
                } else {
                    //九位数，千万，百万，十万，万位都为0，则不加“万”
                    if(length == 9 && result[1].equals("0") && result[2].equals("0") && result[3].equals("0") && result[4].equals("0")) {

                    } else {
                        //大于万位，连着的两个数不为0，万位等于0则加上“万”
                        if(length > 4 && !result[i+1].equals("0") && result[length -5].equals("0")){
                            out += unit[4];
                        }
                    }
                    //万位之后的零显示
                    if(i == length -4 && !result[i+1].equals("0")) {
                        out += num[0];
                    }
                }
            }
        }
        return out;
    }

    public static String getContent(DataAnswer dataAnswer, int position) {
        String content = "第" + toHanzi(position + 1 + "") + "题";
        if (dataAnswer.getIs_select_postion() == dataAnswer.getIs_ture()) {
            content += "您的选择正确："+getSelect(dataAnswer.getIs_ture());
        } else if (dataAnswer.getIs_select_postion() == 0) {
            content += "您未选择，正确结果是："+getSelect(dataAnswer.getIs_ture());
        } else {
            content += "您的选择错误的：" + getSelect(dataAnswer.getIs_select_postion()) + "正确结果是："+ getSelect(dataAnswer.getIs_ture()) ;
        }
        return content;
    }

    private static String getSelect(int is_select_postion) {
        String content = "";
        switch (is_select_postion) {
            case 1:
                content = "A";
                break;
            case 2:
                content = "B";
                break;
            case 3:
                content = "C";
                break;
            case 4:
                content = "D";
                break;
        }
        return content;
    }


}
