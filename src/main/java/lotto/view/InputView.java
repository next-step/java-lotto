package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static Long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Long money = sc.nextLong();
        sc.nextLine();
        return money;
    }

    public static Long inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Long manualLottoCount = sc.nextLong();
        sc.nextLine();
        System.out.println();
        return manualLottoCount;
    }
    public static List<String> inputManualLotto(Long manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList<>();
        for(int i = 0; i < manualCount; i++) {
            manualLottos.add(sc.nextLine());
        }
        System.out.println();
        return manualLottos;
    }
    public static String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }
    public static int inputBounsNumber() {
        System.out.println("보너스 볼을 입력해 주세요");
        return sc.nextInt();
    }
}
