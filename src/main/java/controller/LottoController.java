package controller;

import domain.*;
import util.LottoSeller;
import view.LottoInputView;
import view.LottoOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public void run() {
        final Money money = new Money(LottoInputView.inputPurchaseAmount());
        List<Lotto> lottos = LottoSeller.buyLotto(money);

        LottoOutputView.printLottoCount(lottos.size());
        LottoOutputView.printLottoList(lottos);

        WinningLotto winningLotto = inputWinningLotto();

        List<LottoResult> results = lottos.stream()
                .map(winningLotto::getResult)
                .collect(Collectors.toList());

        LottoOutputView.printLottoResult(new LottoStatistics(results));
    }

    private WinningLotto inputWinningLotto() {
        final List<LottoNumber> winningNumbers = LottoInputView.inputWinningLotto().stream()
            .map(String::trim)
            .map(LottoNumber::new)
            .distinct()
            .collect(Collectors.toList());

        final LottoNumber bonusNumber = new LottoNumber(LottoInputView.inputBonusNumber());

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
