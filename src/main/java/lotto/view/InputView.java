package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static Money inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Money.init(SCANNER.nextInt());
    }

    public static Lotto inputWinningNumbers() {
        SCANNER.nextLine();
        System.out.println("지난 주 당첨 번호를 압력해주세요.");
        return Lotto.initWinningLotto(List.of(SCANNER.nextLine().split(DELIMITER)));
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return LottoNumber.createManualLottoNumber(SCANNER.nextLine());
    }
}
