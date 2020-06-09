package dev.dahye.lotto;

import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.domain.LottoOrder;
import dev.dahye.lotto.domain.LottoResult;
import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.service.LottoMachine;
import dev.dahye.lotto.util.ConvertUtils;
import dev.dahye.lotto.view.InputView;
import dev.dahye.lotto.view.ResultView;

import java.util.List;

public class LottoShop {
    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney(InputView.doInputMoney());
        LottoOrder lottoOrder = LottoOrder.of(lottoMoney, InputView.doInputCountOfManualLotto());
        List<LottoTicket> manualLottoTickets = InputView.doInputManualLotto(lottoOrder);

        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottoOrder, manualLottoTickets);
        ResultView.printPurchasedLottoTickets(lottoMachine);

        LottoTicket winningTicket
                = LottoTicket.manualIssued(ConvertUtils.convertStringToIntegerList(InputView.doInputWinningNumbers()));
        int bonusNumber = InputView.doInputBonusNumber();

        LottoResult lottoResult = new LottoResult(lottoMachine.getLottoTickets(), winningTicket, bonusNumber);

        ResultView.printWinningStatistics(lottoResult);
        ResultView.printWinningRate(lottoResult.getMyWinningRate(lottoMoney));
    }
}
