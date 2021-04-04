package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(scanner.nextLine());
        return price;
    }

    public static Set<Integer> inputPrizeLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] prizeNumbers = scanner.nextLine().split(",");
        return Arrays.stream(prizeNumbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toSet());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }
}
