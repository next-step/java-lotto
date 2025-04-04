package lotto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int purchaseAmount = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                return purchaseAmount;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요.");
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String[] numbers = scanner.nextLine().split(",");
                List<Integer> winningNumbers = new ArrayList<>();
                for (String number : numbers) {
                    winningNumbers.add(Integer.parseInt(number.trim()));
                }
                return winningNumbers;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요.");
            }
        }
    }
}
