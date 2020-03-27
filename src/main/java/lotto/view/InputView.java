package lotto.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String REQUEST_MONEY_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String ONLY_NUMBER_MESSAGE = "금액은 숫자만 입력할 수 있습니다.";

    public InputView() {
    }

    public static int requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    public static List<Integer> requestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        Scanner scanner = new Scanner(System.in);
        String[] inputValue = scanner.nextLine().split(",");

        List<Integer> winningNumber = asList(inputValue).stream()
                .map(InputView::parseIntForLottoNum)
                .distinct()
                .collect(toList());

        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("당첨번호가 올바르지 않습니다.");
        }
        return new ArrayList<>(winningNumber);
    }

    private static int parseIntForLottoNum(String lottoNumString) {
        int lottoNumber;
        try {
            lottoNumber = Integer.parseInt(lottoNumString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (1 <= lottoNumber && lottoNumber <= 45) {
            return lottoNumber;
        }
        throw new IllegalArgumentException("당첨 번호는 1~45 까지 입력할 수 있습니다.");
    }
}
