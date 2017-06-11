package yhdj.example.com.wuziqi;

import android.graphics.Point;

import java.util.ArrayList;

import cn.bmob.v3.BmobObject;



public class Match extends BmobObject {
    private ArrayList<Point> mWhiteArray = new ArrayList<>();
    private ArrayList<Point> mBlackArray = new ArrayList<>();
    private String roomName;
    private String username;
    private int state;
    private boolean isBegin;

    public boolean isBegin() {
        return isBegin;
    }

    public void setBegin(boolean begin) {
        isBegin = begin;
    }

    public ArrayList<Point> getWhiteArray() {
        return mWhiteArray;
    }

    public void setWhiteArray(ArrayList<Point> whiteArray) {
        mWhiteArray = whiteArray;
    }

    public ArrayList<Point> getBlackArray() {
        return mBlackArray;
    }

    public void setBlackArray(ArrayList<Point> blackArray) {
        mBlackArray = blackArray;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
