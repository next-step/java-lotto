package lotto.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String getNumber(){
        return scanner.nextLine();
    }
}
