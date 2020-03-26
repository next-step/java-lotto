package view;

import java.util.Scanner;

public class InputView {

    public InputView() {
    }

    public static String askQuestion(){
        System.out.println("입력 : ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
