package dev.dahye.lotto;

import dev.dahye.lotto.domain.*;
import dev.dahye.lotto.service.LottoMachine;
import dev.dahye.lotto.util.ConvertUtils;
import dev.dahye.lotto.view.InputView;
import dev.dahye.lotto.view.ResultView;

import java.util.List;

public class LottoShop {
    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney(InputView.doInputMoney());
        LottoOrder lottoOrder = LottoOrder.of(lottoMoney, InputView.doInputCountOfManualLotto());
        List<LottoTicket> manualLottoTickets = InputView.doInputManualLotto(lottoOrder.getCountOfManualLotto());

        LottoMachine lottoMachine = new LottoMachine(lottoOrder, manualLottoTickets);
        ResultView.printPurchasedLottoTickets(
                lottoOrder.getCountOfManualLotto(),
                lottoOrder.getCountOfAutoLotto(),
                lottoMachine.getLottoTickets());

        LottoTicket winningTicket
                = LottoTicket.manualIssued(ConvertUtils.convertStringToIntegerList(InputView.doInputWinningNumbers()));
        LottoNumber bonusBall = LottoNumber.of(InputView.doInputBonusNumber());

        LottoResult lottoResult = new LottoResult(lottoMachine.getLottoTickets(), Winning.of(winningTicket, bonusBall));

        ResultView.printWinningStatistics(lottoResult);
        ResultView.printWinningRate(lottoResult.getMyWinningRate(lottoMoney));
    }
}
