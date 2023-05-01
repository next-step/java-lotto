package lotto.auto.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String inputView (String startValue) {
        System.out.println(startValue);
        return scanner.nextLine();
    }


}
