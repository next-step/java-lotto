package step4.controller;

import step4.enumeration.LottoRank;
import step4.model.*;
import step4.utils.NumberSplitUtils;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoAutoAndManualController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Price price = inputView.payPriceInput();

        LottoCount manualLottoCount = inputView.manualLottoCountInput();
        List<Lotto> manualLottos = inputView.manualLottoNumberInput(manualLottoCount);

        int allLottoCount = price.lottoCount();
        outputView.viewLottoCount(allLottoCount, manualLottoCount.getCount());

        LottoCount autoLottoCount = new LottoCount().autoLottoCount(allLottoCount, manualLottoCount.getCount());
        LottoAutoMake lottoAutoMake = new LottoAutoMake(autoLottoCount);

        List<Lotto> lottos = new ArrayList<>(manualLottos);
        List<Lotto> lottoAuto = lottoAutoMake.makeAutoLottos();
        outputView.viewLotto(lottoAuto);
        lottos.addAll(lottoAuto);

        winnerResult(lottos, price);
    }

    private static void winnerResult(List<Lotto> allLottos, Price price) {
        List<Integer> lastWinNumbers = NumberSplitUtils.splitWinNumberString(inputView.putLastWinNumbers());
        int bonusNumber = inputView.bonusNumberInput();

        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(new LottoNumbers(lastWinNumbers), bonusNumber);

        Map<LottoRank, Integer> winnerScore = lottoWinNumbers.getWinnerNumberMatchCount(allLottos);
        outputView.viewLottoRating(winnerScore);

        LottoWinner lottoWinner = new LottoWinner(winnerScore);
        outputView.viewRating(lottoWinner.getRating(price));
    }
}
