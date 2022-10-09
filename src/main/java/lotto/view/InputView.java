package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

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

    public static LottoNumber inputBonusLottoNumber(Lotto winningLotto) {
        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNumber bonusLottoNumber = new LottoNumber(inputNumber());
        if (winningLotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("당첨 번호에 포함된 번호를 입력할 수 없습니다.");
        }
        return bonusLottoNumber;
    }

    private static int inputNumber() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static Lotto inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Lotto.from(inputWinningLottoNumbers());
    }

    private static List<Integer> inputWinningLottoNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
