package lotto.ui;

import lotto.domain.rank.WinningLotto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String REQUEST_MONEY_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String REQUEST_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String REQUEST_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String COMMA = ",";

    private InputView() {
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

    public static List<List<Integer>> requestManualLottoNumbers() {
        int manualCount = requestManualCount();
        List<List<Integer>> lottoNumbersByManual = new ArrayList<>();
        System.out.println(REQUEST_MANUAL_NUMBER);
        for (int i = 0; i < manualCount; i++) {
            lottoNumbersByManual.add(requestManualNumbers());
        }
        return lottoNumbersByManual;
    }

    public static WinningLotto requestWinningLotto() {
        List<Integer> winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber();
        return WinningLotto.of(winningNumbers, bonusNumber);
    }

    private static int requestManualCount() {
        System.out.println(REQUEST_MANUAL_COUNT);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidNumberException();
        }
    }

    private static List<Integer> requestManualNumbers() {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(COMMA);
        return asList(split)
                .stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static List<Integer> requestWinningNumbers() {
        String[] inputValue = winningRequestMessage();
        return getWinningNumbers(inputValue);
    }

    private static int requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String[] winningRequestMessage() {
        System.out.println(REQUEST_WINNING_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(COMMA);
    }

    private static List<Integer> getWinningNumbers(String[] inputValue) {
        return asList(inputValue)
                .stream()
                .map(InputView::parseLottoNumber)
                .distinct()
                .collect(toList());
    }

    private static int parseLottoNumber(String lottoNumString) {
        try {
            return parseInt(lottoNumString.trim());
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

}
