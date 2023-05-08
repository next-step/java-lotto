package controller;

import domain.*;
import util.LottoSeller;
import view.LottoInputView;
import view.LottoOutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private final String separator = ",";

    public void run() {
        final Money money = new Money(LottoInputView.inputPurchaseAmount());
        List<Lotto> lottoList = LottoSeller.buyLotto(money);

        LottoOutputView.printLottoCount(lottoList.size());
        LottoOutputView.printLottoList(lottoList);

        WinningLotto winningLotto = inputWinningLotto();

        List<LottoResult> results = lottoList.stream()
                .map(winningLotto::getResult)
                .collect(Collectors.toList());

        LottoOutputView.printLottoResult(new LottoStatistics(results));
    }

    private WinningLotto inputWinningLotto() {
        final List<LottoNumber> winningNumbers = Stream.of(LottoInputView.inputWinningLotto().split(separator))
            .map(String::trim)
            .map(LottoNumber::new)
            .distinct()
            .collect(Collectors.toList());

        final LottoNumber bonusNumber = new LottoNumber(LottoInputView.inputBonusNumber());

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
