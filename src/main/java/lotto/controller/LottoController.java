package lotto.controller;

import lotto.constant.LottoConstant;
import lotto.domain.Hit;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.RandomGenerator;
import lotto.domain.WinningNumber;
import lotto.domain.Yield;
import lotto.dto.ResponseLottosDTO;
import lotto.dto.ResponseWinningDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int manualLottoCount = InputView.inputManualLottoCount();
        InputView.showManualLotto();

        List<String> manualLottoString = exportManualLottosByInputView(manualLottoCount);
        Lottos manualLottos = Lottos.newManualLottos(manualLottoString);
        Lottos randomLottos = Lottos.newRandomLottos(calculatePrice(purchaseAmount, manualLottoCount), new RandomGenerator());

        int randomLottoCount = randomLottos.getSize();

        ResultView.printPurchaseCount(randomLottoCount, manualLottoCount);

        printLottosForCount(manualLottoCount, manualLottos);
        printLottosForCount(randomLottoCount, randomLottos);

        ResultView.printWinningStatistics(exportResponseWinningDTO(randomLottos, manualLottos, purchaseAmount));
    }

    private List<String> exportManualLottosByInputView(int manualLottoCount) {
        List<String> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manualLotto = InputView.inputManualLotto();
            manualLottoList.add(manualLotto);
        }
        return manualLottoList;
    }

    private int calculatePrice(int purchaseAmount, int manualLottoCount) {
        return purchaseAmount - (manualLottoCount * LottoConstant.PRICE_OF_A_PIECE_OF_LOTTO);
    }

    private void printLottosForCount(int count, Lottos randomLottos) {
        for (int i = 0; i < count; i++) {
            ResultView.printLottoNumber(new ResponseLottosDTO(randomLottos.getLottos().get(i).getLottoNumbers()));
        }
    }

    private ResponseWinningDTO exportResponseWinningDTO(Lottos randomLottos, Lottos manualLottos, int purchaseAmount) {
        WinningNumber winningNumber = new WinningNumber(InputView.inputLastWeekWinningNumber(), new LottoNumber(InputView.inputLastWeekBonusNumber()));

        Hit hit = randomLottos.getWinnerStatistics(winningNumber, new Hit());
        hit = manualLottos.getWinnerStatistics(winningNumber, hit);

        double yield = Yield.calculateYield(purchaseAmount, hit.getTotalWinningAmount());

        return new ResponseWinningDTO(hit.getHit(), yield);
    }
}
