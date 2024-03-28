package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SEPARATOR = ", ";

    Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public List<Integer> inputLottoNumber() {
        return Arrays.stream(scanner.nextLine()
                        .split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

    public int inputManualLottoCount() {
        int manualLottoCount = scanner.nextInt();
        scanner.nextLine();
        return manualLottoCount;
    }
}

