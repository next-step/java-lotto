package step4.view;

import step4.lotto.WinningNumbers;

import java.util.Scanner;

public class LottoInputView implements InputView {
    private static final String QUESTION_USE_MONEY = "구입금액을 입력해 주세요.";
    private static final String QUESTION_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner;

    public LottoInputView(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public int getUseAmount() {
        System.out.println(QUESTION_USE_MONEY);
        int insertedMoney = scanner.nextInt();
        scanner.nextLine();
        return insertedMoney;
    }

    @Override
    public WinningNumbers getWinningNumber() {

        System.out.println(QUESTION_LAST_WEEK_WINNING_NUMBER);
        String insertedWinningNumber = scanner.nextLine();

        System.out.println(QUESTION_BONUS_BALL);
        int bonusBall = scanner.nextInt();

        return WinningNumbers.of(insertedWinningNumber, bonusBall);
    }
}
