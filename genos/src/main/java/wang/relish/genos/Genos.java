//..............`.......`.......*=.=O*...^.....*...`.../=...^...*.`O^..=.^................
//..........,*=/.=...,.=...^..,`...`]*..*^....`....=`.,^*../...*.=.=^.,o.=*...............
//.........=,//.....]`.o*..^.,/...*.^*..*^..*`.*...o*=O`.,/....*,^.=^.o`./*.....*.........
//........,`./.....*^..O*..^.o*.....=*...*.*/.,...=`=\^.,^....**o*.=*/^.=/..\*..*.*..,...*
//........../......*..=O\..*=^......``.....=`....,^/`**=*.....*=O..,=`..o^,o^...*.*..=...,
//.........=*.....`...O^,^..=..*....\`....,^....**/..``.*....*/oo..=`..*^,oo....*....*^../
//........=/`..*/\\*.*^..=..........o\....=....*=`..*`*^.....^..o^...^.,**=o*,.......=../*
//........O/.,o/=^,.=*....*........=..^...`....**....,/..../....=^..=^.^...o*``......^.`.=
//........O*,O`./^*.o....*./.`.....`..,^..*.....^*...o^...`..=...O..o.......,^`.....,**..,
//........=^o`.,^o`=o^,***,`.***..*....\^.*.....=`..*o*..=*...^..^./^.......o.o.....`.....
//........=O/..**\/=o^=`^*/.,\o`..^*...=..*..`..*o..*^*.*o/.^.O.**=O...**..=/,O..=........
//.........O`.,,^=^=oo*^^/^,/=o\..^*...=....*\..==o*\**.,o^=^*\^`,O`../^=^.O^OO./^.....=`.
//.........=..=/^.\*\o\[`o\/.,Oo*.^^...*^...*o*.,O^\o^**=o\=***OoO^..oO^=^=/oO^=O`*/..*Oo.
//.............O^.**=Oo`\oO..*=o*.^*=^..*...=o^..O=oO`.*=o^**..=O/../O=^o^==OO=O/./O*//oo*
//.............Oo.\*=OO^.\\`..,O^.**O=`.*`..=oO`.^,\oo.*,O**...*O^./O/=o\\`oOoOO^=OO\oOOO*
//.............,O..^=OO\.=,\.[]/O...^*\..,..=O^\**.oOo.**O.^...*^.=O*.=O^,/O\///,OOOooO=O*
//..............=.=^\^^o^=@@@/\`[^..`.*\....=O`*\=`.\O\.=*.....,^o\[`**\^*oO=o,^oOOO\O`=^=
//...............^=O=\=*\=@@@@^[@@\./\`,\....o..o\...*o*=..]/[`,//`...,]O=\O`.ooO\/,O^*=^O
//...............,=*^^.^.^/O@@@@`.,O@\`*\O`..\..^]\]*[[\=.]/O@/[\@@@@@@@O^[`.,oOO^,/*,/,o`
//................=.,`*/..\..[\@@@@@@@@/Ooo\.,^,,\]]]OO@@@@\..,/@@@@@O/,`....=/=,\/,o[*/^.
//...................=.O^..................`*\,........,[,[\@@@@@/`..........`..//..../...
//....................==\..................,....................................`\`,^O....
//.....................=O................../..................................=^,/\`\`....
//.......................^.................^.................................=oO^=^.......
//.......................\................=.................................,OOO\^........
//........................^...............^................................,OOO./.........
//........................=..............=`..............................*,OOO`...........
//.........................^.............=...............................=O@/`............
//.........................=^.............,`............................OOo@..............
//..........................\^.......................................*,@Oo@/..............
//...........................=^....................................,./@OOo@/..............
//............................=\........,]].......................*,@@@oo@@@..............
//.............................=O.......,@@@@O]]]@@@............*./@@@O/O@@@..............
//............................,]/O`........,[OO@OOO[`.........*./@@@@`,o@@@@..............
//......................]]]@@[,/@@O^.......,`...............*./@@@@/*,o@@@@@@]............
//...................]@@[`.,@@@@@OOO\....................././@@@@@/.*o@@@@@@@`,[@@@]]`....
//............]/@@@@@`.../@O@@@@@@^\@@..................*,@@@@@@/*.,o@@@@@@@@@@`].*\@@@@@@
//@\,]@@@@@@@@@@@@/....,@O@@@@@@@@^`@@@`.............*./@@@@@@O`*..O@@@@@@@@@@@@@.o**\@@@@
///@@@@@@@@@@@@@@^....=@@@@@@@@@@@^.=@@@\.*.......**,O@@@@@@@O`...O@@@@@@@@@@@@@@@..[o/@@@
//@@@@@@@@@@@@@@@....,@@@@@@@@@@@@^..@@@@@\`.....,/@@@@@@@@@O`..*@@@@@@@@@@@@@@@@@.....@@@
//@@@@@@@@@@@@@@^....=@@@@@@@@@@@@O*.O@@@@@@@@@@@@@@@@@@@@@O^..*@@@@@@@@@@@@@@@@@^.....=@@
//@@@@@@@@@@@@@@.....\@@@@@@@@@@@@O^.=@@@@@@@@@@@@@@@@@@@@O`..,@@@@@@@@@@@@@@@@@^..../o@@@
//@@@@@@@@@@@@@@^....,@@@@@@@@@@@@Oo*.\@@@@@@@@@@@@@@@@@@/..*/@@@@@@@@@@@@@@@@@...,[][*@@@
//@@@@@@@@@@@@@@\.....=@@@@@@@@@@oo@^.,@@@@@@@@@@@@@@@@@^.,/@O@@@@@@@@@@@@@@@`.......*@@@@
package wang.relish.genos;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;


/**
 * 杰诺斯<br>
 * 开发者工具插件管理中心
 *
 * @author relish <a href="mailto:relish.wang@gmail.com">Contact me.</a>
 * @since 20190807
 */
public final class Genos extends Service {
    /**
     * 杰诺斯所在页面
     */
    private static String sCurrentActivity = "";
    /**
     * 不需要杰诺斯展示的Activity
     */
    private static List<String> sAtyFilter = new ArrayList<>();
    /**
     * 当前Activity栈中存在的Activity数量, 当数量为0时, 不展示杰诺斯
     */
    private static int sAtyCount = 0;

    private static volatile boolean isMenuShow;
    private volatile boolean isWindowShow;
    /**
     * 是否初始化完毕
     */
    private static volatile boolean isCreated = false;
    private static CapabilityPanelAdapter sMenuAdapter;
    @SuppressLint("StaticFieldLeak")
    private static ContextThemeWrapper sContextWrapper;
    @SuppressLint("StaticFieldLeak")
    private static Application sContext;
    @SuppressLint("StaticFieldLeak")
    private static Genos sInstance;
    private static GenosBrain sGenosBrain = new GenosBrain() {

        @Override
        public void show() {
            if (sInstance != null) sInstance.showPanel();
        }

        @Override
        public void hide() {
            if (sInstance != null) sInstance.hidePanel();
        }

        @Override
        public boolean isShown() {
            return isMenuShow;
        }

        @Override
        public String getTopAtyFullName() {
            return sCurrentActivity;
        }

        @Override
        public void disable(String capabilityName) {
            sMenuAdapter.disable(capabilityName);
        }

        @Override
        public void enable(String capabilityName) {
            sMenuAdapter.enable(capabilityName);
        }
    };

    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mFloatingParams;
    private WindowManager.LayoutParams mPanelLayoutParams;
    /**
     * 杰诺斯悬浮窗
     */
    View mGenosWindow;
    /**
     * 杰诺斯能力控制中心(点击panel外部隐藏)
     */
    private View mCapabilityPanelWindow;

    /**
     * 启动杰诺斯
     * {@link Genos#equip(Capability, String...) 装载能力}需要在启动杰诺斯之前
     *
     * @param context application
     * @see Genos#equip(Capability, String...)
     */
    public static void launch(Application context) {
        sContext = context;
        sContextWrapper = new ContextThemeWrapper(context, R.style.Theme_AppCompat);
        context.bindService(new Intent(context, Genos.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                sInstance = ((GenosBinder) service).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);

        context.registerActivityLifecycleCallbacks(new ActivityLifeCycleCallbacksAdapter() {
            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                sAtyCount++;
                if (sInstance != null && sAtyCount > 0) {
                    sInstance.show();
                }

                String activityName = activity.getLocalClassName();
                for (String name : sAtyFilter) {
                    if (name.equals(activityName)) return;
                }
                sCurrentActivity = activity.getLocalClassName();
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                sAtyCount--;
                if (sInstance != null && sAtyCount == 0) {
                    sInstance.hide();
                    sInstance.hidePanel();
                }
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        initUI(true);
    }

    private void initUI(boolean isDirectly) {
        if (!SaitamasCall.getInstance().checkFloatPermission(sContext, isDirectly)) {
            return;
        }
        initGenosInternal();//初始化悬浮球
        initCapabilityPanel();

        synchronized (Genos.class) {
            for (Capability capability : sMenuAdapter.getData()) {
                capability.onCapabilityPrepared(sContextWrapper, sGenosBrain);
            }
            isCreated = true;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new GenosBinder();
    }

    /**
     * 装载能力模块
     * 装载能力需要在启动杰诺斯之前
     *
     * @param capability          能力
     * @param filterActivityNames 在这些Activity里不需要展示@杰诺斯
     * @see Genos#launch(Application)
     */
    public static void equip(Capability capability, String... filterActivityNames) {
        if (capability == null) return;
        if (sMenuAdapter == null) sMenuAdapter = new CapabilityPanelAdapter();
        if (filterActivityNames != null && filterActivityNames.length > 0) {
            sAtyFilter.addAll(Arrays.asList(filterActivityNames));
        }
        synchronized (Genos.class) {
            if (isCreated) {
                capability.onCapabilityPrepared(sContextWrapper, sGenosBrain);
                sMenuAdapter.addCapability(capability);
            } else {
                sMenuAdapter.addCapability(capability);
            }
        }
    }

    /**
     * 初始化悬浮球，并且绑定悬浮窗的触摸(点击、拖拽)事件
     */
    @SuppressLint("InflateParams")
    private void initGenosInternal() {
        mFloatingParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O
                        ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                        : WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        mFloatingParams.gravity = Gravity.START | Gravity.TOP;

        Display display = mWindowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mFloatingParams.x = size.x - 200;
        mFloatingParams.y = 200;

        mGenosWindow = LayoutInflater.from(sContextWrapper)
                .inflate(R.layout.genos_floating_logo, null);
        show();
        mGenosWindow.setOnTouchListener(new DragOnTouchListener(mGenosWindow, mWindowManager));
        mGenosWindow.setOnClickListener(v -> showPanel());

        ImageView iv = mGenosWindow.findViewById(R.id.iv_logo);
        Resources res = getResources();
        Bitmap bitmap = getBitmap(this, getApplicationInfo().icon);
        if (bitmap == null) {
            iv.setImageResource(getApplicationInfo().icon);// nearly do not occur
        } else {
            RoundedBitmapDrawable logo = RoundedBitmapDrawableFactory.create(
                    res, bitmap);
            logo.setCircular(true);
            iv.setImageDrawable(logo);
        }
        if (sAtyCount == 0) hide();
    }

    /**
     * 初始化能力面板
     */
    @SuppressLint("InflateParams")
    private void initCapabilityPanel() {
        mPanelLayoutParams = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O
                        ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                        : WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                PixelFormat.RGBA_8888
        );
        mPanelLayoutParams.gravity = Gravity.CENTER;
        mPanelLayoutParams.dimAmount = 0.4f;
        mCapabilityPanelWindow = LayoutInflater.from(sContextWrapper).inflate(
                R.layout.genos_capability_panel, null);
        final View panel = mCapabilityPanelWindow.findViewById(R.id.panel);
        mCapabilityPanelWindow.setOnTouchListener((view, event) -> {
            final float x = event.getRawX();
            final float y = event.getRawY();
            Rect rect = new Rect();
            panel.getHitRect(rect);
            boolean isInPanel = rect.contains((int) x, (int) y);
            if (!isInPanel) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    hidePanel();
                }
                return true;
            }
            if (event.getAction() == MotionEvent.ACTION_UP) {
                // 相应能力列表的点击事件
                view.performClick();
            }
            return false;
        });

        RecyclerView recyclerView = mCapabilityPanelWindow.findViewById(R.id.rv_genos_capabilitys);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sMenuAdapter);
    }

    private void showPanel() {
        if (!isMenuShow) {
            isMenuShow = true;
            mWindowManager.addView(mCapabilityPanelWindow, mPanelLayoutParams);
        }
    }

    private void hidePanel() {
        if (isMenuShow) {
            mWindowManager.removeViewImmediate(mCapabilityPanelWindow);
            isMenuShow = false;
        }
    }

    private void show() {
        if (mGenosWindow == null) {
            initUI(false);
        }
        if (mGenosWindow == null) {
            return;
        }
        if (!isWindowShow) {
            isWindowShow = true;
            mWindowManager.addView(mGenosWindow, mFloatingParams);
        }
    }

    private void hide() {
        if (isWindowShow) {
            mWindowManager.removeViewImmediate(mGenosWindow);
            isWindowShow = false;
        }
    }

    public class GenosBinder extends Binder {
        Genos getService() {
            return Genos.this;
        }
    }

    @Nullable
    private static Bitmap getBitmap(Context context, @DrawableRes int resId) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            Drawable drawable = context.getDrawable(resId);
            if (drawable == null) return null;
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        } else {
            bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        }
        return bitmap;
    }
}
