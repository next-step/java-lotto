package lotto.io;

import lotto.domain.Lotto;
import lotto.util.SplitUtil;

import java.util.List;
import java.util.Scanner;

import static lotto.io.Message.REQUEST_PURCHASE_AMOUNT;
import static lotto.io.OutputView.print;

public class InputView {

    private static final Scanner scan = new Scanner(System.in);

    public static int requestPurchaseAmount() {
        try {
            print(REQUEST_PURCHASE_AMOUNT);
            return scan.nextInt();
        } catch (Exception e) {
            print(e.getMessage());
            return requestPurchaseAmount();
        }
    }

    public static Lotto requestWinningLotto() {
        String input = scan.next();
        try {
            List<Integer> numbers = SplitUtil.fromStringToList(input);
            return new Lotto(numbers);
        } catch (Exception e) {
            print(e.getMessage());
            return requestWinningLotto();
        }
    }


}