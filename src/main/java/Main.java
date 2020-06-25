import lotto.domain.*;
import lotto.util.ListConverter;
import lotto.util.RankCalculator;
import lotto.view.LottoResultView;
import lotto.view.LottoTicketResultView;
import lotto.view.MoneyInputView;
import lotto.view.NumberInputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MoneyInputView payInput = MoneyInputView.enterMoney();

        LottoMoney lottoMoney = new LottoMoney(payInput.getMoney());
        List<LottoTicket> buyingLottoTickets = LottoStore.sellAutoLottoTicket(lottoMoney);

        LottoTicketResultView.printBuyingLotto(lottoMoney.getNumberOfLottoByMoneyPaid());
        LottoTicketResultView.printLottoTickets(buyingLottoTickets);

        NumberInputView numberInputView = NumberInputView.enterWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(new CustomLottoTicket(ListConverter.convertCommaStringToLottoNumbers(numberInputView.getLottoNumbers())),
                new LottoNumber(numberInputView.getBonusNumber()));
        List<Rank> lottoResults = winningLotto.getLottoRank(buyingLottoTickets);

        LottoResultView.printRankResult(RankCalculator.getRankResult(lottoResults));
        LottoResultView.printTotalEarningRate(RankCalculator.getTotalEarningRate(lottoResults, payInput.getMoney()));
    }

}
