package wang.relish.genos;

import android.view.View;
import android.widget.CompoundButton;

/**
 * 可开关的能力(nop)
 *
 * @author relish <a href="mailto:relish.wang@gmail.com">Contact me.</a>
 * @since 20190807
 */
public abstract class SwitchableCapability implements Capability {

    /**
     * 当开关被切换
     *
     * @param button    Switch
     * @param isChecked true开; false关
     */
    public abstract void onCapabilitySwitched(CompoundButton button, boolean isChecked);

    @Override
    public final void onCapabilityEmitted(View view) {
        throw new IllegalArgumentException("SwitchableCapability不支持#onCapabilityEmitted(View)");
    }
}
