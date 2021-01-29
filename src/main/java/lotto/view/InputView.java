package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        int price;

        System.out.println("구입금액을 입력해 주세요.");
        price = scanner.nextInt();
        return price;
    }

    public static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersInfo = scanner.next();
        for (String number : winningNumbersInfo.split(",")) {
            winningNumbers.add(Integer.valueOf(number.trim()));
        }
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        int bonusNumber;

        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = scanner.nextInt();
        return bonusNumber;
    }
}
