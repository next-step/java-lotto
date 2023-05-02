package lotto.View;

import lotto.Model.BonusNumber;
import lotto.Model.Count;
import lotto.Model.TicketNumber;

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

    public static List<Integer> winnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.nextLine();

        List<Integer> winnerNumber = new ArrayList<>();
        for (String winner : input.split(",")) {
            winnerNumber.add(Integer.parseInt(winner.trim()));
        }

        TicketNumber winnerTicket;
        try {
            winnerTicket = new TicketNumber(winnerNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winnerNumber();
        }

        return winnerTicket.numbers();
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
