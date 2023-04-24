package lotto.View;

import lotto.Model.Count;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int payment() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = SCANNER.nextLine();

        try {
            Count countOfTicket = new Count(Integer.parseInt(amount));
            return countOfTicket.value();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return payment();
        }
    }
}
