package wang.relish.genos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import wang.relish.genos.permission.HuaweiUtils;
import wang.relish.genos.permission.MeizuUtils;
import wang.relish.genos.permission.MiuiUtils;
import wang.relish.genos.permission.OppoUtils;
import wang.relish.genos.permission.QikuUtils;
import wang.relish.genos.permission.RomUtils;
import wang.relish.genos.permission.VivoUtils;


/**
 * <strong>埼玉的召唤</strong>
 * <br/>
 * 杰诺斯对埼玉奉若神明，尊称其为“老师”，会将埼玉说过的话记录在笔记本中，如果他人对埼玉恶言相向或者藐视会非常生气。
 * <p/>
 * 悬浮窗权限判断/申请。杰诺斯感召到埼玉的召唤, 出现在你的手机屏幕上。
 *
 * @author relish <a href="mailto:relish.wang@gmail.com">Contact me.</a>
 * @since 20190808
 */
/* package */ class SaitamasCall {
    private static final String TAG = "SaitamasCall";

    private static volatile SaitamasCall instance;

    /* package */
    static SaitamasCall getInstance() {
        if (instance == null) {
            synchronized (SaitamasCall.class) {
                if (instance == null) {
                    instance = new SaitamasCall();
                }
            }
        }
        return instance;
    }

    /* package */ boolean checkFloatPermission(Context context, boolean isDirect) {
        Log.i(TAG, "Start check permission");
        if (checkPermission(context)) {
            return true;
        } else {
            if (isDirect) {
                applyPermissionDirect(context);
            }
            return false;
        }
    }

    private boolean checkPermission(Context context) {
        //6.0 版本之后由于 google 增加了对悬浮窗权限的管理，所以方式就统一了
        if (Build.VERSION.SDK_INT < 23) {
            if (RomUtils.checkIsMiuiRom()) {
                return miuiPermissionCheck(context);
            } else if (RomUtils.checkIsMeizuRom()) {
                return meizuPermissionCheck(context);
            } else if (RomUtils.checkIsHuaweiRom()) {
                return huaweiPermissionCheck(context);
            } else if (RomUtils.checkIs360Rom()) {
                return qikuPermissionCheck(context);
            } else if (RomUtils.isOppoSystem()) {
                return oppoROMPermissionCheck(context);
            } else if (RomUtils.isVivoSystem()) {
                return vivoPermissionCheck(context);
            }
        }
        return commonROMPermissionCheck(context);
    }

    private boolean huaweiPermissionCheck(Context context) {
        return HuaweiUtils.checkFloatWindowPermission(context);
    }

    private boolean miuiPermissionCheck(Context context) {
        return MiuiUtils.checkFloatWindowPermission(context);
    }

    private boolean meizuPermissionCheck(Context context) {
        return MeizuUtils.checkFloatWindowPermission(context);
    }

    private boolean qikuPermissionCheck(Context context) {
        return QikuUtils.checkFloatWindowPermission(context);
    }

    private boolean oppoROMPermissionCheck(Context context) {
        return OppoUtils.checkFloatWindowPermission(context);
    }

    private boolean vivoPermissionCheck(Context context) {
        return VivoUtils.checkFloatWindowPermission(context);
    }

    private boolean commonROMPermissionCheck(Context context) {
        //最新发现魅族6.0的系统这种方式不好用，天杀的，只有你是奇葩，没办法，单独适配一下
        if (RomUtils.checkIsMeizuRom()) {
            return meizuPermissionCheck(context);
            // VIVO的i管家比较厉害
        } else if (RomUtils.isVivoSystem()) {
            return vivoPermissionCheck(context);
        } else {
            Boolean result = true;
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    Class clazz = Settings.class;
                    //noinspection unchecked
                    Method canDrawOverlays =
                            clazz.getDeclaredMethod("canDrawOverlays", Context.class);
                    result = (Boolean) canDrawOverlays.invoke(null, context);
                } catch (Exception e) {
                    Log.e(TAG, Log.getStackTraceString(e));
                }
            }
            //noinspection ConstantConditions
            return result;
        }
    }


    /**
     * 直接去申请权限
     */
    private void applyPermissionDirect(Context context) {

        if (Build.VERSION.SDK_INT < 23) {
            if (RomUtils.checkIsMiuiRom()) {
                MiuiUtils.applyMiuiPermission(context);
            } else if (RomUtils.checkIsHuaweiRom()) {
                HuaweiUtils.applyPermission(context);
            } else if (RomUtils.checkIs360Rom()) {
                QikuUtils.applyPermission(context);
            } else if (RomUtils.isOppoSystem()) {
                OppoUtils.applyOppoPermission(context);
            } else if (RomUtils.isVivoSystem()) {
                VivoUtils.applyPermission(context);
            }
        } else {
            // 其他的再试一次
            if (RomUtils.checkIsMeizuRom()) {
                MeizuUtils.applyPermission(context);
            } else if (RomUtils.isVivoSystem()) {
                VivoUtils.applyPermission(context);
            } else {
                try {
                    commonROMPermissionApplyInternal(context);
                } catch (Exception e) {
                    Log.e(TAG, "Throw exception " + e.getMessage(), e);
                }
            }
        }
    }

    private static void commonROMPermissionApplyInternal(Context context)
            throws NoSuchFieldException, IllegalAccessException {
        Class clazz = Settings.class;
        Field field = clazz.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION");
        //noinspection ConstantConditions
        Intent intent = new Intent(field.get(null).toString());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

}
