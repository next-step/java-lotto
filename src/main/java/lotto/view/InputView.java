package lotto.view;

import lotto.domain.ManualLottoOrderSheet;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String LOTTO_NUMBER_SPLIT_KEYWORD = ",";
    private Scanner scanner = new Scanner(System.in);

    public Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public int inputPurchaseManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public ManualLottoOrderSheet inputManualLottoNumbers(int purchaseManualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<int[]> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseManualCount; i++) {
            int[] inputs = Arrays.stream(scanner.next().split(LOTTO_NUMBER_SPLIT_KEYWORD)).mapToInt(Integer::parseInt).toArray();
            manualLottoNumbers.add(inputs);
        }
        return new ManualLottoOrderSheet(manualLottoNumbers);
    }

    public WinningLotto inputWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        int[] winningNumbers = Arrays.stream(scanner.next().split(LOTTO_NUMBER_SPLIT_KEYWORD)).mapToInt(Integer::parseInt).toArray();
        int bonusNumber = inputBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
