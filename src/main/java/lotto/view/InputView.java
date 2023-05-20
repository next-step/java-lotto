package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }
    public static List<String> inputManualLottoNumbers(int lottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(scanner.nextLine());
        }
        return lottoNumbers;
    }

    public static String inputWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
