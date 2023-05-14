package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void printInputBuyAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static Money inputBuyAmount() {
        printInputBuyAmount();
        return new Money(Long.parseLong(SCANNER.nextLine()));
    }

    public static String inputWinningNumbers() {
        printInputWinningNumbers();
        return SCANNER.nextLine();
    }

    public static LottoNumber inputBonusNumber() {
        printInputBonusNumber();
        return new LottoNumber(Integer.parseInt(SCANNER.nextLine()));
    }

    private static void printInputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static long inputManualCount() {
        printInputManualCount();
        return Long.parseLong(SCANNER.nextLine());
    }

    private static void printInputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static Lottos inputManualLottos(long manualCount) {
        printInputManualLottos();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            lottos.add(LottoGenerator.generate(SCANNER.nextLine()));
        }
        return new Lottos(lottos);
    }

    private static void printInputManualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }
}
