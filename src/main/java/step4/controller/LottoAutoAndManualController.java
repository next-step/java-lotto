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

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int payPrice = inputView.payPriceInput();
        OutputView outputView = new OutputView();

        int manualLottoCount = inputView.manualLottoCountInput();
        List<String> manualLottoNumber = inputView.manualLottoNumberInput(manualLottoCount);

        outputView.viewLottoCount(payPrice, manualLottoCount);

        List<Lotto> allLottos = new ArrayList<>();
        List<Lotto> lottoAuto = new LottoMake().makeAutoLottos(CalculateUtils.autoLottoCount(CalculateUtils.lottoCount(payPrice), manualLottoCount));
        allLottos.addAll(lottoAuto);
        allLottos.addAll(new LottoMake().makeManualLottos(manualLottoNumber));

        outputView.viewLotto(lottoAuto);

        String lastWinNumbers = inputView.putLastWinNumbers();
        int bonusNumber = inputView.bonusNumberInput();

        LottoWinner lottoWinner = new LottoWinner(allLottos, new LottoWinNumbers(lastWinNumbers), bonusNumber);

        Map<LottoRank, Integer> winnerScore = lottoWinner.getWinnerNumberMatchCount();
        outputView.viewLottoRating(winnerScore);

        outputView.viewRating(lottoWinner.getRating(payPrice, winnerScore));
    }
}
