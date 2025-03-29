package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.util.Price.LOTTO_PRICE;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        Amount price = new Amount(scanner.nextInt());
        scanner.nextLine();
        if (price.equals(new Amount(0))) {
            throw new IllegalArgumentException("구입금액은 " + LOTTO_PRICE.value() + "원 이상이어야 합니다.");
        }
        if (price.modulo(LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("구입금액은 " + LOTTO_PRICE.value() + "원 단위여야 합니다.");
        }
        return (int) price.divide(LOTTO_PRICE);
    }

    public static Lottos manualLottos(int totalLottoCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = scanner.nextInt();
        scanner.nextLine();
        if (count > totalLottoCount) {
            throw new IllegalArgumentException(totalLottoCount + "개 초과로 구매할 수 없습니다.");
        }
        return inputManualLottos(count);
    }

    private static Lottos inputManualLottos(int totalManualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<totalManualCount; i++) {
            lottos.add(Lotto.from(scanner.nextLine()));
        }
        return new Lottos(lottos);
    }

    public static Lotto winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Lotto.from(scanner.nextLine());
    }

    public static Number BonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = scanner.nextInt();
        scanner.nextLine();
        return new Number(number);
    }
}
