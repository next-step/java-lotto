package calculator.string.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String inputView () {
        return scanner.nextLine();
    }


}
