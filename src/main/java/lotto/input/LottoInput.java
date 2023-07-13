package lotto.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {

    private static final String WINNING_DELIMITER = ", ";
    private final Scanner scanner;

    public LottoInput() {
        this.scanner = new Scanner(System.in);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumbers();
    }

    public Long inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputQuantity();
    }

    public int inputManualLottoQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputQuantity().intValue();
    }

    public List<Integer> inputManualLottoNumbers() {
        return inputLottoNumbers();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputQuantity().intValue();
    }

    private Long inputQuantity() {
        return Long.parseLong(scanner.nextLine());
    }

    private List<Integer> inputLottoNumbers() {
        return Arrays.stream(scanner.nextLine().split(WINNING_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
