package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;
import java.util.Set;

public class LottoApp {

    public static void main(String[] args) {
        int buyAmount = InputView.scanBuyAmount();
        int manualLottoCount = InputView.scanManualLottoCount();
        List<Lotto> manualLottos = InputView.scanManualLottos(manualLottoCount);

        Set<LottoNumber> lottoNumbers = InputView.scanWinningNumbers();
        LottoNumber bonusNumber = InputView.scanBonusRepeat(lottoNumbers);

        LottoCollection lottoCollection = new LottoCollection(buyAmount, new RandomLottoNumbersGenerator());
        LottoResult lottoResult = lottoCollection.getLottoResult(new Lotto(lottoNumbers), bonusNumber);

        ResultView.printLottoNumberList(lottoCollection);
        ResultView.printStatistics(lottoResult);
    }

}
