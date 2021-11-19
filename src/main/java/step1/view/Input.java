package step1.view;

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
