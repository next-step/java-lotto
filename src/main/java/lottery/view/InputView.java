package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lottery.domain.LotteryTicket;
import lottery.domain.PurchasePrice;

public class InputView {

    private static final Scanner STANDARD_INPUT_SCANNER = new Scanner(System.in);
    private static final String MESSAGE_PURCHASE_PRICE = "구매금액을 입력해 주세요.";
    private static final String MESSAGE_LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public static PurchasePrice getPurchasePrice() {
        System.out.println(MESSAGE_PURCHASE_PRICE);

        final String input = STANDARD_INPUT_SCANNER.nextLine();
        final int price = Integer.parseInt(input);
        return PurchasePrice.of(price);
    }

    public static LotteryTicket getWinningLottery() {
        System.out.println(MESSAGE_LAST_WEEK_WINNING_NUMBERS);

        final String input = STANDARD_INPUT_SCANNER.nextLine();
        final List<Integer> lotteryNumbers = Arrays.stream(input.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        return LotteryTicket.of(lotteryNumbers);
    }
}
