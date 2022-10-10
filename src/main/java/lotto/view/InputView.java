package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningCondition;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ", ";

    private InputView() {}

    public static Money inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(inputNumber());
    }

    public static WinningCondition inputWinningCondition() {
        Lotto winningLotto = InputView.inputWinningLotto();
        LottoNumber bonusLottoNumber = InputView.inputBonusLottoNumber(winningLotto);
        return new WinningCondition(winningLotto, bonusLottoNumber);
    }

    private static LottoNumber inputBonusLottoNumber(Lotto winningLotto) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(inputNumber());
    }

    private static int inputNumber() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static Lotto inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Lotto.from(inputWinningLottoNumbers());
    }

    private static List<Integer> inputWinningLottoNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
