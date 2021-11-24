package lotto.view;

import java.util.Scanner;

public class InsertView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String printInputIntro() {
        System.out.println("구매금액을 입력해 주세요");

        return scanner.nextLine();
    }

}
