package wang.relish.genos;

import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 杰诺斯能力列表面板适配器
 *
 * @author relish <a href="mailto:relish.wang@gmail.com">Contact me.</a>
 * @since 20190806
 */
/* package */ class CapabilityPanelAdapter extends RecyclerView.Adapter<CapabilityPanelAdapter.ViewHolder> {

    private List<Capability> mData = new ArrayList<>();
    private HashMap<String, Boolean> mStatusMap = new HashMap<>();
    private SparseBooleanArray mInitStateMap = new SparseBooleanArray();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.genos_item_capability, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        final Capability capability = mData.get(position);
        if (capability == null) return;
        final String capabilityName = capability.capabilityName();
        holder.tvCapabilityName.setText(capabilityName);
        final Boolean isEnable = mStatusMap.get(capabilityName);
        if (isEnable != null && isEnable) {
            holder.tvCapabilityName.setTextColor(Color.BLACK);// enable textColor
            holder.tvCapabilityName.setEnabled(true);
            holder.stCapability.setEnabled(true);
        } else {
            holder.tvCapabilityName.setTextColor(Color.LTGRAY);// disable textColor
            holder.tvCapabilityName.setEnabled(false);
            holder.stCapability.setEnabled(false);
        }
        if (capability instanceof SwitchableCapability) {
            holder.stCapability.setVisibility(View.VISIBLE);
            final SwitchableCapability switchableCapability = (SwitchableCapability) capability;
            holder.stCapability.setOnCheckedChangeListener(null);
            holder.stCapability.setChecked(isEnable != null && isEnable);
            holder.stCapability.setOnCheckedChangeListener((button, isChecked) -> {
                mStatusMap.put(capabilityName, isChecked);
                switchableCapability.onCapabilitySwitched(button, isChecked);
            });
            if (!mInitStateMap.get(position)) {
                mInitStateMap.put(position, true);
            }
        } else {
            holder.stCapability.setVisibility(View.GONE);
            holder.stCapability.setOnCheckedChangeListener(null);
        }
        holder.itemView.setOnClickListener(v -> {
            if (capability instanceof SwitchableCapability || !(isEnable != null && isEnable)) {
                return;
            }
            capability.onCapabilityEmitted(v);
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        /** 能力名 */
        private TextView tvCapabilityName;
        /** 能力开关(SwitchableCapability使用) */
        private Switch stCapability;

        ViewHolder(View itemView) {
            super(itemView);
            tvCapabilityName = itemView.findViewById(R.id.tv_capability_name);
            stCapability = itemView.findViewById(R.id.st_capability);
        }
    }

    void addCapability(Capability capability) {
        mData.add(capability);
        mStatusMap.put(capability.capabilityName(), true);
        notifyDataSetChanged();
    }

    void disable(String capabilityName) {
        mStatusMap.put(capabilityName, false);
        notifyDataSetChanged();
    }

    void enable(String capabilityName) {
        mStatusMap.put(capabilityName, true);
        notifyDataSetChanged();
    }

    List<Capability> getData() {
        return mData;
    }
}
