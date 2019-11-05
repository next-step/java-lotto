package com.seok2.lotto;

import com.seok2.lotto.domain.LottoMachine;
import com.seok2.lotto.domain.LottoResult;
import com.seok2.lotto.domain.Money;
import com.seok2.lotto.domain.Ticket;
import com.seok2.lotto.view.LottoInputView;
import com.seok2.lotto.view.LottoOutputView;

public class LottoMain {

    public static void main(String[] args) {
        Money investment = LottoInputView.getInvestment();
        Ticket ticket = LottoMachine.buy(investment);
        LottoOutputView.print(ticket);
        LottoResult result = ticket.check(LottoInputView.getWinning());
        LottoOutputView.print(result);
    }
}
