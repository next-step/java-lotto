package stringCalculator.view;

import java.util.Scanner;
import stringCalculator.Constant;

public class RequestView {
    public String requestUserInput() {
        Scanner sc = new Scanner(System.in);
        printInputRequest();
        String string = sc.next();
        return string.replace("\\n", "\n");
    }
    private void printInputRequest() {
        System.out.println(Constant.REQUEST_USER_INPUT);
    }
}
