package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액은 입력해 주세요.");
        return sc.nextInt();
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    public static List<String> inputManualLotto() {
        List<String> lottoList = new ArrayList<>();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualNumber = sc.nextInt();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        sc.nextLine();
        for (int i = 0; i < manualNumber; i++) {
            lottoList.add(sc.nextLine());
        }
        return lottoList;
    }
}
