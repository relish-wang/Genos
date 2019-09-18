package wang.relish.genos;

import wang.relish.genos.Genos;
import wang.relish.genos.GenosBrain;
import wang.relish.genos.Capability;

/**
 * 杰诺斯之脑<br>
 * 1 控制{@link Genos 杰诺斯}的显隐及获取显隐状态<br>
 * 2 控制{@link Genos 杰诺斯}{@link Capability 能力}开关<br>
 * 3 获取{@link Genos 杰诺斯}所在的当前Activity的全类名(含包名)
 *
 * @author relish <a href="mailto:relish.wang@gmail.com">Contact me.</a>
 * @since 20190807
 */
@SuppressWarnings("unused")
public interface GenosBrain {
    /**
     * 显示{@link Genos#mGenosWindow 杰诺斯悬浮球}
     */
    void show();

    /**
     * 隐藏{@link Genos#mGenosWindow 杰诺斯悬浮球}
     */
    void hide();

    /**
     * {@link Genos#mGenosWindow 杰诺斯悬浮球}是否显示
     *
     * @return true-显示;false-隐藏
     */
    boolean isShown();

    /**
     * 启用{@link Genos 杰诺斯}的某项能力
     *
     * @param capabilityName 能力名
     * @see Capability#capabilityName()
     */
    void enable(String capabilityName);

    /**
     * 禁用{@link Genos 杰诺斯}的某项能力
     *
     * @param capabilityName 能力名
     * @see Capability#capabilityName()
     */
    void disable(String capabilityName);

    /**
     * 获取{@link Genos 杰诺斯}所在的当前Activity的全类名(含包名)
     *
     * @return 当前Activity的全类名
     */
    String getTopAtyFullName();
}
