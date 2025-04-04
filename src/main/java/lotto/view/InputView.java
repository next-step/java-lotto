package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputLotto(int count) {
        System.out.println("수동으로 구매할 번호를 입력해주세요");
        scanner.nextLine();
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            inputs.add(scanner.nextLine());
        }
        return inputs;
    }

    public static String inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
