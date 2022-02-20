package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.LottoGame;
import lotto.domain.MatchResult;
import lotto.domain.YieldCalculator;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.count.Count;
import lotto.domain.lotto.count.ManualCount;
import lotto.domain.lotto.generator.AutoGenerator;
import lotto.domain.lotto.generator.Generator;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.Numbers;
import lotto.domain.money.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private static final int START = 1;

    private final LottoGame lottoGame = new LottoGame();

    public void start() {
        final Money money = inputMoneyValue();
        final Count totalCount = lottoGame.calculateLottoCount(money);

        final ManualCount manualCount = inputManualCount(totalCount);
        final Count autoCount = lottoGame.calculateAutoCount(totalCount, manualCount);

        final List<Numbers> manualNumbers = inputManualNumbers(manualCount);
        final Lottos manualLottos = generateManualLottos(manualCount, manualNumbers);
        ResultView.printLottoCount(manualCount, autoCount);

        final Lottos autoLottos = generateLottos(autoCount, new AutoGenerator());
        ResultView.printLottos(autoLottos);

        final Numbers winningNumbers = inputWinningNumbers();
        final BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        final Lottos totalLottos = lottoGame.generateTotalLottos(manualLottos, autoLottos);
        final MatchResult results = lottoGame.getResults(totalLottos, winningNumbers, bonusNumber);
        double yield = YieldCalculator.calculateYield(results, money);
        ResultView.printLottoResults(results, yield);
    }

    private Lottos generateManualLottos(ManualCount manualCount, List<Numbers> manualNumbers) {
        try {
            return lottoGame.makeManualLottos(manualCount, manualNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateManualLottos(manualCount, manualNumbers);
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

    private ManualCount inputManualCount(Count count) {
        try {
            return new ManualCount(new Count(InputView.inputManualCount()), count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputManualCount(count);
        }
    }

    private BonusNumber inputBonusNumber(Numbers winningNumbers) {
        try {
            return new BonusNumber(InputView.inputBonusNumber(), winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
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

    private Lottos generateLottos(Count lottoCount, final Generator generator) {
        try {
            return lottoGame.generateLottos(lottoCount.getValue(), generator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLottos(lottoCount, generator);
        }
    }

    private Money inputMoneyValue() {
        try {
            return new Money(InputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoneyValue();
        }
    }
}
