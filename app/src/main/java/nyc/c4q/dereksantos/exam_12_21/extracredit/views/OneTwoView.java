package nyc.c4q.dereksantos.exam_12_21.extracredit.views;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class OneTwoView extends View {

    private float mDrawWidth;
    private float mDrawHeight;
    private float mHalfWidth;
    private float mHalfHeight;

    public OneTwoView(Context context) {
        super(context);
    }

    @Override
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight){
        float xPadding = (float)(10 + 10);
        float yPadding = (float)(10 + 10);
        mDrawWidth = width - xPadding;
        mDrawHeight = height - yPadding;
        mHalfWidth = mDrawWidth/2;
        mHalfHeight = mDrawHeight/2;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCustomView(canvas);
    }

    private void drawCustomView(Canvas canvas) {
//        canvas.drawRect(mHalfWidth, mHalfHeight, mDrawWidth, mDrawHeight, mPaint4);
    }
}
