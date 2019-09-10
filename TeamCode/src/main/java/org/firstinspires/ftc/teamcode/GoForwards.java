package org.firstinspires.ftc.teamcode;

public final class GoForwards extends OpBase {
    @Override
    protected boolean runRobot() {
        runtime.reset();

        frontLeft.setPower(0.4);
        frontRight.setPower(0.4);
        backLeft.setPower(0.4);
        backRight.setPower(0.4);

        while (opModeIsActive() && runtime.seconds() <= 4);

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        return false;
    }

    @Override
    protected boolean isAutonomous() {
        return true;
    }
}
