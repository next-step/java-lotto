package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Price;
import lotto.model.Statistics;
import lotto.strategy.NumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private final NumberGenerateStrategy numberGenerateStrategy;

    public LottoService(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public Lottos generateLottos(Price price) {
        return price.generateLottos(numberGenerateStrategy);
    }

    public Statistics generateStatistics(Lottos lottos, Lotto winningLotto, Price price) {
        List<Long> matchingCounts = lottos.calculateMatchingCounts(winningLotto);

        double rateOfProfit = price.calculateRateOfProfit(lottos.calculateProfit(winningLotto));

        return new Statistics(matchingCounts, rateOfProfit);
    }

}
