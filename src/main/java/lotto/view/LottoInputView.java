package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyForTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        return getIntInput();
    }

    public static int getNumberOfManualTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return getIntInput();
    }

    public static List<List<Integer>> getLottoTicketNumbers(int numberOfTickets) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(getCommaSeperatedIntegerInput());
        }
        return tickets;
    }

    public static List<Integer> getLastWeekWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getCommaSeperatedIntegerInput();
    }

    public static int getLastWeekBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getIntInput();
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자로 입력해주세요");
        }
    }

    private static List<Integer> getCommaSeperatedIntegerInput() {
        String inputString = scanner.nextLine();
        try {
            return Arrays.stream(inputString.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }

}
