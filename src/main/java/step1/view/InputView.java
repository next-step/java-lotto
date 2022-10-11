package step1.view;

import java.util.Scanner;

public class InputView {

    public String getInputLine() {
        System.out.println("식을 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
