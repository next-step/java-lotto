package calculator;

import java.util.Scanner;

public class Calculator {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StringNumbers numbers;
        try {
            numbers = requestInput();
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자가 아닙니다.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        printOutput(numbers.sum());
    }

    private static StringNumbers requestInput() {
        System.out.print("계산할 값을 입력해주세요 : ");
        String[] input = SplitUtil.splitByDelimiter(scanner.nextLine());
        return new StringNumbers(input);
    }

    private static void printOutput(int sum) {
        System.out.printf("합계는 %d 입니다.", sum);
    }
}
