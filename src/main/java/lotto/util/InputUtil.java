package calculator.util;

import java.util.Scanner;

public class InputUtil {

    private final static Scanner scanner = new Scanner(System.in);

    public String inputMoney(){
        return scanner.nextLine();
    }
}
