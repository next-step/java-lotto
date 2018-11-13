package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        return amount;
    }

    public static String inputLastWeeksWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNumbers = scanner.nextLine();
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int bonus = scanner.nextInt();
        return bonus;
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int manualLottoCount = scanner.nextInt();
        return manualLottoCount;
    }

    public static List<String> inputManualLottoNumbers(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<String> lottoNumbers = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            String lotto = scanner.nextLine();
            lottoNumbers.add(lotto);
        }

        return lottoNumbers;
    }
}
