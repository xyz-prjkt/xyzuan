package id.xyz.xyzuan;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class x90qjhhxqo extends Fragment {

    public x90qjhhxqo(){}
    RelativeLayout view;
    private Context mContext;
    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.info_main, container, false);

        getActivity().setTitle(getResources().getString(R.string.navbar_rominfo));

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        TextView build_model = (TextView) view.findViewById(R.id.build_model);
        build_model.setText(GetPropData("ro.product.model"));
        TextView build_device = (TextView) view.findViewById(R.id.build_device);
        build_device.setText(GetPropData("ro.product.device"));
        TextView build_product = (TextView) view.findViewById(R.id.build_product);
        build_product.setText(GetPropData("ro.build.product"));
        TextView build_name = (TextView) view.findViewById(R.id.build_name);
        build_name.setText(GetPropData("ro.product.name"));
        TextView build_brand = (TextView) view.findViewById(R.id.build_brand);
        build_brand.setText(GetPropData("ro.product.brand"));
        TextView build_manufacturer = (TextView) view.findViewById(R.id.build_manufacturer);
        build_manufacturer.setText(GetPropData("ro.product.manufacturer"));
        TextView rom_sdk = (TextView) view.findViewById(R.id.rom_sdk);
        rom_sdk.setText(GetPropData("ro.build.version.sdk"));
        TextView os_ver = (TextView) view.findViewById(R.id.os_ver);
        os_ver.setText(GetPropData("ro.build.version.release"));
        TextView os_spl = (TextView) view.findViewById(R.id.os_spl);
        os_spl.setText(GetPropData("ro.build.version.security_patch"));
        TextView rom_fp = (TextView) view.findViewById(R.id.rom_fp);
        rom_fp.setText(GetPropData("ro.build.fingerprint"));
        TextView rom_Desc = (TextView) view.findViewById(R.id.rom_Desc);
        rom_Desc.setText(GetPropData("ro.build.description"));
        TextView rom_increment = (TextView) view.findViewById(R.id.rom_increment);
        rom_increment.setText(GetPropData("ro.build.version.incremental"));
        TextView rom_ver = (TextView) view.findViewById(R.id.rom_ver);
        rom_ver.setText(GetPropData("ro.build.display.id"));
        TextView kernel_Ver = (TextView) view.findViewById(R.id.kernel_Ver);
        kernel_Ver.setText(GetKernelInfo());
        TextView kernel_long_ver = (TextView) view.findViewById(R.id.kernel_long_ver);
        kernel_long_ver.setText(GetLongKernelInfo());
        TextView device_cam2api = (TextView) view.findViewById(R.id.device_cam2api);
        device_cam2api.setText(GetCam2Api());
        TextView device_board = (TextView) view.findViewById(R.id.device_board);
        device_board.setText(GetPropData("ro.product.board"));
        TextView device_fp = (TextView) view.findViewById(R.id.device_fp);
        device_fp.setText(GetPropData("persist.vendor.sys.fp.vendor")+"|"+ GetPropData("ro.boot.fpsensor") + "|" + GetPropData("sys.fp.vendor"));
        TextView device_selinux = (TextView) view.findViewById(R.id.device_selinux);
        device_selinux.setText(GetSELinuxStatus());
        TextView device_baseband = (TextView) view.findViewById(R.id.device_baseband);
        device_baseband.setText(GetPropData("gsm.version.baseband"));
        TextView device_encrypt_state = (TextView) view.findViewById(R.id.device_encrypted);
        device_encrypt_state.setText(GetPropData("ro.crypto.state"));
        TextView device_tp_info = (TextView) view.findViewById(R.id.device_touchpanel_info);
        device_tp_info.setText(GetTouchPanelInfo());
        TextView device_cam_sensor = (TextView) view.findViewById(R.id.device_camera_sensor);
        device_cam_sensor.setText(GetCameraSensor());
        TextView device_lcm_name = (TextView) view.findViewById(R.id.device_lcm_name);
        device_lcm_name.setText(GetLCMPanel());
        TextView device_battery_health = (TextView) view.findViewById(R.id.device_battery_health);
        device_battery_health.setText(GetBatteryData(3));
        TextView device_battery_capacity = (TextView) view.findViewById(R.id.device_battery_capacity);
        device_battery_capacity.setText(GetBatteryData(1) + " mAh (Native)\n"+getBatteryCapacity(mContext)+" mAh (System)");
        TextView device_battery_status = (TextView) view.findViewById(R.id.device_battery_status);
        device_battery_status.setText(GetBatteryData(4));
        TextView device_battery_type = (TextView) view.findViewById(R.id.device_battery_type);
        device_battery_type.setText(GetBatteryData(2));
    }

    private String GetPropData(String propkeys) {
        try {
            // Run the command
            Process process = Runtime.getRuntime().exec("getprop " + propkeys);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            // Update the view
            //TextView tv = (TextView) view.findViewById(R.id.infotest);
            //tv.setText(log.toString());
            if ( log.toString() != "" ) {
                return log.toString();
            }else{
                return getResources().getString(R.string.unavailable);
            }
        } catch (IOException e) {
            return getResources().getString(R.string.unavailable);
        }
    }
    private String GetKernelInfo() {
        try {
            // Run the command
            Process process = Runtime.getRuntime().exec("uname -r");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            // Update the view
            //TextView tv = (TextView) view.findViewById(R.id.infotest);
            //tv.setText(log.toString());
            return log.toString();
        } catch (IOException e) {
            return getResources().getString(R.string.unavailable);
        }
    }

    private String GetSELinuxStatus() {
        try {
            // Run the command
            Process process = Runtime.getRuntime().exec("getprop ro.boot.selinux");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            // Update the view
            //TextView tv = (TextView) view.findViewById(R.id.infotest);
            //tv.setText(log.toString());
            return log.toString();
        } catch (IOException e) {
            return getResources().getString(R.string.unavailable);
        }
    }

    private String GetLongKernelInfo() {
        try {
            // Run the command
            Process process = Runtime.getRuntime().exec("cat /proc/version");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            // Update the view
            //TextView tv = (TextView) view.findViewById(R.id.infotest);
            //tv.setText(log.toString());
            return log.toString();
        } catch (IOException e) {
            return getResources().getString(R.string.unavailable);
        }
    }

    private String GetTouchPanelInfo() {
        try {
            // Run the command
            Process process = Runtime.getRuntime().exec("cat /sys/android_tp/tp_info");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            // Update the view
            //TextView tv = (TextView) view.findViewById(R.id.infotest);
            //tv.setText(log.toString());
            return log.toString();
        } catch (IOException e) {
            return getResources().getString(R.string.unavailable);
        }
    }

    private String GetBatteryData(int infoType) {
        try {
            String dataFile="";
            switch(infoType){
                case 1:
                    dataFile= "charge_full_design";
                    break;
                case 2:
                    dataFile= "technology";
                    break;
                case 3:
                    dataFile= "health";
                    break;
                case 4:
                    dataFile= "status";
                    break;
            }
            // Run the command
            Process process = Runtime.getRuntime().exec("cat /sys/class/power_supply/battery/" + dataFile);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            // Update the view
            //TextView tv = (TextView) view.findViewById(R.id.infotest);
            //tv.setText(log.toString());
            return log.toString();
        } catch (IOException e) {
            return getResources().getString(R.string.unavailable);
        }
    }

    private String GetCameraSensor() {
        try {
            // Run the command
            Process process = Runtime.getRuntime().exec("cat /sys/android_camera/sensor");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            // Update the view
            //TextView tv = (TextView) view.findViewById(R.id.infotest);
            //tv.setText(log.toString());
            return log.toString();
        } catch (IOException e) {
            return getResources().getString(R.string.unavailable);
        }
    }

    private String GetLCMPanel() {
        try {
            // Run the command
            Process process = Runtime.getRuntime().exec("cat /sys/android_lcd/lcd_name");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            // Grab the results
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }

            // Update the view
            //TextView tv = (TextView) view.findViewById(R.id.infotest);
            //tv.setText(log.toString());
            return log.toString();
        } catch (IOException e) {
            return getResources().getString(R.string.unavailable);
        }
    }
    public float getBatteryCapacity(Context context) {
        Object obj;
        String str = "com.android.internal.os.PowerProfile";
        try {
            obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        } catch (Exception e) {
            e.printStackTrace();
            obj = null;
        }
        try {
            return (float) ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", new Class[]{String.class}).invoke(obj, new Object[]{"battery.capacity"})).doubleValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1.0f;
        }
    }
    private String GetCam2Api() {
        String CamValue1 = GetPropData("persist.vendor.camera.HAL3.enabled");
        if (CamValue1 != getResources().getString(R.string.unavailable) ){
            if ( Integer.parseInt(CamValue1) == 1 ){
                return getResources().getString(R.string.yes);
            }else{
                return getResources().getString(R.string.no);
            }
        }
        CamValue1 = GetPropData("persist.camera.HAL3.enabled");
        if (CamValue1 != getResources().getString(R.string.unavailable) ){
            if ( Integer.parseInt(CamValue1) == 1 ){
                return getResources().getString(R.string.yes);
            }else{
                return getResources().getString(R.string.no);
            }
        }
        return getResources().getString(R.string.unavailable);
    }
}
