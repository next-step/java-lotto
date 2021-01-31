package lotto.view;

import lotto.Count;
import lotto.Money;

import java.util.Scanner;

public class InputView {
    private final InputString AMOUNT_MSG = new InputString("구입금액을 입력해 주세요.");
    private final InputString LOTTO_NUMBERS_MSG = new InputString("지난 주 당첨 번호를 입력해 주세요.");
    private final InputString BONUS_NUMBER_MSG = new InputString("보너스 볼을 입력해 주세요");
    private static Scanner scanner = new Scanner(System.in);

    public static Money inputAmount() {
//        System.out.println(AMOUNT_MSG);
        int amount = scanner.nextInt();
        return new Money(amount);
    }

    public static String inputLottoNumbers() {
//        System.out.println(LOTTO_NUMBERS_MSG);
        return scanner.nextLine();
    }

    public static Integer inputBonusNumber() {
//        System.out.println(BONUS_NUMBER_MSG);
        return scanner.nextInt();
    }


}
