package lotto.domain;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoSeller;
import lotto.view.model.LottoInput;
import lotto.domain.model.WinningLotto;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();

    public void purchase() {
        List<Lotto> purchasedLottos = purchaseLotto();
        WinningLotto winningLotto = getWinningLotto();
        displayResult(purchasedLottos, winningLotto);
    }

    private List<Lotto> purchaseLotto() {
        LottoInput lottoInput = InputView.getLottoInput();

        List<Lotto> manualLottos = lottoSeller.sellManualLotto(lottoInput);
        List<Lotto> autoLottos = lottoSeller.sellAutoLotto(lottoInput);

        OutputView.printPurchasedLottos(manualLottos, autoLottos);

        return getTotalPurchasedLottos(manualLottos, autoLottos);
    }

    private List<Lotto> getTotalPurchasedLottos(List<Lotto> manualLottos, List<Lotto> autoCreatedLottos) {
        return Stream.concat(manualLottos.stream(), autoCreatedLottos.stream())
                .collect(Collectors.toList());
    }

    private WinningLotto getWinningLotto() {
        return InputView.getWinnerInput();
    }

    private void displayResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoResult lottoResult = LottoResult.of(purchasedLottos, winningLotto);
        OutputView.printResult(lottoResult);
    }
}
