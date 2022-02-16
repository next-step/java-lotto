package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        LottoPrice lottoPrice = InputView.readPrice();

        Lottos lottos = new Lottos(lottoPrice);
        ResultView.printLottoNumbers(lottos.getLottoLists());

        OutputView.printLottoCount(lottos.getLottoLists().size());

        String winningNumber = InputView.readWinningNumber();
        LottoNumber bonusBall = InputView.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(refineToLottoList(winningNumber), bonusBall, lottos);
        List<Rank> winningRanks = winningLotto.matchRank();

        String lottoEaringRate = LottoStatistics.getLottoEarningRate(winningRanks, lottoPrice);
        ResultView.printLottoStatistics(winningRanks, lottoEaringRate);
    }

    public static Lotto refineToLottoList(String unrefinedNumber) {
        return new Lotto(Arrays.asList(unrefinedNumber.split(", ")).stream()
            .map(n -> new LottoNumber(Integer.parseInt(n)))
            .collect(Collectors.toSet()));
    }
}
