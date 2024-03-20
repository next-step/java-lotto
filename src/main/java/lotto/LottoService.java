package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
    public static void start() {
        long lottoMoney = InputView.inputLottoMoney();
        int lottoCount = LottoCalculator.getLottoCount(lottoMoney);

        ResultView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(
                Stream.generate(() -> new Lotto(LottoShuffle.makeLottoNumbersInRange()))
                        .limit(lottoCount)
                        .collect(Collectors.toList())
        );

        ResultView.printLottos(lottos);

        List<Integer> winningLottoNumber = InputView.inputWinningNumber();

        HashMap<LottoRank, Integer> lottoRanks = lottos.getWinningStatistics(winningLottoNumber);

        ResultView.printWinningStatistics(lottoRanks);
        ResultView.printRateOfReturn(lottoMoney, getWinningMoney(lottoRanks));
    }

    private static long getWinningMoney(HashMap<LottoRank, Integer> lottoRanks) {
        return lottoRanks.entrySet().stream().map(lottoRank -> lottoRank.getKey().getMoney()).reduce((x, y) -> x + y).orElse(0);
    }

}
