package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
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

        WinningLotto winningLotto = createWinningLotto(lottos);
        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto.matchRank());
        String lottoEaringRate = lottoStatistics.getLottoEarningRate(lottoPrice);
        ResultView.printLottoStatistics(lottoStatistics, lottoEaringRate);
    }

    private WinningLotto createWinningLotto(Lottos lottos) {
        LottoNumber bonusBall = InputView.readBonusNumber();
        Lotto winningLotto = createLotto();
        return new WinningLotto(winningLotto, bonusBall, lottos);
    }

    private Lotto createLotto() {
        String inputValue = InputView.readWinningNumber();
        Set<LottoNumber> lottoNumbers = Arrays.asList(inputValue.split(", ")).stream()
            .map(lottoNumber -> new LottoNumber(Integer.parseInt(lottoNumber)))
            .collect(Collectors.toSet());
        return new Lotto(lottoNumbers);
    }
}
