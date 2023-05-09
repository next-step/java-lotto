package lotto.View;

import lotto.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int payment() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = SCANNER.nextLine();

        try {
            Count countOfTicket = new Count(Integer.parseInt(amount));
            return countOfTicket.value();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return payment();
        }
    }

    public static List<Ticket> manualBuy(int countOfTicket) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = SCANNER.nextLine();

        try {
            ManualCount manualCount = new ManualCount(input, countOfTicket);
            return manualTickets(manualCount.value());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return manualBuy(countOfTicket);
        }
    }

    public static List<Ticket> manualTickets(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Ticket> manualTickets = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualTickets.add(manualTicket());
        }

        return manualTickets;
    }

    private static Ticket manualTicket() {
        String input = SCANNER.nextLine();

        TicketNumber manualTicketNumber;
        try {
            manualTicketNumber = makeTicketNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return manualTicket();
        }
        return new Ticket(manualTicketNumber);
    }

    public static List<Integer> winnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.nextLine();

        TicketNumber winnerTicketNumber;
        try {
            winnerTicketNumber = makeTicketNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winnerNumber();
        }

        return winnerTicketNumber.numbers();
    }

    private static TicketNumber makeTicketNumber(String inputString) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputString.split(",")) {
            numbers.add(Integer.parseInt(number.trim()));
        }

        return new TicketNumber(numbers);
    }

    public static int bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = SCANNER.nextLine();

        BonusNumber bonusNumber;
        try {
            bonusNumber = new BonusNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumber();
        }

        return bonusNumber.number();
    }
}
