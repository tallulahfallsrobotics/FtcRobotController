package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;
import static org.firstinspires.ftc.teamcode.Configuration.*;

@TeleOp(name = "Drive")
public class Drive extends LinearOpMode {


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



                intake.setPower(-gamepad1.right_trigger);

                if(gamepad2.a) {
                    middleLauncher.setPower(middleLauncherPollenSpeed);
                    backLauncher.setPower(backLauncherPollenSpeed);
                }
                if(gamepad2.x) {
                    middleLauncher.setPower(middleLauncherNectarSpeed);
                    backLauncher.setPower(backLauncherNectarSpeed);
                }
                if (gamepad2.b) {
                    middleLauncher.setPower(0);
                    backLauncher.setPower(0);
                }

                drive(gamepad1, frontLeft, frontRight, backLeft, backRight);

                telemetry.update();
            }
        }
    }

    public static void drive(Gamepad gamepad1, DcMotor FrontLeft, DcMotor FrontRight, DcMotor BackLeft, DcMotor BackRight) {
        double y  = -gamepad1.left_stick_y;
        double x  =  gamepad1.left_stick_x;
        double rx =  gamepad1.right_stick_x * (gamepad1.right_stick_button ? sprintRotateMaxSpeed:rotateMaxSpeed);


        y  = Math.abs(y)  > 0.1 ? y  : 0;
        x  = Math.abs(x)  > 0.1 ? x  : 0;
        rx = Math.abs(rx) > 0.1 ? rx : 0;

        y = Range.clip(y, -1, 1);

        y  = Math.copySign(y * y * y, y);
        x  = Math.copySign(x * x * x, x);
        rx = Math.copySign(rx * rx * rx, rx);


        double fl = y + x + rx;
        double fr = y - x - rx;
        double bl = y - x + rx;
        double br = y + x - rx;

        double max = Math.max(
                Math.max(Math.abs(fl), Math.abs(fr)),
                Math.max(Math.abs(bl), Math.abs(br))
        );

        if (max > 1.0) {
            fl /= max;
            fr /= max;
            bl /= max;
            br /= max;
        }



        FrontLeft.setPower(fl);
        FrontRight.setPower(fr);
        BackLeft.setPower(bl);
        BackRight.setPower(br);
    }
}
