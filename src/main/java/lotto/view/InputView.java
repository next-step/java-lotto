package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static Money inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Money.from(SCANNER.nextInt());
    }

    public static Amount inputManualAmount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Amount.from(SCANNER.nextInt());
    }

    public static Lottos inputManualLottos(Amount manualAmount) {
        SCANNER.nextLine();
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        Lottos lottos = new Lottos();
        for (int i = 0; i < manualAmount.getAmount(); i++) {
            lottos.addLotto(Lotto.createManualLotto(getManualLottoNumbers()));
        }

        return lottos;
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 압력해주세요.");
        return Lotto.createManualLotto(getManualLottoNumbers());
    }

    public static List<String> getManualLottoNumbers() {
        return List.of(SCANNER.nextLine().split(DELIMITER));
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return LottoNumber.createManualLottoNumber(SCANNER.nextLine());
    }
}
