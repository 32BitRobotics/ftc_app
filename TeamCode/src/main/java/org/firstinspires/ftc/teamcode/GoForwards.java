package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Goes Forwards for 4 Seconds")
public final class GoForwards extends OpBase {
    @Override
    protected boolean runRobot(int goSeconds) {
        runtime.reset();

        driveAll.setPower(0.4);

        while (opModeIsActive() && runtime.seconds() <= goSeconds) {
            telemetry.addData("Left Speed", frontLeft.getPower());
            telemetry.addData("Right Speed", frontRight.getPower());
            telemetry.update();
        }

        driveAll.setPower(0.0);

        return false;
    }

    @Override
    protected boolean isAutonomous() {
        return true;
    }
}
