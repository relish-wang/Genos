package wang.relish.genos.sample;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import wang.relish.genos.GenosBrain;
import wang.relish.genos.Capability;

/**
 * @author relish <a href="mailto:relish.wang@gmail.com">Contact me.</a>
 * @since 20190807
 */
public class ActivityNameCapability implements Capability {

    private static final ActivityNameCapability capability = new ActivityNameCapability();

    public static ActivityNameCapability getInstance() {
        return capability;
    }

    private GenosBrain brain;

    @Override
    public void onCapabilityPrepared(Context context, GenosBrain brain) {
        this.brain = brain;
        brain.enable(capabilityName());
    }

    @Override
    public String capabilityName() {
        return "当前Activity";
    }

    @Override
    public void onCapabilityEmitted(View view) {
        if (brain == null) return;
        if (!brain.isShown()) return;
        Toast.makeText(view.getContext(), brain.getTopAtyFullName(), Toast.LENGTH_SHORT).show();
    }
}
