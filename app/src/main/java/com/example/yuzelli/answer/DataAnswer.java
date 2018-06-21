package com.example.yuzelli.answer;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by 51644 on 2018/6/19.
 */

public class DataAnswer implements Parcelable {

    private String name;
    private String select_a;
    private String select_b;
    private String select_c;
    private String select_d;

    private int is_select_postion;
    private int is_ture;

    public DataAnswer(String name,String select_a, String select_b, String select_c, String select_d, int is_ture) {
        this.name = name;
        this.select_a = select_a;
        this.select_b = select_b;
        this.select_c = select_c;
        this.select_d = select_d;
        this.is_ture = is_ture;
    }

    protected DataAnswer(Parcel in) {
        name = in.readString();
        select_a = in.readString();
        select_b = in.readString();
        select_c = in.readString();
        select_d = in.readString();
        is_select_postion = in.readInt();
        is_ture = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(select_a);
        dest.writeString(select_b);
        dest.writeString(select_c);
        dest.writeString(select_d);
        dest.writeInt(is_select_postion);
        dest.writeInt(is_ture);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataAnswer> CREATOR = new Creator<DataAnswer>() {
        @Override
        public DataAnswer createFromParcel(Parcel in) {
            return new DataAnswer(in);
        }

        @Override
        public DataAnswer[] newArray(int size) {
            return new DataAnswer[size];
        }
    };

    public int getIs_select_postion() {
        return is_select_postion;
    }

    public void setIs_select_postion(int is_select_postion) {
        this.is_select_postion = is_select_postion;
    }

    public String getName() {
        return name;
    }

    public String getSelect_a() {
        return select_a;
    }

    public String getSelect_b() {
        return select_b;
    }

    public String getSelect_c() {
        return select_c;
    }

    public String getSelect_d() {
        return select_d;
    }

    public int getIs_ture() {
        return is_ture;
    }
}
