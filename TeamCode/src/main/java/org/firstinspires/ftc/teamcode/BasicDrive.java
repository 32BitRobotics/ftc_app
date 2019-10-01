package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="1-Stick Drive")
public class BasicDrive extends OpBase {
    @Override
    protected boolean runRobot(int goSeconds) {
        // get the drive and turn from the gamepad
        double drive = -gamepad1.left_stick_y;
        double turn = -gamepad1.left_stick_x;

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
        if (gamepad1.dpad_left) this.moveSide(false); else if (gamepad1.dpad_right) this.moveSide(true);

        telemetry.addData("Left Speed", left);
        telemetry.addData("Right Speed", right);
        telemetry.addData("Drive", drive);
        telemetry.addData("Turn", turn);
        telemetry.update();

        return true;
    }

    @Override
    protected boolean isAutonomous() {
        return false;
    }
}
