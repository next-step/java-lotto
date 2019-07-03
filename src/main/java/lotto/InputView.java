package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    static int inputLotteGames() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    static int inputManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력 해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    static List<String> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList <>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(scanner.nextLine());
        }
        return manualLottos;
    }

    static String inputLastWeekLottoNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputLastWeekBonusNumber() {
        System.out.println("\n지난 주 보너스 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
