import lotto.domain.*;
import lotto.util.ListConverter;
import lotto.util.RankCalculator;
import lotto.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MoneyInputView payInput = MoneyInputView.enterMoney();
        LottoMoney lottoMoney = new LottoMoney(payInput.getMoney());

        ManualLottoInputView manualLottoInput = ManualLottoInputView.enterManualLottoInput();

        int numberOfAutoLottoTicket = LottoSeller.getNumberOfAutoLottoTicket(lottoMoney.getNumberOfLottoByMoneyPaid(), manualLottoInput.getNumberOfManual());
        List<LottoTicket> buyingLottoTickets = LottoStore.sellAutoLottoTicket(numberOfAutoLottoTicket);
        buyingLottoTickets.addAll(LottoStore.sellManualLottoTicket(manualLottoInput.getStringManualNumbers()));
        LottoTicketResultView.printBuyingLotto(numberOfAutoLottoTicket, manualLottoInput.getNumberOfManual());
        LottoTicketResultView.printLottoTickets(buyingLottoTickets);

        NumberInputView numberInputView = NumberInputView.enterWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(new CustomLottoTicket(ListConverter.convertCommaStringToLottoNumbers(numberInputView.getLottoNumbers())),
                new LottoNumber(numberInputView.getBonusNumber()));
        List<Rank> lottoResults = winningLotto.getLottoRank(buyingLottoTickets);

        LottoResultView.printRankResult(RankCalculator.getRankResult(lottoResults));
        LottoResultView.printTotalEarningRate(RankCalculator.getTotalEarningRate(lottoResults, payInput.getMoney()));
    }

}
