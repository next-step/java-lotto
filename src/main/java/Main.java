import lotto.domain.*;
import lotto.util.ListConverter;
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
        WinningLotto winningLotto = new WinningLotto(new CustomLottoTicket(ListConverter.convertCommaStringToNumberList(numberInputView.getLottoNumbers())),
                numberInputView.getBonusNumber());
        List<Rank> lottoResults = winningLotto.getLottoRank(buyingLottoTickets);

        LottoResultView.printRankResult(lottoResults);
        LottoResultView.printTotalEarningRate(lottoResults, payInput.getMoney());
    }
}
