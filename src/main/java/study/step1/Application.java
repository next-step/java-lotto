package study.step1;

import java.util.Scanner;
import java.util.Stack;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. 사용자로 부터 문자열을 입력받는다.
        System.out.println("입력해주세요.");
        String str = scanner.nextLine();
        // 2. 빈공백 문자열을 기준으로 split 처리한다.
        String[] strArr = str.split(" ");
        // 3. split 된 순서대로 계산한다.
        int num1 = 0;
        int num2 = 0;
        String operator = "";

        Stack stack = new Stack();
        for (int i = strArr.length-1; i >= 0; i--) {
            stack.push(strArr[i]);
        }
        System.out.println("");
        for (int i = 0; i <= strArr.length-3; i++) {
            if (stack.size() == 1) break;
            num1 = Integer.parseInt(stack.pop().toString());
            operator = stack.pop().toString();
            num2 = Integer.parseInt(stack.pop().toString());
            stack.push(cal(num1, operator, num2));
        }
        System.out.println("res :: " + stack.pop());
    }

    private static String cal(int num1, String operator, int num2) {
        if ("+".equals(operator)) {
            return String.valueOf(num1 + num2);
        }
        if ("-".equals(operator)) {
            return String.valueOf(num1 - num2);
        }
        if ("*".equals(operator)) {
            return String.valueOf(num1 * num2);
        }
        if ("/".equals(operator)) {
            return String.valueOf(num1 / num2);
        }
        return "";
    }
}
