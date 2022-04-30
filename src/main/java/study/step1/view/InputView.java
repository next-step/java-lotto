package study.step1.view;

import study.step1.domain.Formula;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Formula inputStringFromUser() {
        System.out.println("계산할 수식을 입력해주세요.");
        return Formula.of(scanner.nextLine());
    }
}
