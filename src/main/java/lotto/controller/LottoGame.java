package lotto.controller;

import lotto.domain.*;
import lotto.domain.lottoStrategy.ManualLottoStrategy;
import lotto.domain.lottoStrategy.RandomLottoStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoGenerator lottoGenerator;

    public LottoGame(InputView inputView, ResultView resultView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoGenerator = lottoGenerator;
    }

    public void start() {
        Money totalMoney = initMoney();

        LottoCount totalCount = new LottoCount(totalMoney);
        LottoCount manualLottoCount = initManualLottoCount();

        List<Lotto> manualLottoList = initManualLottos(manualLottoCount);

        Lottos manualLottos = lottoGenerator.generateLottos(manualLottoCount, new ManualLottoStrategy(manualLottoList));

        Lottos autoLottos = lottoGenerator.generateLottos(totalCount.subtractCount(manualLottoCount), new RandomLottoStrategy());

        resultView.printPickedLottoNumbers(manualLottos, autoLottos);

        Lotto winningLotto = initLottoNumbers();
        LottoNumber bonusNumber = initBonusNumber();
        WinningInfo winningInfo = WinningInfo.of(manualLottos, autoLottos, bonusNumber, winningLotto);

        resultView.printWinningStatic(winningInfo, totalMoney);
    }

    private List<Lotto> initManualLottos(LottoCount lottoCount) {
        resultView.printManualLottos();
        return Stream.generate(() -> new Lotto(inputView.inputLottoNumber()))
                .limit(lottoCount.getCount())
                .collect(Collectors.toList());
    }

    private LottoCount initManualLottoCount() {
        resultView.printManualLottoCount();
        int manualLottoCount = inputView.inputManualLottoCount();

        return new LottoCount(manualLottoCount);
    }

    private Lotto initLottoNumbers() {
        resultView.printWinningLotto();
        List<Integer> inputLottoNumber = inputView.inputLottoNumber();

        return new Lotto(inputLottoNumber);
    }

    private LottoNumber initBonusNumber() {
        resultView.printBonusNumber();
        int bonusNumber = inputView.inputBonusNumber();

        return new LottoNumber(bonusNumber);
    }

    private Money initMoney() {
        resultView.printMoney();

        int inputMoney = inputView.inputMoney();
        return new Money(inputMoney);
    }
}
