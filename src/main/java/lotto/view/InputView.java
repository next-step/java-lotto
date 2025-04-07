package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.LottoOrder;
import lotto.domain.WinningNumbers;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static LottoOrder getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoOrder(scanner.nextLine());
    }

    public static WinningNumbers getWinningTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.nextLine();
        return new WinningNumbers(parseIntCommaSeparated(numbers), parseInt(bonusNumber));
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    private static List<Integer> parseIntCommaSeparated(String input) {
        String[] numbers = input.split(",");
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(parseInt(number));
        }
        return result;
    }
}
