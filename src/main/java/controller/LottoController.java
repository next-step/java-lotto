package controller;

import domain.Lotto;
import util.LottoSeller;
import domain.Money;
import domain.LottoResult;
import view.LottoInputView;
import view.LottoOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public void run() {
        final Money money = new Money(LottoInputView.inputPurchaseAmount());
        List<Lotto> lottoList = LottoSeller.buyLotto(money);

        LottoOutputView.printLottoCount(lottoList.size());
        LottoOutputView.printLottoList(lottoList);

        Lotto winningLotto = new Lotto(LottoInputView.inputWinningLotto());

        List<LottoResult> results = lottoList.stream()
                .map(lotto -> LottoResult.findBy(winningLotto, lotto))
                .collect(Collectors.toList());

        LottoOutputView.printLottoResult(results);
    }
}
