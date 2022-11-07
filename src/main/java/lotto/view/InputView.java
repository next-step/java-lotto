package lotto.view;

import lotto.lotto.LottoMoney;
import lotto.lotto.LottoWinNumbers;

import java.util.Scanner;

public class InputView {
    public static LottoMoney inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(System.lineSeparator() + "구입금액을 입력해 주세요.");
        return new LottoMoney(Integer.parseInt(scanner.nextLine()));
    }

    public static LottoWinNumbers inputWinNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        return LottoWinNumbers.of(scanner.nextLine());
    }
}
