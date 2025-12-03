package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getInputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Lotto> getInputManualLottos(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(parse(scanner.nextLine())));
        }

        return manualLottos;
    }

    public static String[] getInputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return parse(scanner.nextLine());
    }

    public static int getInputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String[] parse(String s) {
        String[] strs = s.split(",");

        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].trim();
        }

        return strs;
    }
}
