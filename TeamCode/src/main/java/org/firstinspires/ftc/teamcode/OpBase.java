package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

public abstract class OpBase extends LinearOpMode {

    // hardware members
    public DcMotor frontLeft = null; //front left wheel
    public DcMotor frontRight = null; //front right wheel
    public DcMotor backLeft = null; //back left wheel
    public DcMotor backRight = null; //back right wheel
    public BNO055IMU gyroSensor = null;

    // Declare OpMode members.
    protected ElapsedTime runtime = new ElapsedTime();

    protected abstract boolean runRobot(int goSeconds);
    protected abstract boolean isAutonomous();

    protected double getZAngle() {
        return gyroSensor.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES).firstAngle;
    }

    @Override
    public void runOpMode() {
        // initialize hardware
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        // initialize gyro
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";

        gyroSensor = hardwareMap.get(BNO055IMU.class, "imu");
        gyroSensor.initialize(parameters);

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        DcMotor.RunMode myRunMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
        if (isAutonomous()) {
            myRunMode = DcMotor.RunMode.STOP_AND_RESET_ENCODER;
        }

        frontLeft.setMode(myRunMode);
        frontRight.setMode(myRunMode);
        backLeft.setMode(myRunMode);
        backRight.setMode(myRunMode);

        if (isAutonomous()) {
            myRunMode = DcMotor.RunMode.RUN_USING_ENCODER;
            frontLeft.setMode(myRunMode);
            frontRight.setMode(myRunMode);
            backLeft.setMode(myRunMode);
            backRight.setMode(myRunMode);
        }

        waitForStart();
        runtime.reset();

        if (isAutonomous()) runRobot(4);
        else {
            while (opModeIsActive() && runRobot(4));
        }
    }


}

