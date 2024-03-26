package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public int getLottoPurchaseMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseMoneyInput = scanner.nextLine();

        try {
            return Integer.parseInt(purchaseMoneyInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("금액을 위해 숫자를 입력 해 주세요.");
        }
    }

    public int getLottoManualCountInput() {
        System.out.println("수동으로 구매할 로또 수를 입력하세요.");
        String lottoManualCountInput = scanner.nextLine();

        try {
            return Integer.parseInt(lottoManualCountInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("수량을 위한 숫자를 입력해주세요.");
        }
    }

    public List<List<Integer>> getLottoManual(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLotto = new ArrayList<>();

        for (int i = 0; i < manualCount; i++) {
            String manualLottoInput = scanner.nextLine();
            manualLotto.add(getLottoNumbersInput(manualLottoInput));
        }
        return manualLotto;
    }

    public List<Integer> getLastWeekWinningLottoNumbersInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lastWeekWinningLottoNumbers = scanner.nextLine();

        return getLottoNumbersInput(lastWeekWinningLottoNumbers);
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumberInput = scanner.nextLine();

        return Integer.parseInt(bonusNumberInput);
    }

    private List<Integer> getLottoNumbersInput(String lastWeekWinningLottoNumbers) {
        try {
            return Arrays.stream(lastWeekWinningLottoNumbers.split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("로또 번호를 위해 숫자를 입력 해 주세요.");
        }
    }
}
