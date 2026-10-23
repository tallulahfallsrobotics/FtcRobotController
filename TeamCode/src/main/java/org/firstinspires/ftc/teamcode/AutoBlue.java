package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import static org.firstinspires.ftc.teamcode.Configuration.*;
@Autonomous(name = "Auto Blue")
public class AutoBlue extends LinearOpMode {

    @Override
    public void runOpMode() {

        DcMotor backLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "BackRight");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "FrontRight");

        DcMotor intake = hardwareMap.get(DcMotor.class, "Intake");

        DcMotor middleLauncher = hardwareMap.get(DcMotor.class, "MiddleLauncher");
        DcMotor backLauncher = hardwareMap.get(DcMotor.class, "BackLauncher");

        Servo lift = hardwareMap.get(Servo.class, "Lift");


        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        backLauncher.setDirection(DcMotor.Direction.REVERSE);



        waitForStart();

        if (opModeIsActive()) {

            while (opModeIsActive()) {
                
                telemetry.update();
            }
        }
    }
}
