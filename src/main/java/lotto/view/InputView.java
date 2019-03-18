package lotto.view;

import lotto.LottoMachine;
import lotto.LottoTicket;

import java.util.List;
import java.util.Scanner;

public class InputView {


    public static int getStartLotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요");
        int amount = scanner.nextInt();
        System.out.println(amount / 1000 + "개를 구매했습니다.");
        return amount;
    }

    public static String winningNumbersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String s = scanner.nextLine();
        System.out.println(s);
        return s;
    }
}
