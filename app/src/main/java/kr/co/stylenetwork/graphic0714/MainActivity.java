package kr.co.stylenetwork.graphic0714;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    ArrayList<Point> list=new ArrayList<Point>();

    String TAG;
    MyView myView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG=this.getClass().getName();

        myView = (MyView)findViewById(R.id.myView);
    }

    public void printOval(ArrayList list){
        /*정해진 좌표를 이용하여  MyView  다시 그리기!!*/
        myView.list=list;
        myView.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "터치했어?");
        /* 터치가 발생하면, 좌표를 컬렉션 객체에 담자*/
        Point point = new Point((int)event.getX(), (int)event.getY());
        list.add(point);
        printOval(list);

        return false;
    }
}












