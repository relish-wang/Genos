package wang.relish.genos.sample;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import wang.relish.genos.Capability;
import wang.relish.genos.Genos;
import wang.relish.genos.GenosBrain;
import wang.relish.genos.SwitchableCapability;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Genos.equip(new Capability() {

            @Override
            public void onCapabilityPrepared(Context context, final GenosBrain brain) {
            }

            @Override
            public String capabilityName() {
                return "普通";
            }

            @Override
            public void onCapabilityEmitted(View view) {
                Toast.makeText(
                        App.this,
                        String.format("你点击了【%s】插件", capabilityName()),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        Genos.launch(this);

        Genos.equip(new SwitchableCapability() {

            @Override
            public void onCapabilitySwitched(CompoundButton button, boolean isChecked) {
                Toast.makeText(
                        App.this,
                        "【" + capabilityName() + "】: 已" + (isChecked ? "开启" : "关闭"),
                        Toast.LENGTH_SHORT
                ).show();
            }

            @Override
            public void onCapabilityPrepared(Context context, final GenosBrain brain) {
            }

            @Override
            public String capabilityName() {
                return "开关";
            }
        });

        Genos.equip(ActivityNameCapability.getInstance());
    }
}
