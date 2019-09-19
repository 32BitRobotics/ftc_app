package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;

public class DcMotorList extends ArrayList<DcMotor> {
    public void setPower(double power) {
        for (DcMotor motor : this) {
            motor.setPower(power);
        }
    }

    public int getCurrentPosition() {
       return this.get(0).getCurrentPosition();
    }

    public void setTargetPosition(int target) {
        for (DcMotor motor: this) {
            motor.setTargetPosition(target);
        }
    }

    public void setMode(DcMotor.RunMode runMode) {
        for (DcMotor motor: this) {
            motor.setMode(runMode);
        }
    }

    public boolean isBusy() {
        for (DcMotor motor: this) {
            if (motor.isBusy()) return true;
        }
        return false;
    }
}
