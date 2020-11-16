package step4.view;

import step4.domain.lotto.WinningNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInputView implements InputView {
    private static final String QUESTION_USE_MONEY = "구입금액을 입력해 주세요.";
    private static final String QUESTION_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String QUESTION_INPUT_MANUAL_TICKET_SIZE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ALERT_MANUAL_PROGRESS = "[%d / %d]";

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

    @Override
    public int getManualTicketSize() {
        System.out.println(QUESTION_INPUT_MANUAL_TICKET_SIZE);
        int nextInt = scanner.nextInt();
        clearScanner();
        return nextInt;
    }

    @Override
    public List<String> getManualNumbers(int manualSize) {
        if (!isValidSize(manualSize)) {
            return new ArrayList<>();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, manualSize)
                .mapToObj(index -> {
                    System.out.printf((ALERT_MANUAL_PROGRESS) + "%n", (index+1), manualSize);
                    return scanner.nextLine();
                })
                .collect(Collectors.toList());
    }

    private void clearScanner() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private boolean isValidSize(int manualSize) {
        return manualSize > 0;
    }
}
