package lottoauto.view;

import lottoauto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    private InputView() {}

    public static int inputPurchaseAmount() {
        System.out.println("구매금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static int inputTheNumberOfManualLottos() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public static List<Lotto> inputManualLottos(int theNumberOfManualLottos) {
        sc.nextLine();
        List<Lotto> manualLottos = new ArrayList<>();
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        while (theNumberOfManualLottos-- > 0) {
            manualLottos.add(Lotto.from(sc.nextLine()));
        }
        return manualLottos;
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
