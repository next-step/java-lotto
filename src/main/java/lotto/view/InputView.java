package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.view.exceptions.InvalidInputException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private InputView() {
    }

    private static final String INPUT_MONEY = "구입급액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_COUNT_OF_MANUAL_NUM = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LOTTO_NUM_DELIMITER = ", ";
    private static final String INVALID_INPUT_FORMAT = "입력 포맷이 유효하지 않습니다. ex) [1, 2, 3, 4, 5, 6]";
    private static final String INVALID_POSITIVE_NUMBER = "양수만 입력 가능합니다.";
    private static final String INVALID_NUMBER = "숫자를 입력해 주세요";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return inputPositiveNumber();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return inputPositiveNumber();
    }

    public static LottoNumbers inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);

        try {
            String inputWinningNumbers = scanner.nextLine();
            List<Integer> winningNumbers = Stream.of(inputWinningNumbers.split(LOTTO_NUM_DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return LottoNumbers.valueOf(winningNumbers);
        } catch (InputMismatchException | IllegalArgumentException e) {
            throw new InvalidInputException(INVALID_INPUT_FORMAT, e);
        }
    }

    public static int inputCountOfManualLottoNumber() {
        System.out.println(INPUT_COUNT_OF_MANUAL_NUM);
        return inputPositiveNumber();
    }

    public static LottoTicket inputManualLottoTicket(int manualCount) {
        System.out.println(INPUT_MANUAL_NUMBERS);
        LottoTicket lottoTicket = new LottoTicket();
        try {
            for (int i = 0; i < manualCount ; i++) {
                String input = scanner.nextLine();
                LottoNumbers lottoNumbers = LottoNumbers.valueOf(input.split(LOTTO_NUM_DELIMITER));
                lottoTicket.add(lottoNumbers);
            }

            return lottoTicket;
        } catch (InputMismatchException | IllegalArgumentException e) {
            throw new InvalidInputException(INVALID_INPUT_FORMAT, e);
        }
    }

    private static int inputPositiveNumber() {
        int positiveNumber = inputInt();
        if (positiveNumber <= 0) {
            throw new InvalidInputException(INVALID_POSITIVE_NUMBER);
        }
        return positiveNumber;
    }

    private static int inputInt() {
        try {
            int value = scanner.nextInt();
            clearInputBuffer();
            return value;
        } catch (InputMismatchException e) {
            clearInputBuffer();
            throw new InvalidInputException(INVALID_NUMBER, e);
        }
    }

    private static void clearInputBuffer() {
        scanner.nextLine();
    }
}
