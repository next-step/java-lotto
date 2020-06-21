import lotto.domain.*;
import lotto.view.MoneyInputView;
import lotto.view.NumberInputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MoneyInputView payInput = MoneyInputView.enterMoney();
        LottoMoney payMoney = payInput.getLottoMoney();
        LottoStore lottoStore = new LottoStore(payMoney);
        List<LottoTicket> buyingLottoTickets = lottoStore.sellAutoLottoTicket();

        ResultView.printBuyingLotto(payMoney.getNumberOfLottoByMoneyPaid());
        ResultView.printLottoTickets(buyingLottoTickets);

        NumberInputView numberInputView = NumberInputView.enterWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(new CustomLottoTicket(numberInputView.getLottoNumbers()));
        List<Rank> lottoResults = winningLotto.getLottoRank(buyingLottoTickets);

        ResultView.printRankResult(lottoResults);
        ResultView.printTotalEarningRate(lottoResults, payMoney.getPayAmount());
    }
}
