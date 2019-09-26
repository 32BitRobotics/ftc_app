package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Goes Forwards for 4 Seconds")
public final class GoForwards extends OpBase {
    @Override
    protected boolean runRobot(int goSeconds) {
        runtime.reset();

        driveAll.setPower(0.4);

        while (opModeIsActive() && runtime.seconds() <= goSeconds);

        driveAll.setPower(0.4);

        return false;
    }

    @Override
    protected boolean isAutonomous() {
        return true;
    }
}
