package lotto.step2.view;

import lotto.step2.domain.Validation;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_LOTTO_PRICE_MESSAGE = "구입금액을 입력해주세요";
    private static final String INPUT_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요";
    private static final Scanner sc = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println(INPUT_LOTTO_PRICE_MESSAGE);

        return sc.nextInt();
    }

    public static List<Integer> inputLastWinningNumber() {
        System.out.println(INPUT_LAST_WINNING_NUMBER);
        sc.nextLine();
        String lastWinningNumbers = sc.nextLine();
        List<Integer> winningNumbers = Validation.isCorrectLottoNumbers(lastWinningNumbers);
        return winningNumbers;
    }
}
