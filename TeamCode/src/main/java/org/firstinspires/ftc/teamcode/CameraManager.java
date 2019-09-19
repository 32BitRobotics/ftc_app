package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.widget.RelativeLayout;

@SuppressWarnings("deprecation")
public final class CameraManager {
    private Activity activity;
    private Context context;
    private Camera camera;

    public CameraManager(Activity a, Context c) {
        this.activity = a;
        this.context = c;
    }

    private Camera openCamera() {
        int cameraId = -1;
        Camera cam = null;
        int numCams = Camera.getNumberOfCameras();
        for (int i = 0; i < numCams; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                cameraId = i;
                break;
            }
        }

        try {
            cam = Camera.open(cameraId);
        } catch (Exception e) {
            System.out.println("I have shidded myself repeatedly and I am not afraid to admit it");
        }

        return cam;
    }

    //public Bitmap takeScreenshot() {
    //    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    //}
}
