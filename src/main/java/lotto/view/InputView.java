package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS_INPUT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String SPLITTER = ", ";
    private static final Scanner SCANNER = new Scanner(System.in);

    public int requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_INPUT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public List<Integer> requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_INPUT);
        return Arrays.stream(SCANNER.nextLine().split(SPLITTER)).map(Integer::parseInt).collect(Collectors.toList());
    }
}
