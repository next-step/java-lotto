package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_VALUE_OF_POSITIVE_NUMBER = 0;
    private static final String DELIMITER = ", |,";

    private InputView() {}

    public static Money inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Money purchaseAmount = new Money(inputPositiveNumber());
        if (purchaseAmount.isLessThan(Lotto.PRICE)) {
            throw new IllegalArgumentException(String.format("최소 %s 원을 입력해주세요.", Lotto.PRICE));
        }
        return purchaseAmount;
    }

    public static List<Lotto> inputPurchaseLottos(int limitNumberOfLottos) {
        int numberOfPurchaseLottos = inputNumberOfPurchaseLottos();
        if (numberOfPurchaseLottos > limitNumberOfLottos) {
            throw new IllegalArgumentException(String.format("최대 %d개 구매할 수 있습니다.", limitNumberOfLottos));
        }
        return inputLottos(numberOfPurchaseLottos);
    }

    private static int inputNumberOfPurchaseLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputPositiveNumber();
    }

    private static List<Lotto> inputLottos(int numberOfLottos) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(inputLotto());
        }
        return lottos;
    }

    public static WinningCondition inputWinningCondition() {
        Lotto winningLotto = InputView.inputWinningLotto();
        LottoNumber bonusLottoNumber = InputView.inputBonusLottoNumber();
        return new WinningCondition(winningLotto, bonusLottoNumber);
    }

    private static LottoNumber inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(inputPositiveNumber());
    }

    private static int inputPositiveNumber() {
        int number = Integer.parseInt(SCANNER.nextLine());
        if (number < MIN_VALUE_OF_POSITIVE_NUMBER) {
            throw new IllegalArgumentException("0 보다 작은 수를 입력할 수 없습니다.");
        }
        return number;
    }

    private static Lotto inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLotto();
    }

    private static Lotto inputLotto() {
        return Lotto.from(inputLottoNumbers());
    }

    private static List<Integer> inputLottoNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
