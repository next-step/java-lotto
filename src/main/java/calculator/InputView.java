package calculator;

import java.util.Scanner;

public class InputView {
    
    public static String inputExpression() {
        System.out.println("문자열을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return checkInputNullOrZero(userInput);
    }
    
    private static String checkInputNullOrZero(String userInput) {
        if (userInput == null || userInput.equals("")) {
            return "0";
        }
        return userInput;
    }
}
