package stringaddcalculator;

import stringaddcalculator.StringAddCalculator;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("더하기 연산을 원하는 숫자를 입력해 주세요. 단, 숫자는 쉼표 또는 콜론으로 구분되어야 합니다." +
                "(커스텀 구분자를 사용하는 경우, //와 @ 사이에 원하시는 구분자를 입력 후 숫자를 입력해 주세요. 예시 : //#@1#2#3");
        String input = scanner.nextLine();

        int sum = StringAddCalculator.addString(input);
        System.out.println("합계 : " + sum);
    }
}