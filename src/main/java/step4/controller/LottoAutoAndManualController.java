package step4.controller;

import step4.enumeration.LottoRank;
import step4.model.*;
import step4.utils.CalculateUtils;
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
        int payPrice = inputView.payPriceInput();

        int manualLottoCount = inputView.manualLottoCountInput();
        List<String> manualLottoNumber = inputView.manualLottoNumberInput(manualLottoCount);

        outputView.viewLottoCount(payPrice, manualLottoCount);

        int autoLottoCount = CalculateUtils.autoLottoCount(CalculateUtils.lottoCount(payPrice), manualLottoCount);
        LottoAutoMake lottoAutoMake = new LottoAutoMake(new LottoCount(autoLottoCount));

        LottoManualMake lottoManualMake = new LottoManualMake(manualLottoNumber);
        List<Lotto> allLottos = makeAllLottos(lottoAutoMake, lottoManualMake);

        winnerResult(allLottos, payPrice);
    }

    private static List<Lotto> makeAllLottos(LottoAutoMake lottoAutoMake, LottoManualMake lottoManualMake) {
        List<Lotto> allLottos = new ArrayList<>();
        List<Lotto> lottoAuto = lottoAutoMake.makeAutoLottos();
        allLottos.addAll(lottoAuto);
        allLottos.addAll(lottoManualMake.makeLottos());

        outputView.viewLotto(lottoAuto);
        return allLottos;
    }

    private static void winnerResult(List<Lotto> allLottos, int payPrice) {
        List<Integer> lastWinNumbers = NumberSplitUtils.splitWinNumberString(inputView.putLastWinNumbers());
        int bonusNumber = inputView.bonusNumberInput();

        LottoWinner lottoWinner = new LottoWinner(allLottos, new LottoWinNumbers(new LottoNumbers(lastWinNumbers), bonusNumber));

        Map<LottoRank, Integer> winnerScore = lottoWinner.getWinnerNumberMatchCount(bonusNumber);
        outputView.viewLottoRating(winnerScore);

        outputView.viewRating(lottoWinner.getRating(payPrice, winnerScore));
    }
}
