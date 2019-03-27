package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.WinningLotto;
import lotto.tool.LottoMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static LottoMoney inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoMoney(scanner.nextInt());
    }

    public static WinningLotto inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumbers = splitManualInput(scanner);

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.next();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public static List<String[]> inputManualLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualInputCount = LottoMachine.toInt(scanner.nextLine());

        if (manualInputCount == LottoMachine.LOTTO_MANUAL_DEFAULT_COUNT) {
            return new ArrayList<>();
        }

        List<String[]> manualLottoNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualInputCount; i++) {
            manualLottoNumbers.add(splitManualInput(scanner));
        }
        return manualLottoNumbers;
    }

    private static String[] splitManualInput(Scanner scanner) {
        return scanner.nextLine().split(",");
    }
}
