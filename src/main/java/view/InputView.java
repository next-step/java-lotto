package view;

import java.util.Scanner;

import domain.InputValues;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public InputValues inputInfo(InputValidation inputValidation) {

        System.out.println("계산할 값을 입력하세요");

        String[] input = sc.nextLine().split(" ");
        inputValidation.validationInputValues(input);

        return new InputValues(input);
    }
}
