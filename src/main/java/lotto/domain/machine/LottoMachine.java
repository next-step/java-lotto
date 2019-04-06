package lotto.domain.machine;

import lotto.domain.*;

import java.util.List;

public class LottoMachine {
    private final LotteriesGenerator lotteriesGenerator;
    private final ResultCalculator resultCalculator;

    public LottoMachine(final LotteriesGenerator lotteriesGenerator, final ResultCalculator resultCalculator) {
        this.lotteriesGenerator = lotteriesGenerator;
        this.resultCalculator = resultCalculator;
    }

    public LottoPaper issue(final Money amount, final List<LottoNumbers> numbers) {
        return new LottoPaper(lotteriesGenerator.generate(amount, numbers));
    }

    public WinningStatistics viewResults(final LottoPaper lottoPaper, final WinningNumber winningNumber) {
        return resultCalculator.calculate(lottoPaper, winningNumber);
    }
}
