package view;

import java.util.Scanner;

import domain.InputValues;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static InputValues inputInfo() {

        System.out.println("계산할 값을 입력하세요");

        String[] input = sc.nextLine().split(" ");

        return new InputValues(input);
    }
}
