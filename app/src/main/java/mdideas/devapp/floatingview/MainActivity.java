package mdideas.devapp.floatingview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    FrameLayout rooLayout;
    LinearLayout linearLayout;

    int xDelta;
    int yDelta;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rooLayout = (FrameLayout) findViewById(R.id.frameLayout);
        linearLayout = (LinearLayout) findViewById(R.id.linearView);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnTouchListener(MainActivity.this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                FrameLayout.LayoutParams layoutParams0 = (FrameLayout.LayoutParams) v.getLayoutParams();
            xDelta = X - layoutParams0.leftMargin;
            yDelta = Y - layoutParams0.topMargin;
            break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams) v.getLayoutParams();
                layoutParams1.leftMargin = X - xDelta;
                layoutParams1.topMargin = Y - yDelta;
                layoutParams1.rightMargin = -250;
                layoutParams1.bottomMargin = -250;
                v.setLayoutParams(layoutParams1);
                break;
        }

        rooLayout.invalidate();
        return true;
    }
}