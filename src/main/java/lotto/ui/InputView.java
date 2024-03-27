package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int purchaseAmount() {
        System.out.println("구매금액을 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] splitNumber = scanner.nextLine().split(",");
        return Arrays.stream(splitNumber)
            .map(number -> Integer.parseInt(number.trim()))
            .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
