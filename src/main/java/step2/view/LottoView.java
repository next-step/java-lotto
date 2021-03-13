package step2.view;

import java.util.Scanner;

public class LottoView {

    private final Scanner scanner;

    public LottoView(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public int paymentMoney() {
        System.out.println("구입금액을 입력해 주세요.\n");
        return scanner.nextInt();
    }
}
