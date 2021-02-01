package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.resources.StringResources;

import java.util.Scanner;

public class InputView {

    public Money getPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_PURCHASE_AMOUNT_HINT);
        return new Money(scanner.nextInt());
    }

    public String[] getWinningTicketNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_LAST_WINNING_LOTTO_NUMBERS_HINT);
        String inputText = scanner.nextLine();
        String[] winningTicketNumbers = inputText.trim().split(",");

        return winningTicketNumbers;
    }

    public LottoNumber getBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_BONUS_BALL_HINT);
        int bonusNumber = scanner.nextInt();
        return new LottoNumber(bonusNumber);
    }
}
