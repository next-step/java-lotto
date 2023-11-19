package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INFORMATION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INFORMATION_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BLANK = "";

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputPurchaseAmount() {
        System.out.println(INFORMATION_PURCHASE_AMOUNT);
        int purchaseAmount = checkAmount(SCANNER.nextInt());
        SCANNER.nextLine();
        return purchaseAmount;
    }

    private int checkAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("구매 금액은 1,000원 이상이여야 합니다.");
        }
        return amount;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(BLANK);
        System.out.println(INFORMATION_LAST_WINNING_NUMBER);
        return Arrays.stream(SCANNER.nextLine().split(", "))
                .mapToInt(x -> Integer.parseInt(x))
                .boxed()
                .collect(Collectors.toList());
    }
}
