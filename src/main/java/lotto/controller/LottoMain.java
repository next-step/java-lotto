package lotto.controller;

import lotto.dto.ExtractLottoNumbers;
import lotto.dto.LottoResult;
import lotto.dto.LottoCount;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.RandomLottoGenerator;
import lotto.model.WinnerLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        LottoCount lottoCount = payLottoMoney();

        Lottos manual = askManualLottos(InputView.askManualLottoNumbers(lottoCount.getManualCount()));
        Lottos random = new Lottos(lottoCount.getRandomCount(), new RandomLottoGenerator());

        ResultView.printBuyingLottos(manual, random);

        Lottos lottos = manual.addAll(random);
        LottoResult lottoResult = lottos.extractLottoResult(askWinnerLotto());

        Money buyingMoney = new Money((lottoCount.getManualCount()+lottoCount.getRandomCount())*1000);
        ResultView.printResult(buyingMoney, lottoResult);
    }

    private static LottoCount payLottoMoney() {
        Money buyingMoney = new Money(InputView.askBuyingMoney());
        int manualLottoCount = InputView.askManualLottoCount();
        return new LottoCount(buyingMoney, manualLottoCount);
    }

    private static WinnerLotto askWinnerLotto() {
        String winnerLottoNumbers = InputView.askWinnerLottoNumbers();

        Lotto winnerLotto = new Lotto(ExtractLottoNumbers.split(winnerLottoNumbers));
        LottoNumber bonusNumber = LottoNumber.valueOf(InputView.askBonusLottoNumber());

        return new WinnerLotto(winnerLotto, bonusNumber);
    }

    private static Lottos askManualLottos(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(lottoNumbers -> ExtractLottoNumbers.split(lottoNumbers))
                .map(Lotto::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }
}
