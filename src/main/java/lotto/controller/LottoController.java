package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.lottoNumbers;

public class LottoController {

    public void lottoGame() {
        Input input = new Input();
        Payment payment = new Payment(input.amount());

        List<Lotto> lottoTickets = new LottoMachine(lottoNumbers()).issue(payment);
        Output.printBuyCount(payment.count());
        Output.printBuyTickets(lottoTickets);
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.stream(input.winningNumberOfLastWeek())
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::lottoNumber)
                .collect(Collectors.toList())), LottoNumber.lottoNumber(input.bonusNumberOfLastWeek()));

        ResultStats resultStats = new ResultStats(lottoTickets, winningLotto);
        Output.printLottoResult(resultStats.countPerPrize());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(payment.amount()));
    }
}
