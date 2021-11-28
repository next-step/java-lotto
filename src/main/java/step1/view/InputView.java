package step1.view;

import step1.domain.Inputs;

import java.util.Scanner;

public class InputView {


    public static Inputs start() {
        System.out.println("입력하세요");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return Inputs.create(input);
    }
}
