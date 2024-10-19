package lottogame.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class LottoInputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {
    }

    public static int getBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return SCANNER.nextInt();
    }

    public static String getWinningNumbers() {
        newLineRemove();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return SCANNER.nextLine();
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return SCANNER.nextInt();
    }

    public static int getBuyManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");

        return SCANNER.nextInt();
    }

    public static List<String> getBuyManualLottoNumbers(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        newLineRemove();

        List<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottoNumbers.add(SCANNER.nextLine());
        }

        return manualLottoNumbers;
    }

    public static void newLineRemove() {
        SCANNER.nextLine();
    }

}

