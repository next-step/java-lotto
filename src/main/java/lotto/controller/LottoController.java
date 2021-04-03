package lotto.controller;

import lotto.domain.*;
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

        Lottos manualLottos = createManualLotto(manualLottoCount);
        Lottos randomLottos = Lottos.of(calculatePrice(purchaseAmount, manualLottoCount));

        int randomLottoCount = randomLottos.getSize();

        ResultView.printPurchaseCount(randomLottoCount, manualLottoCount);

        printLottosForCount(manualLottoCount, manualLottos);
        printLottosForCount(randomLottoCount, randomLottos);

        ResultView.printWinningStatistics(exportResponseWinningDTO(randomLottos, manualLottos, purchaseAmount));
    }

    private int calculatePrice(int purchaseAmount, int manualLottoCount) {
        return purchaseAmount - (manualLottoCount * Lotto.PRICE_OF_A_PIECE_OF_LOTTO);
    }

    private Lottos createManualLotto(int manualLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            Lotto lotto = Lotto.of(new FixedGenerator(InputView.inputManualLotto()));
            lottoList.add(lotto);
        }

        return Lottos.of(lottoList);
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
