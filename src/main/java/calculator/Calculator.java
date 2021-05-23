package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        StringNumbers numbers = requestInput();
        int sum = numbers.sum();
        System.out.printf("합계는 %d 입니다.", sum);
    }

    private static StringNumbers requestInput() {
        System.out.print("계산할 값을 입력해주세요 : ");
        String[] input = SplitUtil.splitByDelimiter(new Scanner(System.in).nextLine());
        StringNumbers numbers = null;
        try {
             numbers = new StringNumbers(input);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
            requestInput();
        }
        return numbers;
    }
}
