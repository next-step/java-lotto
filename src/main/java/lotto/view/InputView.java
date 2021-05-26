package lotto.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Long getBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(this.scanner.nextLine());
    }

    public String getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String textWinningNumber = this.scanner.nextLine();
        System.out.println("");
        return textWinningNumber;
    }
}
