import Messages.ActionMenu;
import Messages.NameEntering;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("The game is started");

        System.out.print("Enter first robot name: ");
        Robot robot1 = new Robot(NameEntering.getRobotName());

        System.out.println();

        System.out.print("Enter second robot name: ");

        Robot robot2 = new Robot(NameEntering.getRobotName());
        do{
            ActionMenu.printActionMenu(robot1.robotName);
            char firstRobotHit = robot1.enteredKey();

            if(robot1.hitRobot(firstRobotHit, robot1.robotName) && !(String.valueOf(firstRobotHit).equalsIgnoreCase("p"))){
                robot2.health = robot2.health - 20;
                System.out.println("You damaged robot " + robot2.robotName);
            }else if(String.valueOf(firstRobotHit).equalsIgnoreCase("p")){
                robot1.health = 0;
                break;
            }else {
                System.out.println(robot1.robotName + " missed the target");
            }
            System.out.println();
            ActionMenu.printActionMenu(robot2.robotName);
            char secondRobotHit = robot2.enteredKey();

            if(robot2.hitRobot(secondRobotHit, robot2.robotName) && !(String.valueOf(secondRobotHit).equalsIgnoreCase("p"))){
                robot1.health = robot1.health - 20;
                System.out.println("You damaged robot " + robot1.robotName);
            }else if(String.valueOf(secondRobotHit).equalsIgnoreCase("p")){
                robot2.health = 0;
                break;
            }else {
                System.out.println(robot2.robotName + " missed the target");
            }
            System.out.println();
            System.out.println(robot1.robotName + " health = " + robot1.health);
            System.out.println(robot2.robotName + " health = " + robot2.health);
            System.out.println();

        }while (robot1.health > 0 && robot2.health > 0);

        if(robot1.health == 0 && robot2.health > 0){
            System.out.println("Congratulations " + robot2.robotName + " you kicked ass of " + robot1.robotName);
        }else if(robot1.health > 0 && robot2.health == 0){
            System.out.println("Congratulations " + robot1.robotName + " you kicked ass of " + robot2.robotName);
        }else {
            System.out.println("You both are losers, that's draw");
        }

    }
}
