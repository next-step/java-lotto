package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.service.LottoGame.checkWinningNumbers;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    private InputView(){
        //
    }

    public static int getPurchaseAmount() {
        System.out.println(QUESTION_PURCHASE_AMOUNT);
        int price = scanner.nextInt();
        return price;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(QUESTION_WINNING_NUMBERS);
        String price = scanner.next();
        System.out.println();
        List<String> stringNumbers = List.of(price.split(DELIMITER));

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : stringNumbers) {
            winningNumbers.add(Integer.valueOf(number.trim()));
        }

        checkWinningNumbers(winningNumbers);

        return winningNumbers;
    }
}
