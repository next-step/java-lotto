package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputs = scanner.nextLine();
        return Arrays.stream(inputs.split(",")).map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public List<List<Integer>> inputManualLottoNumber(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String inputs = scanner.nextLine();
            List<Integer> numbers = Arrays.stream(inputs.split(",")).map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            manualLottoNumbers.add(numbers);
        }
        return manualLottoNumbers;
    }
}
