package lotto.controller;

import lotto.domain.Hit;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.domain.WinningNumber;
import lotto.dto.ResponseLottosDTO;
import lotto.dto.ResponsePurchaseCountDTO;
import lotto.dto.ResponseWinningDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private static int PRICE_OF_A_PIECE_OF_LOTTO = 1_000;

    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();

        int count = getLottoPurchaseCount(purchaseAmount);
        ResultView.printPurchaseCount(new ResponsePurchaseCountDTO(count));

        Lottos lottos = Lottos.of(count);
        printLottosForCount(count, lottos);

        ResultView.printWinningStatistics(exportResponseWinningDTO(lottos, purchaseAmount));
    }

    public int getLottoPurchaseCount(int price) {
        return price / PRICE_OF_A_PIECE_OF_LOTTO;
    }

    private void printLottosForCount(int count, Lottos lottos) {
        for (int i = 0; i < count; i++) {
            ResultView.printLottoNumber(new ResponseLottosDTO(lottos.getLottos().get(i).getLottoNumbers()));
        }
    }

    private ResponseWinningDTO exportResponseWinningDTO(Lottos lottos, int purchaseAmount) {
        WinningNumber winningNumber = new WinningNumber(InputView.inputLastWeekWinningNumber());
        Hit hit = winningNumber.getWinnerStatistics(lottos);
        double yield = Statistics.getYield(purchaseAmount, hit.getTotalWinningAmount());

        return new ResponseWinningDTO(hit.getHit(), yield);
    }
}
