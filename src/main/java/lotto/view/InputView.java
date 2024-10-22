package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_SPLIT_PATTERN_COMMA = ",";

    public static int getLottoPricePurchased() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getManualLottoQuantityPurchased() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getBonusBallFromUser() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String[] getLastWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(INPUT_SPLIT_PATTERN_COMMA);
    }

    public static List<String[]> getManualLottos(int manualLottoQuantityPurchased) {
        if (manualLottoQuantityPurchased == 0) {
            return Collections.emptyList();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        List<String[]> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoQuantityPurchased; i++) {
            manualLottos.add(scanner.nextLine().split(INPUT_SPLIT_PATTERN_COMMA));
        }

        return manualLottos;
    }
}
