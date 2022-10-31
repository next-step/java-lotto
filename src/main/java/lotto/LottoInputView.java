package lotto;

import java.util.Scanner;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getTicketPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
