package lotto.view;

import lotto.util.InputUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);


    public BigDecimal readMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return InputUtil.readMoney(readInput());
    }

    public List<Integer> readLottoNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return InputUtil.readLottoNumbers(readInput());
    }

    public Integer readBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return InputUtil.readBonusNumber(readInput());
    }

    private static String readInput() {
        return scanner.nextLine();
    }
}
