package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.resources.StringResources;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public int getPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_PURCHASE_AMOUNT_HINT);
        return scanner.nextInt();
    }

    public LottoTicket getWinningTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_LAST_WINNING_LOTTO_NUMBERS_HINT);
        String inputText = scanner.nextLine();
        String[] winningTicketNumbers = inputText.trim().split(",");

        List<LottoNumber> lottoNumberList = Arrays
                .stream(winningTicketNumbers)
                .map(winningTicketNumber -> new LottoNumber(Integer.parseInt(winningTicketNumber)))
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumberList);
    }

    public LottoNumber getBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_BONUS_BALL_HINT);
        int bonusNumber = scanner.nextInt();
        return new LottoNumber(bonusNumber);
    }
}
