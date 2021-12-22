package Messages;

import java.util.Scanner;

public class NameEntering {
    public static String getRobotName(){

        Scanner scanner;
        do{
            scanner = new Scanner(System.in);
        }while (scanner == null);
        return scanner.nextLine();
    }


}
