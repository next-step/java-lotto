package lotto;

import java.util.List;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        int money = InputView.inputTryNo("구입금액을 입력해 주세요.");
        
        LottoStore lottoStore = new LottoStore(new LottoMachine());
        List<LottoTicket> tickets = lottoStore.buyTickets(money);
        
        ResultView.renderBuyedTickets(tickets);
        
        String winningNumber = InputView.inputTryLine("지난 주 당첨 번호를 입력해 주세요.");
        LottoResult lottoResult = lottoStore.checkTickets(winningNumber, tickets);
        
        ResultView.renderStats(lottoResult);
    }
}
