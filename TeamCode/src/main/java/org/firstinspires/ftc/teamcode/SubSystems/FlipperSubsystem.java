package org.firstinspires.ftc.teamcode.SubSystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class FlipperSubsystem extends BaseSubsystem {
    // Values
    public static double FLIPPER_OPEN = 0.270;
    public static double FLIPPER_CLOSED = 0.607;
//    public static double FLIPPER_UP = 0.0;

//    boolean disableFlipper = true;

    // Create hardware variables
    public Servo flipperServo = null;


    // Constructor
    public FlipperSubsystem() {

    }

    // Initialize hardware variables
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        super.init(hardwareMap, telemetry);
        flipperServo = hardwareMap.get(Servo.class,"flipperServo");
        flipperServo.setDirection(Servo.Direction.FORWARD);
    }

    public void defaultCommand(Gamepad gamepad1, Gamepad gamepad2) {
        super.gamepadInit(gamepad1, gamepad2);
        if (gamepad2.right_bumper/* && !disableFlipper*/) {
            flipperServo.setPosition(FLIPPER_OPEN);
        } else/* if (!disableFlipper) */ {
            flipperServo.setPosition(FLIPPER_CLOSED);
        }
    }
}