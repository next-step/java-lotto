package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinnerNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.LottoApplication.LOTTO_AMOUNT;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);


    public static final int getAutoAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        int amount = SCANNER.nextInt();
        if (amount < LOTTO_AMOUNT) {
            throw new IllegalArgumentException("구매금액이 1000원 미만입니다.");
        }

        return amount;
    }

    public static final int getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static final void printManualCommand() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void removeEnter() {
        SCANNER.nextLine();
    }

    public static final LottoNumbers getManualLottoNumbers() {
        return new LottoNumbers(
                Arrays.stream(SCANNER.nextLine().split(",\\s*"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

    public static final WinnerNumbers inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        LottoNumbers lottoNumbers =
                new LottoNumbers(Arrays.stream(SCANNER.nextLine().split(",\\s*"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));

        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = SCANNER.nextInt();

        return new WinnerNumbers(lottoNumbers, LottoNumber.valueOf(bonusNumber));
    }

    private InputView() {
    }
}
