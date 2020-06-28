import lotto.domain.winning.LottoResult;
import lotto.domain.winning.WinningLotto;
import lotto.domain.store.LottoMoney;
import lotto.domain.store.LottoNumber;
import lotto.domain.store.LottoStore;
import lotto.domain.ticket.CustomLottoTicket;
import lotto.domain.ticket.LottoTicket;
import lotto.util.ListConverter;
import lotto.view.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MoneyInputView payInput = MoneyInputView.enterMoney();
        LottoMoney lottoMoney = new LottoMoney(payInput.getMoney());

        ManualLottoInputView manualLottoInput = ManualLottoInputView.enterManualLottoInput();

        List<LottoTicket> buyingLottoTickets = LottoStore.sellLottoTicket(lottoMoney, manualLottoInput.getStringManualNumbers());

        LottoTicketResultView.printBuyingLotto(manualLottoInput.getNumberOfManual(), LottoStore.getNumberOfAutoTicket(lottoMoney, manualLottoInput.getNumberOfManual()));
        LottoTicketResultView.printLottoTickets(buyingLottoTickets);

        NumberInputView numberInputView = NumberInputView.enterWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(new CustomLottoTicket(ListConverter.convertCommaStringToLottoNumbers(numberInputView.getLottoNumbers())),
                new LottoNumber(numberInputView.getBonusNumber()));
        LottoResult lottoResult = new LottoResult(winningLotto.getLottoRank(buyingLottoTickets));

        LottoResultView.printRankResult(lottoResult.getRankResult());
        LottoResultView.printTotalEarningRate(lottoResult.getTotalEarningRate(payInput.getMoney()));
    }

}
