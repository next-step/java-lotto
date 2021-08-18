package lotto;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        int cash = lottoController.inputPurchaseAmount();
        Lottos lottos = lottoController.createAutoLotto(cash);
        lottoController.printLottos(lottos);

        List<Number> winnerNumbers = lottoController.inputWinnerNumbers();
        Map<Rank, Integer> rankInfo = lottos.findWinners(winnerNumbers);
        lottoController.printRanks(rankInfo);
        lottoController.printProfitRate(lottos, rankInfo);
    }
}
