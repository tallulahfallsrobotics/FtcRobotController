package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Drive")
public class Drive extends LinearOpMode {

    private DcMotor BackLeft, BackRight, FrontLeft, FrontRight, Intake, MiddleLauncher, BackLauncher;
    @Override
    public void runOpMode() {

        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        Intake = hardwareMap.get(DcMotor.class, "Intake");

        MiddleLauncher = hardwareMap.get(DcMotor.class, "MiddleLauncher");
        BackLauncher = hardwareMap.get(DcMotor.class, "BackLauncher");


        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackLeft.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.REVERSE);



        waitForStart();

        if (opModeIsActive()) {

            while (opModeIsActive()) {

                double y  = -gamepad1.left_stick_y;
                double x  =  gamepad1.left_stick_x;
                double rx =  gamepad1.right_stick_x * (gamepad1.right_stick_button ? 1:0.85);


                y  = Math.abs(y)  > 0.1 ? y  : 0;
                x  = Math.abs(x)  > 0.1 ? x  : 0;
                rx = Math.abs(rx) > 0.1 ? rx : 0;

                double forwardCap = gamepad1.left_stick_button ? 1.0 : 0.85;
                y = Range.clip(y, -1, 1);

                y  = Math.copySign(y * y * y, y);
                x  = Math.copySign(x * x * x, x);
                rx = Math.copySign(rx * rx * rx, rx);

                x *= 1;

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

                Intake.setPower(-gamepad1.right_trigger);

                MiddleLauncher.setPower(gamepad1.left_trigger);
                BackLauncher.setPower(-gamepad1.left_trigger);



                //FrontLeft.setPower(fl);
                //FrontRight.setPower(fr);
                //BackLeft.setPower(bl);
                //BackRight.setPower(br);

                telemetry.update();
            }
        }
    }
}
