package lotto.step2.view;

import java.util.Scanner;

public class InputView {
    private final static String MESSAGE_PURCHASING_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private final static String MESSAGE_LOTTO_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String MESSAGE_LOTTO_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private final static String ILLEGAL_LOTTO = "로또는 6개의 서로 다른 숫자로 만들어져야 합니다";
    private final static String DELIMITER_COMMA = ",";
    private final static int LOTTO_SIZE = 6;
    private final static Scanner scanner = new Scanner(System.in);


    private InputView() {
    }

    public static String enterPurchasingAmount() {
        System.out.println(MESSAGE_PURCHASING_AMOUNT);
        return scanner.next();
    }

    public static String[] enterWinningNumbers() {
        System.out.println(MESSAGE_WINNING_NUMBER);
        scanner.nextLine();
        return scanner.nextLine().trim().split(DELIMITER_COMMA);
    }

    public static String enterBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);
        return scanner.nextLine().trim();
    }

    public static String enterLottoManualCount() {
        System.out.println(MESSAGE_LOTTO_MANUAL_COUNT);
        return scanner.nextLine().trim();
    }

    public static String[] enterLottoManualNumbers() {
        System.out.println(MESSAGE_LOTTO_MANUAL_NUMBERS);
        String[] lottoNumbers = scanner.nextLine().trim().split(DELIMITER_COMMA);
        validateLottoSize(lottoNumbers);
        return lottoNumbers;
    }

    private static void validateLottoSize(String[] lottoNumbers) {
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO);
        }
    }

}
