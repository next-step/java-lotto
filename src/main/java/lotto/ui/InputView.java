package lotto.ui;

import lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String QUERY_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String QUERY_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_SEPARATOR = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int queryPurchasePrice() {
        System.out.println(QUERY_PURCHASE_PRICE_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> queryWinningNumbers() {
        System.out.println(QUERY_WINNING_NUMBERS_MESSAGE);
        return Arrays.stream(scanner.nextLine().split(WINNING_NUMBERS_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
