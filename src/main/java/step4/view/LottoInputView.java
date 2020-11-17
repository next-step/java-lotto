package step4.view;

import step4.domain.lotto.WinningNumbers;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;
import step4.domain.lotto.firstcollection.MarkingNumbers;
import step4.exception.DuplicateNumberException;
import step4.exception.InvalidMarkingNumberException;
import step4.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step4.Constant.*;

public class LottoInputView implements InputView {
    private static final String QUESTION_USE_MONEY = "구입금액을 입력해 주세요.";
    private static final String QUESTION_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String QUESTION_INPUT_MANUAL_TICKET_SIZE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ALERT_MANUAL_PROGRESS = "[%d / %d]";
    public static final String QUESTION_INPUT_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private final Scanner scanner;

    public LottoInputView(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public int getUseAmount() {
        try {
            return tryGetUseAmount();
        } catch (NumberFormatException error) {
            System.out.println(ERROR_NOT_NUMERIC);
            return getUseAmount();
        } catch (NotEnoughMoneyException error) {
            System.out.println(error.getMessage());
            return getUseAmount();
        }
    }

    private int tryGetUseAmount() {
        System.out.println(QUESTION_USE_MONEY);
        int insertedMoney = Integer.parseInt(scanner.nextLine());

        if (insertedMoney < LOTTO_PRICE) {
            throw new NotEnoughMoneyException(ERROR_LOTTO_MINIMUM_PRICE);
        }

        return insertedMoney;
    }

    @Override
    public WinningNumbers getWinningNumbers() {
        String winningNumbers = getMarkingNumbers();
        int bonusBall = getBonusBall(winningNumbers);

        return WinningNumbers.of(winningNumbers, bonusBall);
    }

    private String getMarkingNumbers() {
        try {
            return tryGetMarkingNumbers();
        } catch (IllegalArgumentException | InvalidMarkingNumberException error) {
            System.out.println(error.getMessage());
            return getMarkingNumbers();
        }
    }

    private String tryGetMarkingNumbers() {
        System.out.println(QUESTION_LAST_WEEK_WINNING_NUMBER);
        String numbers = scanner.nextLine();
        MarkingNumbers.isValid(numbers);
        return numbers;
    }

    private int getBonusBall(String winningNumbers) {
        try {
            return tryGetBonusBall(winningNumbers);
        } catch (NumberFormatException error) {
            System.out.println(ERROR_NOT_NUMERIC);
            return getBonusBall(winningNumbers);
        } catch (DuplicateNumberException error) {
            System.out.println(error.getMessage());
            return getBonusBall(winningNumbers);
        }
    }

    private int tryGetBonusBall(String winningNumbers) {
        System.out.println(QUESTION_BONUS_BALL);
        String bonusBall = scanner.nextLine();
        if (winningNumbers.contains(bonusBall)) {
            throw new DuplicateNumberException(ERROR_DUPLICATE_NUMBER);
        }

        return Integer.parseInt(bonusBall);
    }


    @Override
    public int getManualTicketSize(int useAmount) {
        try {
            return tryGetManualTicketSize(useAmount);
        } catch (NotEnoughMoneyException error) {
            System.out.println(error.getMessage());
            return getManualTicketSize(useAmount);
        } catch (NumberFormatException error) {
            System.out.println(ERROR_NOT_NUMERIC);
            return getManualTicketSize(useAmount);
        }
    }

    private int tryGetManualTicketSize(int useAmount) {
        System.out.println(QUESTION_INPUT_MANUAL_TICKET_SIZE);
        int manualTicketSize = Integer.parseInt(scanner.nextLine());

        if (useAmount < manualTicketSize * LOTTO_PRICE) {
            throw new NotEnoughMoneyException(ERROR_NOT_ENOUGH_MONEY);
        }
        return manualTicketSize;
    }


    @Override
    public List<String> getManualNumbers(int manualSize) {
        if (!isValidSize(manualSize)) {
            return Collections.emptyList();
        }
        try {
            System.out.println(QUESTION_INPUT_MANUAL_NUMBER);

            return tryGetManualNumbers(manualSize);
        } catch (InvalidMarkingNumberException | NumberFormatException error) {
            System.out.println(error.getMessage());
            return getManualNumbers(manualSize);
        }

    }

    private List<String> tryGetManualNumbers(int manualSize) {
        return IntStream.range(0, manualSize)
                .mapToObj(index -> {
                    System.out.printf((ALERT_MANUAL_PROGRESS) + "%n", (index + 1), manualSize);

                    String string = scanner.nextLine();
                    MarkingNumbers.isValid(string);

                    return string;
                })
                .collect(Collectors.toList());
    }

    private boolean isValidSize(int manualSize) {
        return manualSize > 0;
    }

    @Override
    public LottoPurchaseInfoDTO getPurchaseInfo() {
        int useAmount = getUseAmount();
        int manualSize = getManualTicketSize(useAmount);
        List<String> manualNumbers = getManualNumbers(manualSize);

        return new LottoPurchaseInfoDTO.Builder(useAmount)
                .inputManualNumbers(manualNumbers)
                .manualSize(manualSize)
                .build();
    }
}
