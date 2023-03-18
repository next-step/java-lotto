package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    public static int inputBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.nextLine());
    }

    public static int[] inputLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputWinningNumbers = scanner.nextLine();
        String[] splitWinningNumbers = inputWinningNumbers.replaceAll(" ", "").split(",");
        return Arrays.stream(splitWinningNumbers).mapToInt(Integer::parseInt).toArray();
    }

    public static int inputLastWeekBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

}
