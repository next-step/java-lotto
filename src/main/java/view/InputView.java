package view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String scanInput() {
        System.out.println("식을 입력하세요 : ");
        return scanner.nextLine();
    }
}
