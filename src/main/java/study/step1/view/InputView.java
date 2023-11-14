package study.step1.view;

import java.util.Scanner;

import static study.step1.view.InputParser.parse;

public class InputView {

    public static String[] input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수식을 입력하세요. (정수)");
        String input = scanner.nextLine();
        return parse(input);
    }
}
