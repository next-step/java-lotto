package lotto.ui;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ", ";

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

    public static int inputManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public static List<List<Integer>> inputManualTicket(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return Stream.generate(scanner::nextLine)
                .limit(count)
                .map(InputView::parse)
                .collect(Collectors.toList());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();

        return parse(winningNumbers);
    }

    private static List<Integer> parse(String numbers) {
        return Stream.of(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
