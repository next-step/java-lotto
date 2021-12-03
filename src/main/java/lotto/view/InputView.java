package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.ResultLotto;
import lotto.domain.Wallet;

public class InputView {

    private static final String INPUT_NUMBER_OF_BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_RESULT_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_LOTTO_RESULT_NUMBERS_SPLIT_REGEX = ", ";

    private static final String BONUS_NUMBER_EXCEPTION_MESSAGE = "기존에 나왔던 번호는, 보너스볼이 될 수 없습니다.";

    private final Scanner sc = new Scanner(System.in);

    public static InputView create() {
        return new InputView();
    }

    public Wallet inputMoney() {
        System.out.println(INPUT_NUMBER_OF_BUY_PRICE_MESSAGE);

        return new Wallet(sc.nextInt());
    }

    public ResultLotto inputLottoResultNumber() {
        List<Integer> resultNumbers = inputResultLottoNumbers();

        int bonusNumber = inputLottoBonusNumber();

        validate(resultNumbers, bonusNumber);

        return new ResultLotto(
            new LottoTicket(resultNumbers),
            bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {

            throw new IllegalArgumentException(BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private List<Integer> inputResultLottoNumbers() {
        System.out.println(INPUT_LOTTO_RESULT_NUMBERS_MESSAGE);

        sc.nextLine();

        return Arrays.stream(
                sc.nextLine().split(INPUT_LOTTO_RESULT_NUMBERS_SPLIT_REGEX))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private int inputLottoBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

        return sc.nextInt();
    }
}
