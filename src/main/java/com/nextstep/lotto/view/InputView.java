package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoNumber;
import com.nextstep.lotto.domain.LottoTicket;
import com.nextstep.lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Money getMoney() {
        MoneyInputView moneyInputView = new MoneyInputView(SCANNER.nextLine());
        return moneyInputView.parseMoney();
    }

    public static LottoTicket getWinningTicket() {
        WinningTicketInputView winningInputView = new WinningTicketInputView(SCANNER.nextLine());
        return winningInputView.parseToLottoTicket();
    }

    public static LottoNumber getBonusNumber() {
        BonusNumberInputView bonusNumberInputView = new BonusNumberInputView(SCANNER.nextInt());
        return bonusNumberInputView.parseToBonusNumber();
    }
}
