package lotto.ui;

import lotto.domian.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int questionOrder() {
        System.out.println("구입금액을 입력해 주세요.");
        int answer = Integer.parseInt(scanner.nextLine());
        return answer;
    }

    public static int questionManualOrder() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static List<String> questionLottoNumbers(int manualOrderCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualOrderCount; i++) {
            manualLottos.add(scanner.nextLine());
        }
        return manualLottos;
    }

    public static String questionWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String questionBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

}
