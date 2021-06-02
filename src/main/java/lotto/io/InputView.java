package lotto.io;

import lotto.domain.Lotto;
import lotto.util.SplitUtil;

import java.util.List;
import java.util.Scanner;

import static lotto.io.Message.REQUEST_PURCHASE_AMOUNT;
import static lotto.io.Message.REQUEST_WINNING_NUMBER;
import static lotto.io.OutputView.print;

public class InputView {

    private static final Scanner scan = new Scanner(System.in);

    public static int requestPurchaseAmount() {
        try {
            print(REQUEST_PURCHASE_AMOUNT);
            return Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            print(e.getMessage());
            return requestPurchaseAmount();
        }
    }

    public static Lotto requestWinningLotto() {
        print(REQUEST_WINNING_NUMBER);
        String input = scan.nextLine();
        try {
            List<Integer> numbers = SplitUtil.fromStringToList(input);
            return new Lotto(numbers);
        } catch (Exception e) {
            print(e.getMessage());
            return requestWinningLotto();
        }
    }


}