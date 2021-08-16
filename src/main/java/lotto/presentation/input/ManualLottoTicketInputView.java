package lotto.presentation.input;

import lotto.domain.Chance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualLottoTicketInputView {

    private static final String MANUAL_LOTTO_TICKET_INPUT_COMMENT = "수동으로 구매할 번호를 입력해 주세요.";

    public List<String> input(Chance chance) {
        System.out.println(MANUAL_LOTTO_TICKET_INPUT_COMMENT);
        List<String> manualLottoTickets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (chance.isLeft()) {
            manualLottoTickets.add(scanner.nextLine());
            chance = chance.useOnce();
        }
        return manualLottoTickets;
    }
}
