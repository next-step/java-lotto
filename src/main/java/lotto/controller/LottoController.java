package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

import static lotto.domain.LottoNumber.lottoNumbers;

public class LottoController {

    public void lottoGame() {
        Payment payment = new Payment(Input.amount(), Input.manualCount());
        LottoMachine lottoMachine = new LottoMachine(lottoNumbers());

        lottoMachine.manualIssue(Input.manualLottoTickets(payment.manualCount()));
        lottoMachine.automaticIssue(payment.automaticCount());

        List<Lotto> lottoTickets = lottoMachine.lottoTickets();
        Output.printPurchaseTickets(lottoTickets, payment.automaticCount(), payment.manualCount());

        WinningLotto winningLotto = new WinningLotto(new Lotto(Input.winningNumberOfLastWeek()), LottoNumber.lottoNumber(Input.bonusNumberOfLastWeek()));
        ResultStats resultStats = new ResultStats(lottoTickets, winningLotto);
        Output.printLottoResult(resultStats.countPerPrize());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(payment.amount()));
    }
}
