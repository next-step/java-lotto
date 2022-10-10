package view;

import java.util.Scanner;

import service.InputValueParser;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static InputValueParser inputInfo() {

        System.out.println("계산할 값을 입력하세요");

        String input = sc.nextLine();

        return new InputValueParser(input);
    }
}
