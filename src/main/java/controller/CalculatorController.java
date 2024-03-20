package controller;

import java.util.List;
import java.util.Scanner;

public class CalculatorController {

    private static final String DIVISION_WORD= " ";

    public void input() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("잘못된 입력값 입니다");
        split(input);
    }

    private List<String> split(String input) {
        return List.of(input.split(DIVISION_WORD));
    }

    private void process(List<String> list) {

    }
}
