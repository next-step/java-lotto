package lotto.view;

import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String GET_PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static String GET_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {

    }

    public static int getPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT_QUESTION);
        return scanner.nextInt();
    }

    public static Set<LottoNumber> getWinningNumber() {
        System.out.println(GET_WINNING_NUMBER_QUESTION);
        scanner.nextLine();
        String winningNumberString = scanner.nextLine();
        String trimWinningNumberString = winningNumberString.replace(" ","");
        return Arrays.stream(trimWinningNumberString.split(",|, | ,"))
                .map(number -> LottoNumber.of(Integer.parseInt(number)))
                .collect(Collectors.toSet());
    }
}
