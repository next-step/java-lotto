package lotto.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static lotto.domain.Constant.*;

public class InputView {
    private static final String REQUEST_MONEY_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String COMMA = ",";

    public InputView() {
    }

    public static int requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new OnlyNumberViolateException();
        }
    }

    public static List<Integer> requestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        Scanner scanner = new Scanner(System.in);
        String[] inputValue = scanner.nextLine().split(COMMA);

        List<Integer> winningNumber = getWinningNumber(inputValue);
        if (winningNumber.size() != LOTTO_NUM_COUNT_LIMIT) {
            throw new InvalidWinningNumberException();
        }
        return winningNumber;
    }

    private static List<Integer> getWinningNumber(String[] inputValue) {
        return asList(inputValue).stream()
                .map(InputView::parseIntForLottoNum)
                .distinct()
                .collect(toList());
    }

    private static int parseIntForLottoNum(String lottoNumString) {
        int lottoNumber = parseLottoNumber(lottoNumString);
        return validateRange(lottoNumber);
    }

    private static int parseLottoNumber(String lottoNumString) {
        try {
            return Integer.parseInt(lottoNumString);
        } catch (NumberFormatException e) {
            throw new OnlyNumberViolateException();
        }
    }

    private static int validateRange(int lottoNumber) {
        if (LOTTO_NUM_MIN <= lottoNumber && lottoNumber <= LOTTO_NUM_MAX) {
            return lottoNumber;
        }
        System.out.println(lottoNumber);
        throw new OutOfRangeException();
    }
}
