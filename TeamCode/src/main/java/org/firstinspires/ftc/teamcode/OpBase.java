package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public abstract class OpBase extends LinearOpMode {

    // hardware members
    public DcMotor lMotor;
    public DcMotor rMotor;

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    protected abstract boolean runRobot();
    protected abstract boolean isAutonomous();

    @Override
    public void runOpMode() {
        // initialize hardware
        lMotor = hardwareMap.dcMotor.get("lMotor");
        rMotor = hardwareMap.dcMotor.get("rMotor");

        waitForStart();
        runtime.reset();

        if (isAutonomous()) runRobot();
        else {
            while (opModeIsActive() && runRobot());
        }
    }
}
