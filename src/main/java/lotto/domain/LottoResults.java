package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoResults {

    private final List<LottoResult> lottoResults = new ArrayList<>();

    public void add(LottoResult lottoResult) {
        this.lottoResults.add(lottoResult);
    }

    public void addAll(LottoResult... lottoResults) {
        this.lottoResults.addAll(Arrays.asList(lottoResults));
    }

    public int getRankingHits(Ranking ranking) {
        return lottoResults.stream().filter(lottoResult -> lottoResult.rankingEquals(ranking))
                .map(LottoResult::getHits)
                .findAny()
                .orElseThrow(() -> new RuntimeException("예상 갯수에 맞는 맞춘 로또 수를 가져올 수 없습니다."));
    }

    public EarningRate getEarningLate(Money purchaseAmount) {
        return new EarningRate((double) calculateTotalCompensation().getValue() / purchaseAmount.getValue());
    }

    private Money calculateTotalCompensation() {
        return new Money(
                lottoResults.stream()
                        .map(LottoResult::calculateCompensation)
                        .reduce(0, Integer::sum)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}
