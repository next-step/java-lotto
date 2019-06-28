package step4.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String LUCKY_NUMBER_SEPARATOR = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static int askMoneyToInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int askNumberOfManualTicket() {
        printBlackLine();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<List<Integer>> askNumbersForManualTickets(int numberOfManualTickets) {
        printBlackLine();
        scanner.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualTickets = new ArrayList<>();

        for (int i = 0; i < numberOfManualTickets; i++) {
            String inputString = scanner.nextLine();
            manualTickets.add(
                    Arrays.stream(inputString.split(LUCKY_NUMBER_SEPARATOR))
                            .map(String::trim)
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .collect(Collectors.toList()));
        }
        printBlackLine();
        return manualTickets;
    }

    public static List<Integer> askLuckyNumber() {
        printBlackLine();
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String inputLuckyNumber = scanner.nextLine();
        printBlackLine();

        return Arrays.stream(inputLuckyNumber.split(LUCKY_NUMBER_SEPARATOR))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private static void printBlackLine() {
        System.out.println();
    }
}
