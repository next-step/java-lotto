package lotto.view;

import java.util.Scanner;

import lotto.model.WinningNumber;

public class WinningNumberInputView {
    public static WinningNumber getWinningNumber(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return WinningNumber.from(scanner.nextLine());
    }
}
