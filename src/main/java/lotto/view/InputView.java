package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.vo.LottoManualTicket;

import static java.lang.Integer.parseInt;
import static lotto.util.StringUtil.split;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseInt(scanner.nextLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return split(scanner.nextLine());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return parseInt(scanner.nextLine());
    }

    public int inputManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return parseInt(scanner.nextLine());
    }

    public List<LottoManualTicket> inputManualTicket(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<LottoManualTicket> manualTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            manualTickets.add(new LottoManualTicket(split(scanner.nextLine())));
        }

        return manualTickets;
    }
}
