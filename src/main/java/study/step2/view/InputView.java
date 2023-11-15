package study.step2.view;

import java.util.Scanner;

import study.step2.domain.dto.PurchaseAmount;
import study.step2.domain.dto.WinningNumbers;

import static study.step2.view.InputParser.parse;

public class InputView {

    public static PurchaseAmount inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchaseAmount(scanner.nextInt());
    }

    public static WinningNumbers inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningNumbers(parse(scanner.nextLine()));
    }
}
