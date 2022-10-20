package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Money;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> inputManualLotto(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(scanner.next()));
        }
        return manualLottos;
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(scanner.next());
    }

    public static LottoNumber inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(scanner.nextInt());
    }
}
