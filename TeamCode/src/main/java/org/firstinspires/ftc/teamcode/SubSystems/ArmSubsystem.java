//package org.firstinspires.ftc.teamcode.SubSystems;

// import com.acmerobotics.dashboard.config.Config;
// import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.MotorControlAlgorithm;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//@Config
//public class ArmSubsystem extends BaseSubsystem {
    // Values of the arm positions and power
  //  public static double ARM_INTAKE_POS = -0.03; // 0.04 //-0.09
//    public static double ARM_NEUTRAL_POS = -0.003;
//    public static double ARM_LOW_POS = -.442; //0.132 //0.035
//    public static double ARM_MID_POS = -.41; //0.25 //0.17
//    public static double ARM_HIGH_POS = -.315; //0.36 //0.27
//    public static double ARM_INTERMEDIATE_POS = -0.22; //0.36 //0.27
//
//    public static double ARM_POWER = 0.35;
//    int x = 5;
//    public static double ARM_TICKS_PER_REV = 1425.06;
//    public static double ARM_POS_CHANGE_SPEED = 0.0005;
//
//
//    public static double ARM_UP_WAIT = 0.4;
//    public static double ARM_FORWARD_WAIT = 0.7;
//    public static double ARM_DOWN_WAIT = 0;
//    public static double ARM_RESET_WAIT = 1.0;
//    public static double ARM_RESET_WAIT_2 = 1.5;
//
//    public static boolean useCustompidf = false;
//
//    public static PIDFCoefficients armPIDF = new PIDFCoefficients(10, 0, 0.5, 0, MotorControlAlgorithm.LegacyPID);
//    boolean setIntakePos = false;
//    double targetTime1 = 0;
//    double targetTime2 = 0;
//    double targetTime3 = 0;
//    boolean armUp = false;
//    boolean armForward = false;
//    boolean armReset = false;
//    boolean armReset2 = false;
//    boolean boxUp = false;
//    boolean boxDown = false;
//    boolean armIsUp = false;
//    boolean armIsMoving = false;
//
//    BoxSubsystem box;
//    TurretSubsystem turret;
//    FlipperSubsystem flipper;
//
//    double armTargetPos = 0;
//    double armSelectedPos = 0;
//    double servoSelectedPos = 0;
//    double selectedTurretPos = 0;
//
//    boolean gamepad2StickTouchingEdge = false;
//    double gamepad2StickPos = 0;
//    double gamepad2StickMath1 = 0;
//    double gamepad2StickMath2 = TurretSubsystem.TURRET_SERVOS_FRONT;
//
//    // Create hardware variables
//    public DcMotorEx armMotor = null;

    // Constructor
//    public ArmSubsystem() {
//
//    }
//
//    // Initialize hardware variables
//    public void init(HardwareMap hardwareMap, Telemetry telemetry, BoxSubsystem box, TurretSubsystem turret, FlipperSubsystem flipper) {
//        super.init(hardwareMap, telemetry);
//        this.box = box;
//        this.turret = turret;
//        this.flipper = flipper;
//
//        // gives the name to the arm, and setDirection
//        armMotor = hardwareMap.get(DcMotorEx.class,"armMotor");
//        armMotor.setDirection(DcMotorSimple.Direction.FORWARD);
//        armMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//        armMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        armMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//
//        // Arm Encoders
//        armMotor.setTargetPosition(0);
//        armMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//
//        if (useCustompidf) {
//            armMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, armPIDF);
//        }
//    }
//
    // Arm Commands
//    public void setArmPosition() {
//        armMotor.setTargetPosition((int) (ARM_TICKS_PER_REV * armTargetPos));
//    }
//
//    public void findArmPosition(Gamepad gamepad1, Gamepad gamepad2) {
//        super.gamepadInit(gamepad1, gamepad2);
//
//        //combines the directions of the arm with the other subsystems
//        if (gamepad2.dpad_up) {
//            armUp(ARM_HIGH_POS, BoxSubsystem.BOX_HIGH, TurretSubsystem.TURRET_SERVOS_FRONT, false);
//        } else if (gamepad2.dpad_right) {
//            armUp(ARM_INTERMEDIATE_POS, BoxSubsystem.BOX_SHARED, TurretSubsystem.TURRET_SERVOS_RIGHT, true);
//        } else if (gamepad2.dpad_left) {
//            armUp(ARM_INTERMEDIATE_POS, BoxSubsystem.BOX_SHARED, TurretSubsystem.TURRET_SERVOS_LEFT, true);
//
//
//        } else if (gamepad2.dpad_down) {
//            armReset();
//
//
//        } else if ((gamepad2.right_trigger >= ControllerSubsystem.TRIGGER_THRESHOLD) && armIsUp) {
//            armTargetPos = ARM_HIGH_POS;
//            setArmPosition();
//            box.boxServo.setPosition(BoxSubsystem.BOX_HIGH);
//        } else if ((gamepad2.left_trigger >= ControllerSubsystem.TRIGGER_THRESHOLD) && armIsUp) {
//            armTargetPos = ARM_LOW_POS;
//            setArmPosition();
//            box.boxServo.setPosition(BoxSubsystem.BOX_SHARED);
//        }
//
//        // we basically use distance formula to see how far away the stick is from the center of the joystick, and if it is greater than the joystick threshold, gamepad2StickTouchingEdge will be true
//        gamepad2StickTouchingEdge = (Math.sqrt((Math.pow(-gamepad2.right_stick_y, 2)) + (Math.pow(gamepad2.right_stick_x, 2)))) > ControllerSubsystem.TURRET_JOYSTICK_THRESHOLD;
//
//        // we basically calculate the stick position
//        gamepad2StickPos = Math.toDegrees(Math.atan2(gamepad2.right_stick_x, -gamepad2.right_stick_y)) /*+ (TurretSubsystem.TURRET_RANGE / 2)*/;
//        gamepad2StickMath1 = gamepad2StickPos /*- ((0.5 * TurretSubsystem.TURRET_RANGE) - (TurretSubsystem.TURRET_SERVOS_FRONT * TurretSubsystem.TURRET_RANGE))*/;
//        gamepad2StickMath2 = ((gamepad2StickPos) / (TurretSubsystem.TURRET_RANGE));
//
//        if (gamepad2StickTouchingEdge) {
//            armUp(ARM_HIGH_POS, BoxSubsystem.BOX_HIGH, gamepad2StickMath2, false);
//        }
//
//
//
//
////changes the arm speed itself
//        if (-gamepad2.left_stick_y > ControllerSubsystem.TRIGGER_THRESHOLD && armIsUp) {
//            armTargetPos += ARM_POS_CHANGE_SPEED;
//            setArmPosition();
//        }
//        if (-gamepad2.left_stick_y < -ControllerSubsystem.TRIGGER_THRESHOLD && armIsUp) {
//            armTargetPos -= ARM_POS_CHANGE_SPEED;
//            setArmPosition();
//        }
//
//
//
//
//
//
////if you press both left/right trigger, changes the position itself
//        if (-gamepad2.left_stick_y > ControllerSubsystem.TRIGGER_THRESHOLD && gamepad2.right_trigger >= ControllerSubsystem.TRIGGER_THRESHOLD && armIsUp) {
//            ARM_HIGH_POS+= ARM_POS_CHANGE_SPEED;
//            setArmPosition();
//        }
//        if (-gamepad2.left_stick_y < -ControllerSubsystem.TRIGGER_THRESHOLD && gamepad2.right_trigger >= ControllerSubsystem.TRIGGER_THRESHOLD && armIsUp) {
//            ARM_HIGH_POS -= ARM_POS_CHANGE_SPEED;
//            setArmPosition();
//        }
//
//        if (-gamepad2.left_stick_y > ControllerSubsystem.TRIGGER_THRESHOLD && gamepad2.left_trigger >= ControllerSubsystem.TRIGGER_THRESHOLD && armIsUp) {
//            ARM_LOW_POS+= ARM_POS_CHANGE_SPEED;
//            setArmPosition();
//        }
//        if (-gamepad2.left_stick_y < -ControllerSubsystem.TRIGGER_THRESHOLD && gamepad2.left_trigger >= ControllerSubsystem.TRIGGER_THRESHOLD && armIsUp) {
//            ARM_LOW_POS -= ARM_POS_CHANGE_SPEED;
//            setArmPosition();
//        }
//
//
//
//    }
//
//    public void loopCommand() {
//
//        if (boxUp && runtime.seconds() >= targetTime1) {
//            boxUp = false;
//
//            box.boxServo.setPosition(servoSelectedPos);
//            turret.targetPos = selectedTurretPos;
//            turret.setTurretPosition();
//            turret.disableTurret = false;
//
//            armForward = true;
//        }
//        if (armForward && runtime.seconds() >= targetTime2) {
//            armForward = false;
//
//            armTargetPos = armSelectedPos;
//            armIsUp = true;
//
//            setArmPosition();
//
//            armIsMoving = false;
//        }
//        if (boxDown && runtime.seconds() >= targetTime1) {
//            boxDown = false;
//
//            box.boxServo.setPosition(BoxSubsystem.BOX_DOWN_SLIGHTLY_FORWARD);
//
//            armReset = true;
//        }
//        if (armReset && runtime.seconds() >= targetTime2) {
//            armReset = false;
//
//            armTargetPos = ARM_INTAKE_POS;
//            armIsUp = false;
//            setArmPosition();
//
//            armReset2 = true;
//        }
//        if (armReset2 && runtime.seconds() >= targetTime3) {
//            armReset2 = false;
//
//           box.boxServo.setPosition(BoxSubsystem.BOX_DOWN);
//           armMotor.setPower(0);
//            armIsMoving = false;
//        }
//
//
//    }
//
//    public void armUp(double finalArmPosition, double finalServoPosition, double turretPosition, boolean moveTurretInstantly) {
//        if (!armIsMoving) {
//            armSelectedPos = finalArmPosition;
//            servoSelectedPos = finalServoPosition;
//            selectedTurretPos = turretPosition;
//            armMotor.setPower(ARM_POWER);
//
//            if (!armIsUp) {
//                armIsMoving = true;
//                if (moveTurretInstantly) {
//                    turret.targetPos = turretPosition;
//                } else {
//                    turret.targetPos = TurretSubsystem.TURRET_SERVOS_FRONT;
//                }
//
//                turret.disableTurret = true;
//                armTargetPos = ARM_INTERMEDIATE_POS;
//                setArmPosition();
//                armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//                // action 1
//                boxUp = true;
//                // action 2
//                targetTime1 = runtime.seconds() + ARM_UP_WAIT;
//                // action 3
//                if (moveTurretInstantly) {
//                    targetTime2 = runtime.seconds() + ARM_UP_WAIT;
//                } else {
//                    targetTime2 = runtime.seconds() + ARM_FORWARD_WAIT;
//                }
//            } else {
//                turret.targetPos = turretPosition;
//                turret.setTurretPosition();
////                box.boxServo.setPosition(servoSelectedPos);
//            }
//        }
//    }
//
//
//    public void armReset() {
//        if (!armIsMoving) {
//            if (armIsUp) {
//                armIsMoving = true;
//
//                armMotor.setPower(ARM_POWER);
//
//                turret.targetPos = TurretSubsystem.TURRET_SERVOS_FRONT;
//                turret.setTurretPosition();
//                turret.disableTurret = true;
//
//                armTargetPos = ARM_INTERMEDIATE_POS;
//                setArmPosition();
//
//                armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//
//                // action 1
//                boxDown = true;
//
//                // action 2
//                targetTime1 = runtime.seconds() + ARM_DOWN_WAIT;
//
//                // action 3
//                targetTime2 = runtime.seconds() + ARM_RESET_WAIT;
//
//                // action 4
//                targetTime3 = runtime.seconds() + ARM_RESET_WAIT_2;
//            }
//        }
//    }
// }