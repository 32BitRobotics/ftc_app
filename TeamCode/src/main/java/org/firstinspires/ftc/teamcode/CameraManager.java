package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;

import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;

import java.util.Timer;
import java.util.TimerTask;

public final class CameraManager {
  public Bitmap cameraFeed = null;
  public FtcRobotControllerActivity activity;
  private Timer timer;

  private class GetCameraFeedRunnable extends TimerTask {
    private CameraManager cameraManager;

    public GetCameraFeedRunnable(CameraManager cm) {
      this.cameraManager = cm;
    }

    @Override
    public void run() {
      cameraManager.cameraFeed = activity.imageResult;
      activity.startCameraActivity();
    }
  }

  public CameraManager() {
    activity = FtcRobotControllerActivity.instance;
    timer = new Timer();
    timer.schedule(new GetCameraFeedRunnable(this), 0, 500);
  }
}
