package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.lottoNumbers;

public class LottoController {

    public void lottoGame() {
        Payment payment = new Payment(Input.amount(), Input.manualCount());

        List<Lotto> manualLottoTickets = Input.manualLottoTickets(payment.manualCount()).stream().map(this::parseLotto).collect(Collectors.toUnmodifiableList());
        List<Lotto> automaticLottoTickets = new LottoMachine(lottoNumbers()).automaticIssue(payment.automaticCount());
        List<Lotto> lottoTickets = Stream.concat(manualLottoTickets.stream(), automaticLottoTickets.stream()).collect(Collectors.toUnmodifiableList());
        Output.printPurchaseTickets(lottoTickets, payment.automaticCount(), payment.manualCount());

        WinningLotto winningLotto = new WinningLotto(parseLotto(Input.winningNumberOfLastWeek()), LottoNumber.lottoNumber(Input.bonusNumberOfLastWeek()));
        ResultStats resultStats = new ResultStats(lottoTickets, winningLotto);
        Output.printLottoResult(resultStats.countPerPrize());
        Output.printReturnOnInvestment(resultStats.returnOnInvestment(payment.amount()));
    }

    private Lotto parseLotto(String[] lottoNumbers) {
        return new Lotto(Arrays.stream(lottoNumbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::lottoNumber)
                .collect(Collectors.toList()));
    }
}
