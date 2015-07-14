package game.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import kr.co.stylenetwork.graphic0714.R;

public class GameView extends View {
    Bitmap ship;
    private int posX;
    private int posY;
    Paint paint;

    /* 조이스틱, 총알버튼의 크기*/
    RectF[] control = new RectF[5];
    int controlWidth=150;
    int controlHeight=150;
    int x=200;
    int y=950;
    int gap=20;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
        ship= Bitmap.createScaledBitmap(bitmap,100,100, false);

        paint = new Paint();
        paint.setColor(Color.RED);

        control[0]=new RectF(x,y, x+controlWidth,y+controlHeight);/*up*/
        control[1]=new RectF(x,(y+controlHeight+gap), x+controlWidth,(y+controlHeight+gap)+controlHeight);/*down*/
        control[2]=new RectF((x-controlWidth-gap),(y+controlHeight+gap), (x-controlWidth-gap)+controlWidth,(y+controlHeight+gap)+controlHeight);/*left*/
        control[3]=new RectF((x+controlWidth+gap),(y+controlHeight+gap), (x+controlWidth+gap)+controlWidth,(y+controlHeight+gap)+controlHeight);/*right*/
        control[4]=new RectF(x+1300 ,(y+controlHeight+gap), x+1300,(y+controlHeight+gap)+controlHeight);/*fire*/

    }

    /*조이스틱 그리기*/
    public void paintJoyStick(Canvas canvas){
        for(int i=0;i<control.length;i++){
           canvas.drawRect( control[i] , paint);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(ship, posX, posY, null);

        paintJoyStick(canvas);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}









