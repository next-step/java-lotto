package lotto.view;

import java.util.Scanner;
import lotto.domain.LottoException;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MONEY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINING_LOTTO_NUMBERS_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static String getLottoPurchaseMoney() {
        print(MONEY_REQUEST_MESSAGE);
        return getUserInput();
    }

    public static String[] getWiningLottoNumbers() {
        print(WINING_LOTTO_NUMBERS_REQUEST_MESSAGE);
        return parseLottoNumbers(getUserInput());
    }

    private static void print(final String message) {
        System.out.println(message);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static String getUserInput() {
        final String result = SCANNER.nextLine().trim();
        printEmptyLine();
        return result;
    }

    private static String[] parseLottoNumbers(final String lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        return lottoNumbers.split(LOTTO_NUMBER_DELIMITER);
    }

    private static void validateLottoNumbers(final String lottoNumbers) {
        if (lottoNumbers == null) {
            throw new LottoException("Lotto numbers can not be null");
        }
        if (lottoNumbers.isEmpty()) {
            throw new LottoException("Lotto numbers can not be empty");
        }
    }
}
