package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private InputView() {
    }

    public static int readPurchaseMoney(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int readManualNumberOfTicket(Scanner scanner) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printManualTicketNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<Integer> readManualTicketNumbers(Scanner scanner) {
        return parseStringToListInt(scanner.nextLine());
    }


    public static int readBonusNumber(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> readPrizeTicketNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return parseStringToListInt(input);
    }

    private static List<Integer> parseStringToListInt(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
