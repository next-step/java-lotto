package step3.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import step3.constant.Rank;

public class TotalLotto {

    private final List<LottoNumbers> totalLotto;

    public TotalLotto(List<LottoNumbers> totalLotto) {
        this.totalLotto = totalLotto;
    }

    public String totalSize() {
        return String.valueOf(totalLotto.size());
    }

    public String getBenefit(LottoNumbers victoryNumber, Price price) {

        Map<Rank, Long> lottoResult = groupByWinnerPrice(victoryNumber);
        BigDecimal result = sumResult(lottoResult);

        return result
            .divide(new BigDecimal(price.value()), 2, RoundingMode.DOWN)
            .toString();
    }

    public Map<Rank, Long> groupByWinnerPrice(LottoNumbers victoryNumber) {

        return totalLotto.stream()
            .map(lottoNumbers -> lottoNumbers
                .getRankWithVictoryNumber(victoryNumber))
            .collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
    }

    public String getStatus() {
        List<String> temp = new ArrayList<>();
        totalLotto.stream()
            .forEach(lottoNumbers -> temp.add(lottoNumbers.getStatus()));
        return String.join("\n", temp);
    }

    private BigDecimal sumResult(Map<Rank, Long> lottoResult) {
        Set<Rank> lottoRanks = lottoResult.keySet();

        return lottoRanks.stream()
            .map(winner -> new BigDecimal(winner.winnerPrice())
                .multiply(new BigDecimal(lottoResult.get(winner))))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
