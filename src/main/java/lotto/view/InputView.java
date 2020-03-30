package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningTicketRangeException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static lotto.domain.Constant.LOTTO_NUM_COUNT_LIMIT;

public class InputView {
    private static final String REQUEST_MONEY_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String COMMA = ",";

    public InputView() {
    }

    public static int requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidMoneyException();
        }
    }

    public static LottoNumbers requestWinningNumbers() {
        String[] inputValue = initMessage(REQUEST_WINNING_NUMBER);
        List<LottoNumber> winningNumbers = getWinningNumbers(inputValue);
        if (winningNumbers.size() != LOTTO_NUM_COUNT_LIMIT) {
            throw new WinningTicketRangeException("당첨 번호는 6개의 숫자만 입력할 수 있습니다.");
        }
        return new LottoNumbers(winningNumbers);
    }

    public static int requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String[] initMessage(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(COMMA);
    }

    private static List<LottoNumber> getWinningNumbers(String[] inputValue) {
        return asList(inputValue)
                .stream()
                .map(InputView::parseLottoNumber)
                .distinct()
                .collect(Collectors.toList());
    }

    private static LottoNumber parseLottoNumber(String lottoNumString) {
        try {
            return new LottoNumber(parseInt(lottoNumString));
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

}
