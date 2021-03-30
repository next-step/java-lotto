package lotto.view;

import lotto.constants.Constants;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        if (price % Constants.LOTTO_PRICE != 0) {
            throw new RuntimeException(String.format("%s원 단위로 구입할 수 있습니다.", Constants.LOTTO_PRICE));
        }
        return price;
    }

    public static Set<Integer> inputPrizeLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] prizeNumbers = scanner.next().split(",");
        return Arrays.stream(prizeNumbers)
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }
}
