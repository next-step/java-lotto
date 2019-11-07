package lotto.view;

import lotto.domain.LottoNumberStrategy;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-07 00:25
 */
public class LottoInputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해주세요.";

    public static final int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);

        final String amount = scanner.nextLine();
        if (!LottoNumberStrategy.isNumber(amount)) {
            throw new InputMismatchException("숫자만 입력 가능합니다.");
        }

        return Integer.parseInt(amount);
    }

    public static final List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);

        final String winningNumber = scanner.nextLine();
        LottoNumberStrategy.checkLottoNumber(winningNumber);

        return Arrays.stream(winningNumber.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
