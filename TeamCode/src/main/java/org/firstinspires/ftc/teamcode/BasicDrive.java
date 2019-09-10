package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="1-Stick Drive")
public class BasicDrive extends OpBase {
    final double REGULAR_SPEED = 0.8;
    final double SLOW_SPEED = 0.2;

    @Override
    protected boolean runRobot() {
        // get the drive and turn from the gamepad
        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.left_stick_x;

        // blend motion
        double left = drive + turn;
        double right = drive - turn;

        // normalize motion
        double largest = Math.max(left, right);
        if (largest > 1.0) {
            left /= largest;
            right /= largest;
        }

        // speed setting
        double throttle;
        if (gamepad1.b)
            throttle = SLOW_SPEED;
        else
            throttle = REGULAR_SPEED;

        left *= throttle;
        right *= throttle;

        this.frontLeft.setPower(left);
        this.backLeft.setPower(left);
        this.frontRight.setPower(right);
        this.backRight.setPower(right);

        return true;
    }

    @Override
    protected boolean isAutonomous() {
        return false;
    }
}
