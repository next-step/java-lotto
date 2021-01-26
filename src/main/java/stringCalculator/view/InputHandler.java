package stringCalculator.view;

import java.util.Scanner;
import stringCalculator.Constant;

public class InputHandler {
    public String requestUserInput() {
        Scanner sc = new Scanner(System.in);
        printInputRequest();
        return sc.nextLine();
    }
    private void printInputRequest() {
        System.out.println(Constant.REQUEST_USER_INPUT);
    }
}
