package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void printInputBuyAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static Money inputBuyAmount() {
        printInputBuyAmount();
        return new Money(Long.parseLong(SCANNER.nextLine()));
    }

    public static String inputWinningNumbers() {
        printInputWinningNumbers();
        return SCANNER.nextLine();
    }

    public static LottoNumber inputBonusNumber() {
        printInputBonusNumber();
        return new LottoNumber(Integer.parseInt(SCANNER.nextLine()));
    }

    private static void printInputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }
}
