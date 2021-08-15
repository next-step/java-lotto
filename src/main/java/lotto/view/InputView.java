package lotto.view;

import lotto.model.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MSG);
        return scanner.nextInt();
    }

    public static LottoTicket readWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MSG);
        return convertToTicket();
    }

    private static LottoTicket convertToTicket() {
        try {
            String[] input = scanner.next().split(",");

            List<Integer> numbers = Arrays.stream(input)
                    .map(str -> str.trim())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new LottoTicket(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumber();
        }
    }

}
