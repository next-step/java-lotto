package step3.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import step3.constant.WinnerPrice;

public class TotalLotto {

    private static List<LottoNumbers> totalLotto;

    public TotalLotto() {
        totalLotto = new ArrayList<>();
    }

    public int size() {
        return totalLotto.size();
    }

    public void addLottoOne(List<Integer> list) {
        totalLotto.add(new LottoNumbers(list));
    }

    public List<List<Integer>> lotto() {
        List<List<Integer>> result = new ArrayList<>();
        for (LottoNumbers lottoNumbers : totalLotto) {
            result.add(lottoNumbers.numbers());
        }
        return result;
    }

    public String getBenefit(LottoNumbers victoryNumber, Price price) {

        Map<WinnerPrice, Long> lottoResult = groupByWinnerPrice(victoryNumber);
        BigDecimal result = sumResult(lottoResult);

        return result
            .divide(new BigDecimal(price.value()), 2, RoundingMode.DOWN)
            .toString();
    }

    public Map<WinnerPrice, Long> groupByWinnerPrice(
            LottoNumbers victoryNumber) {

        return totalLotto.stream()
            .map(lottoNumbers -> lottoNumbers.getWinnerPrice(victoryNumber))
            .collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
    }

    private BigDecimal sumResult(Map<WinnerPrice, Long> lottoResult) {
        Set<WinnerPrice> lottoRanks = lottoResult.keySet();

        return lottoRanks.stream()
            .map(
                winner -> new BigDecimal(winner.winnerPrice())
                    .multiply(new BigDecimal(lottoResult.get(winner))))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
