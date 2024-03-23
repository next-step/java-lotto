package lotto.view;

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

    public List<Integer> getLastWeekWinningLottoNumbersInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lastWeekWinningLottoNumbers = scanner.nextLine();

        try {
            return Arrays.stream(lastWeekWinningLottoNumbers.split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("로또 번호를 위해 숫자를 입력 해 주세요.");
        }
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumberInput = scanner.nextLine();

        return Integer.parseInt(bonusNumberInput);
    }
}
