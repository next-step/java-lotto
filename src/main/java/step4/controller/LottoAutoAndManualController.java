package step4.controller;

import step4.enumeration.LottoRank;
import step4.model.*;
import step4.utils.CalculateUtils;
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

        LottoMake lottoMake = getLottoCountAndReadyToMake(payPrice);
        List<Lotto> allLottos = makeAllLottos(lottoMake);

        winnerResult(allLottos, payPrice);
    }

    private static LottoMake getLottoCountAndReadyToMake(int payPrice) {
        int manualLottoCount = inputView.manualLottoCountInput();
        List<String> manualLottoNumber = inputView.manualLottoNumberInput(manualLottoCount);

        outputView.viewLottoCount(payPrice, manualLottoCount);

        return new LottoMake(CalculateUtils.autoLottoCount(CalculateUtils.lottoCount(payPrice), manualLottoCount), manualLottoNumber);
    }

    private static List<Lotto> makeAllLottos(LottoMake lottoMake) {
        List<Lotto> allLottos = new ArrayList<>();
        List<Lotto> lottoAuto = lottoMake.makeAutoLottos();
        allLottos.addAll(lottoAuto);
        allLottos.addAll(lottoMake.makeManualLottos());

        outputView.viewLotto(lottoAuto);
        return allLottos;
    }

    private static void winnerResult(List<Lotto> allLottos, int payPrice) {
        String lastWinNumbers = inputView.putLastWinNumbers();
        int bonusNumber = inputView.bonusNumberInput();

        LottoWinner lottoWinner = new LottoWinner(allLottos, new LottoWinNumbers(lastWinNumbers), bonusNumber);

        Map<LottoRank, Integer> winnerScore = lottoWinner.getWinnerNumberMatchCount();
        outputView.viewLottoRating(winnerScore);

        outputView.viewRating(lottoWinner.getRating(payPrice, winnerScore));
    }
}
