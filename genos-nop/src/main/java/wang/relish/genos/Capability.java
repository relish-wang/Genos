package wang.relish.genos;

import android.content.Context;
import android.view.View;
import java.lang.String;

/**
 * 装载到{@link Genos 杰诺斯}上的能力(nop)<br>
 * 可以理解为是一个plugin
 * <p>
 * (漫画中)杰诺斯已装载的能力有:
 * - 武装烧毁炮(基本武器)
 * - 黏鸟胶(与索尼克一战后)
 * - 火箭拳、刀刃、螺旋烧毁炮(被豪杰击败后)
 * - 攻击特化型的改造(以弥补火力上的不足)
 *
 * @author relish <a href="mailto:relish.wang@gmail.com">Contact me.</a>
 * @see Genos#equip(Capability, String...)
 * @since 20190807
 */
public interface Capability {
    /**
     * 当能力被装载到{@link Genos 杰诺斯}上时
     *
     * @param context 上下文(ContextThemeWrapper)
     * @param brain   杰诺斯之脑
     * @see GenosBrain 杰诺斯之脑
     */
    void onCapabilityPrepared(Context context, GenosBrain brain);

    /**
     * 能力名(会显示在能力面板上)
     *
     * @return 能力名
     */
    String capabilityName();

    /**
     * 发射能量炮(当某项能力被点击)
     *
     * @param view 能力列表itemView
     */
    void onCapabilityEmitted(View view);
}
