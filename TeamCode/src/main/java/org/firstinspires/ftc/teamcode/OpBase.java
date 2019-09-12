package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public abstract class OpBase extends LinearOpMode {

    // hardware members
    public DcMotor frontLeft = null; //front left wheel
    public DcMotor frontRight = null; //front right wheel
    public DcMotor backLeft = null; //back left wheel
    public DcMotor backRight = null; //back right wheel

    // Declare OpMode members.
    protected ElapsedTime runtime = new ElapsedTime();

    protected abstract boolean runRobot();
    protected abstract boolean isAutonomous();

    @Override
    public void runOpMode() {
        // initialize hardware
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        if (isAutonomous()) runRobot();
        else {
            while (opModeIsActive() && runRobot());
        }
    }
}
