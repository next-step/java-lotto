package stringPlusCalculate.View;


import stringPlusCalculate.Constants;

import java.util.Scanner;

public class InputView {

    Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static InputView init() {
        return new InputView();
    }

    public String userInteractionString() {
        System.out.println(Constants.INPUT_INFORMATION);
        return scanner.nextLine();
    }
}
