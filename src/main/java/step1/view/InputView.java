package step1.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_COMMNET = "Input the string for Calculate : ";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputData() {

        System.out.println(INPUT_COMMNET);
        String inputString = scanner.next();
        return inputString;

    }

}
