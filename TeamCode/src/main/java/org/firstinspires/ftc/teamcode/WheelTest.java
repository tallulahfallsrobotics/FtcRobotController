package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Wheel Test")
public class WheelTest extends LinearOpMode {

    private DcMotor BackLeft, BackRight, FrontLeft, FrontRight, Intake, MiddleLauncher, BackLauncher;
    @Override
    public void runOpMode() {

        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        Intake = hardwareMap.get(DcMotor.class, "Intake");
        MiddleLauncher = hardwareMap.get(DcMotor.class, "MiddleLauncher");
        BackLauncher = hardwareMap.get(DcMotor.class, "Intake");




        waitForStart();

        if (opModeIsActive()) {

            while (opModeIsActive()) {



                FrontLeft.setPower(0.1);
                FrontRight.setPower(0.25);
                BackLeft.setPower(0.66);
                BackRight.setPower(1);

                telemetry.update();
            }
        }
    }
}
