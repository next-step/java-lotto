package lotto.controller;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        LottoPrice lottoPrice = new LottoPrice(InputView.readPrice());

        Lottos lottos = new Lottos(lottoPrice);
        OutputView.printLottoNumbers(lottos.getLottos());

        OutputView.printLottoCount(lottos.getLottos().size());

        WinningLotto winningLotto = createWinningLotto();
        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto.matchRank(lottos));

        OutputView.printLottoStatistics(lottoStatistics.makeRankReport());
        OutputView.printTotalReturn(Double.parseDouble(lottoStatistics.getLottoEarningRate(lottoPrice)));
    }

    private WinningLotto createWinningLotto() {
        LottoNumber bonusBall = new LottoNumber(InputView.readBonusNumber());
        Lotto winningLotto = createLotto();
        return new WinningLotto(winningLotto, bonusBall);
    }

    private Lotto createLotto() {
        String inputValue = InputView.readWinningNumber();
        Set<LottoNumber> lottoNumbers = Arrays.asList(inputValue.split(", ")).stream()
            .map(lottoNumber -> new LottoNumber(Integer.parseInt(lottoNumber)))
            .collect(Collectors.toSet());
        return new Lotto(lottoNumbers);
    }
}
