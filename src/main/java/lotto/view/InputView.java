package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static long initLottoPrice() {
        System.out.println("구매금액을 입력해 주세요.");
        return Long.parseLong(SCANNER.nextLine());
    }

    public static String initWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int initBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int initManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = SCANNER.nextInt();
        SCANNER.nextLine();
        return count;
    }

    public static List<String> initManualList(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            result.add(SCANNER.nextLine());
        }
        return result;
    }
}
