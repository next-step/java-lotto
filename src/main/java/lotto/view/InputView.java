package lotto.view;

import java.util.Scanner;

public class InputView {

    public static int insertNumber() {
        return new Scanner(System.in).nextInt();
    }

    public static String insertValues() {
        return new Scanner(System.in).nextLine();
    }
}
