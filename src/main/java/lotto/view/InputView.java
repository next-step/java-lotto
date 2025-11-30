package lotto.view;

import lotto.model.*;

import java.util.*;

public class InputView {
    public static Money readPurchaseAmountInput() {
        Scanner scanner = new Scanner(System.in);
        print("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public static Count readManualLottoCountInput() {
        Scanner scanner = new Scanner(System.in);
        print("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Count(scanner.nextInt());
    }

    public static List<String> readMaualLottoInput(int manualLottoCount) {
        Scanner scanner = new Scanner(System.in);
        print("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottos = new ArrayList<>();
        for(int i = 0; i < manualLottoCount; i++) {
            lottos.add(readLotto(scanner));
        }
        return lottos;
    }

    private static String readLotto(Scanner scanner) {
        return scanner.nextLine();
    }

    public static String readWinningLottoInput() {
        Scanner scanner = new Scanner(System.in);
        print("지난 주 당첨 번호를 입력해 주세요.");
        return readLotto(scanner);
    }

    public static int readBonusNumberInput() {
        Scanner scanner = new Scanner(System.in);
        print("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
