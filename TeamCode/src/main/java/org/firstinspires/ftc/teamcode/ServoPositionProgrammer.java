//package org.firstinspires.ftc.teamcode;
//
//import com.acmerobotics.dashboard.config.Config;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.Servo;
//
//@Config
//@TeleOp(name="Servo Position Programmer", group="test")
//public class ServoPositionProgrammer extends LinearOpMode {
//    public static double pos;
//    public static double pos2;
//    String mode = "active";
//    boolean xPressed = false;
//    public static String servoName = "turretServo1";
//
//    @Override
//    public void runOpMode() {
//
//        //hardware initialization
//        Servo servo;
//        Servo servo2;
//
//
//        servo = hardwareMap.get(Servo.class, servoName);
//        servo.setDirection(Servo.Direction.REVERSE);
//
//        pos = servo.getPosition();
//        sleep(1000);
//        waitForStart();
//        while(!isStopRequested()) {
//
//            if (mode.equals("active")) {
//                pos = servo.getPosition();
//            }
//
//            if (gamepad1.a && mode.equals("active")) {
//                pos -= 0.001;
//            } else if (gamepad1.b && mode.equals("active")) {
//                pos += 0.001;
//            }
//            if (gamepad1.x && mode.equals("active")) {
//                pos2 -= 0.001;
//            } else if (gamepad1.y && mode.equals("active")) {
//                pos2 += 0.001;
//            }
//
//            servo.setPosition(pos);
//            telemetry.addLine("Press x to switch between passive get position and active set position modes");
//            telemetry.addData("Current mode", mode);
//            telemetry.addData("Current servo", servoName);
//            telemetry.addLine();
//            telemetry.addData("Current Servo pos", servo.getPosition());
//            //telemetry.addData("Current Servo2 pos", servo2.getPosition());
//
//            if (mode.equals("active")) {
//                telemetry.addData("Desired Servo pos", pos);
//                telemetry.addData("Desired Servo2 pos", pos2);
//            }
//
//            telemetry.update();
//            sleep(10);
//        }
//    }
//}
