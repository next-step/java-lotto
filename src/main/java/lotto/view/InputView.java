package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {


    public static int getAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public static String winningNumbersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String s = scanner.nextLine();
        System.out.println(s);
        return s;
    }
}
