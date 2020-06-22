import lotto.domain.*;
import lotto.view.LottoResultView;
import lotto.view.LottoTicketResultView;
import lotto.view.MoneyInputView;
import lotto.view.NumberInputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MoneyInputView payInput = MoneyInputView.enterMoney();
        LottoMoney payMoney = payInput.getLottoMoney();
        LottoStore lottoStore = new LottoStore(payMoney);
        List<LottoTicket> buyingLottoTickets = lottoStore.sellAutoLottoTicket();

        LottoTicketResultView.printBuyingLotto(payMoney.getNumberOfLottoByMoneyPaid());
        LottoTicketResultView.printLottoTickets(buyingLottoTickets);

        NumberInputView numberInputView = NumberInputView.enterWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(new CustomLottoTicket(numberInputView.getLottoNumbers()));
        List<Rank> lottoResults = winningLotto.getLottoRank(buyingLottoTickets);

        LottoResultView.printRankResult(lottoResults);
        LottoResultView.printTotalEarningRate(lottoResults, payMoney.getPayAmount());
    }
}
