package wang.relish.genos;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;


/**
 * {@link Genos#mGenosWindow 杰诺斯悬浮球}移动，解决触摸和点击冲突
 *
 * @author relish <a href="mailto:relish.wang@gmail.com">Contact me.</a>
 * @since 20190807
 */
/* package */ class DragOnTouchListener implements View.OnTouchListener {
    /** 根View */
    private View mRootView;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLayoutParams;
    private float downX;
    private float downY;
    private float prevX;
    private float prevY;
    /** 触摸可以移动的像素距离(超过这个距离则判定为滑动动作) */
    private int mTouchSlop;
    /** 是否长按 */
    private boolean mIsLongClicked;
    /** 长按判定时间 */
    private final static int LONG_CLICK_TIME = 1000;
    /** 长按判定Runnable */
    private Runnable mLongClickRunnable = new Runnable() {
        @Override
        public void run() {
            if (mRootView == null) return;
            mRootView.performLongClick();
            mIsLongClicked = true;
        }
    };

    DragOnTouchListener(View v, WindowManager wm) {
        mRootView = v;
        mWindowManager = wm;
        mLayoutParams = (WindowManager.LayoutParams) v.getLayoutParams();
        mTouchSlop = ViewConfiguration.get(v.getContext()).getScaledTouchSlop();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final float x = event.getRawX();
        final float y = event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = x;
                downY = y;
                prevX = downX;
                prevY = downY;
                mRootView.setLongClickable(false);
                mIsLongClicked = false;
                // ${LONG_CLICK_TIME}毫秒后判定为长按(如果再次期间手指移动或抬起, 将会取消长按判定)
                mRootView.postDelayed(mLongClickRunnable, LONG_CLICK_TIME);
                return false;
            case MotionEvent.ACTION_MOVE: {
                final int deltaX = (int) (x - prevX);//x方向偏移量
                final int deltaY = (int) (y - prevY);//y方向偏移量
                prevX = x;
                prevY = y;

                mLayoutParams.x += deltaX;
                mLayoutParams.y += deltaY;
                mWindowManager.updateViewLayout(mRootView, mLayoutParams);

                /* √(△x^2+△y^2)>= mTouchSlop */
                boolean isMove = Math.sqrt(
                        Math.pow(Math.abs(deltaX), 2) + Math.pow(Math.abs(deltaY), 2)
                ) >= mTouchSlop;
                if (isMove) {
                    /* 返回值并不能说明问题, 要是mRootView里已经没有mLongClickRunnable也会返回false */
                    mRootView.removeCallbacks(mLongClickRunnable);
                }
                return true;
            }
            case MotionEvent.ACTION_UP: {
                if (event.getEventTime() - event.getDownTime() < LONG_CLICK_TIME) {
                    mRootView.removeCallbacks(mLongClickRunnable);
                }
                /* √(△x^2+△y^2)>= mTouchSlop */
                boolean isMove = Math.sqrt(
                        Math.pow(Math.abs(x - downX), 2) + Math.pow(Math.abs(y - downY), 2)
                ) >= mTouchSlop;
                return mIsLongClicked || isMove;
            }
            default:
                return false;
        }
    }
}