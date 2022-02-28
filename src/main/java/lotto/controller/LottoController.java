package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoRaffle;
import lotto.domain.MatchResult;
import lotto.domain.YieldCalculator;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.count.Count;
import lotto.domain.lotto.count.ManualCount;
import lotto.domain.lotto.generator.AutoGenerator;
import lotto.domain.lotto.generator.Generator;
import lotto.domain.lotto.generator.ManualGenerator;
import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.Numbers;
import lotto.domain.money.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private static final int START = 1;

    public void start() {
        final Money money = inputMoneyValue();
        final Count totalCount = money.calculateLottoCount();

        final ManualCount manualCount = inputManualCount(totalCount);
        final Count autoCount = Count.calculateAutoCount(totalCount, manualCount);

        final List<Numbers> manualNumbers = inputManualNumbers(manualCount);
        final Lottos manualLottos = generateManualLottos(manualCount, manualNumbers);
        ResultView.printLottoCount(manualCount, autoCount);

        final Lottos autoLottos = generateLottos(autoCount, new AutoGenerator());
        final Lottos totalLottos = Lottos.combine(manualLottos, autoLottos);
        ResultView.printLottos(totalLottos);

        final Numbers winningNumbers = inputWinningNumbers();
        final WinningLotto winningLotto = generateWinningLotto(winningNumbers);

        final LottoRaffle lottoRaffle = new LottoRaffle(winningLotto);
        final MatchResult results = lottoRaffle.compareLottos(totalLottos);
        double yield = YieldCalculator.calculateYield(results, money);
        ResultView.printLottoResults(results, yield);
    }

    private Money inputMoneyValue() {
        try {
            return new Money(InputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoneyValue();
        }
    }

    private ManualCount inputManualCount(Count count) {
        try {
            return new ManualCount(new Count(InputView.inputManualCount()), count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputManualCount(count);
        }
    }

    private List<Numbers> inputManualNumbers(ManualCount manualCount) {
        try {
            ResultView.printInputManualLottosInfo();
            return IntStream.rangeClosed(START, manualCount.getCountValue())
                .mapToObj(i -> new Numbers(InputView.inputManualNumber()))
                .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputManualNumbers(manualCount);
        }
    }

    private Lottos generateManualLottos(ManualCount manualCount, List<Numbers> manualNumbers) {
        try {
            return new Lottos(manualCount.getCountValue(), new ManualGenerator(manualNumbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateManualLottos(manualCount, manualNumbers);
        }
    }

    private Numbers inputWinningNumbers() {
        try {
            return new Numbers(InputView.inputLastWinningNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private Number inputBonusNumber() {
        try {
            return new Number(InputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private WinningLotto generateWinningLotto(Numbers winningNumbers) {
        try {
            return new WinningLotto(winningNumbers, inputBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateWinningLotto(winningNumbers);
        }
    }

    private Lottos generateLottos(Count lottoCount, final Generator generator) {
        try {
            return new Lottos(lottoCount.getValue(), generator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLottos(lottoCount, generator);
        }
    }
}
