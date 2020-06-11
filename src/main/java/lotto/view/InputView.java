package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int buyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }

    public static int buyManualLotto(int lottoCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = 0;
        try {
            manualLottoCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
        if (manualLottoCount > lottoCount) {
            throw new ArithmeticException("돈이 부족합니다.");
        }
        return manualLottoCount;
    }

    public static List<String> inputManualNumbers(int number) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoNumbers = new ArrayList<>();
        for (int idx = 0; idx < number; idx++) {
            lottoNumbers.add(scanner.nextLine());
        }
        return lottoNumbers;
    }

    public static String[] inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().split(", ");
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }
}
