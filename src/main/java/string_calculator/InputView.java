package string_calculator;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String scan() {
        System.out.println("Put your equation.");
        return scanner.nextLine();
    }
}
