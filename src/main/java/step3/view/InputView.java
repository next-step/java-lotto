package step3.view;


import step3.domain.lotto.BonusLottoNumber;
import step3.domain.lotto.Lotto;
import step3.domain.money.Money;

import java.util.Objects;
import java.util.Scanner;

public final class InputView {

    private final Scanner scanner;
    private static InputView instance;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static final InputView getInstance() {
        if (Objects.isNull(instance)) {
            instance = new InputView();
        }
        return instance;
    }

    private final int inputMoneyByClient() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }

    private final String inputLottoNumbersByClient() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    private final int inputBonusLottoNumbersByClient() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public final Money getMoneyByClient() {
        return Money.valueOf(inputMoneyByClient());
    }

    public final Lotto getWinningLottoByClient() {
        return Lotto.of(inputLottoNumbersByClient());
    }

    public final BonusLottoNumber getBonusLottoByClient() {
        return BonusLottoNumber.valueOf(inputBonusLottoNumbersByClient());
    }

}
