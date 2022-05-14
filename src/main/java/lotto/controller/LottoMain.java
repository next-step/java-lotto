package lotto.controller;

import lotto.dto.LottoCount;
import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinnerLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        LottoCount lottoCount = payLottoMoney();

        Lottos lottos = buyAndPrintLottos(lottoCount);
        LottoResult lottoResult = lottos.extractLottoResult(makeWinnerLottos());

        ResultView.printResult(lottoCount.multiplyUnit(), lottoResult);
    }

    private static LottoCount payLottoMoney() {
        Money buyingMoney = new Money(InputView.askBuyingMoney());
        int manualLottoCount = InputView.askManualLottoCount();
        return new LottoCount(buyingMoney, manualLottoCount);
    }

    private static Lottos buyAndPrintLottos(LottoCount lottoCount) {
        List<Lotto> manual = makeManualLottos(InputView.askManualLottoNumbers(lottoCount.getManualCount()));
        Lottos lottos = Lottos.makeWithBaseAndCount(manual, lottoCount.getRandomCount());

        ResultView.printBuyingLottos(lottoCount, lottos);
        return lottos;
    }

    private static List<Lotto> makeManualLottos(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private static WinnerLotto makeWinnerLottos() {
        Lotto winnerLotto = new Lotto(InputView.askWinnerLottoNumbers());
        LottoNumber bonusNumber = LottoNumber.valueOf(InputView.askBonusLottoNumber());

        return new WinnerLotto(winnerLotto, bonusNumber);
    }
}
