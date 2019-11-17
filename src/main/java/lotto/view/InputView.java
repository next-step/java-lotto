package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return sc.nextInt();
    }

    public static int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return sc.nextInt();
    }

    public static List<String> getManualLotto(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> manualNumbers = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            manualNumbers.add(sc.nextLine());
        }

        return manualNumbers;
    }

    public static String getLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return sc.next();
    }

    public static int getBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return sc.nextInt();
    }
}
