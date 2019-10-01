package org.firstinspires.ftc.teamcode;

public class GetStones extends OpBase {
    @Override
    protected boolean runRobot(int goSeconds) {
        this.gyroDrive(0.3,2*12, 0);
        this.gyroTurn(0.3, 90);
        this.gyroDrive(0.3, 2*12, 90);
        return false;
    }

    @Override
    protected boolean isAutonomous() {
        return true;
    }
}
