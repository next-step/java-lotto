package step1.view;

import step1.domain.Numbers;
import step1.util.InputUtil;

import java.util.List;
import java.util.Scanner;


public class Input {

    private static Scanner scanner = new Scanner(System.in);

    private final String stringInput;

    public String getStringInput() {
        return stringInput;
    }

    public Input() {
        System.out.println("입력하세요");
        this.stringInput = scanner.nextLine();
    }
}
