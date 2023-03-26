package calculator.view;

import java.util.Scanner;

public class InputView {

    public static String getCalLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
