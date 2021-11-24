package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.LottoTicket;
import lotto.ResultLotto;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    private static final String INPUT_NUMBER_OF_BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_RESULT_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_RESULT_NUMBERS_SPLIT_REGEX = ", ";

    public static InputView create() {
        return new InputView();
    }

    public int inputMoney() {
        System.out.println(INPUT_NUMBER_OF_BUY_PRICE_MESSAGE);

        return sc.nextInt();
    }

    public ResultLotto inputLottoResultNumber() {
        System.out.println(INPUT_LOTTO_RESULT_NUMBERS_MESSAGE);

        sc.nextLine();

        return new ResultLotto(
            new LottoTicket(
                Arrays.stream(
                        sc.nextLine().split(INPUT_LOTTO_RESULT_NUMBERS_SPLIT_REGEX))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())));
    }
}
