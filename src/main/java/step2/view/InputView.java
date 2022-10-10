package step2.view;

import java.util.Scanner;

public class InputView {

    public static int inputPrice(){
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }
}
