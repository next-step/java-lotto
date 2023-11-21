package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String purchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String manualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<Lotto> manualLottos(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int count = 0; count < manualCount; count++) {
            manualLottos.add(new Lotto(scanner.nextLine()));
        }
        return manualLottos;
    }
}
