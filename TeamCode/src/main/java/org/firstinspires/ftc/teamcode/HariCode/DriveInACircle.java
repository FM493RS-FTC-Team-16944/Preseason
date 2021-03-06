// simple autonomous program that drives bot in a circle then ends.
// this code assumes it will end before the period is over but if the period ended while
// still driving, this code will just stop.

package org.firstinspires.ftc.teamcode.HariCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Drive Circle")
//@Disabled
public class DriveInACircle extends LinearOpMode
{
    DcMotor leftDrive;
    DcMotor rightDrive;

    // called when init button is  pressed.
    @Override
    public void runOpMode() throws InterruptedException
    {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");

        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        sleep(500);              // wait so that above telemetry is visible.

        // set power levels 75% left and 10% right to drive in an arc to the right.

        leftDrive.setPower(0.75);
        rightDrive.setPower(0.20);

        sleep(8500);            // drive 5 seconds to make a circle.

        // turn the motors off.

        rightDrive.setPower(0);
        leftDrive.setPower(0);
    }
}
