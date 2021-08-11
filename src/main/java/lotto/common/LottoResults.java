package lotto.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoResults {

    private final List<LottoResult> elements = new ArrayList<>();

    public void add(LottoResult lottoResult) {
        this.elements.add(lottoResult);
    }

    public void addAll(LottoResult... lottoResults) {
        this.elements.addAll(Arrays.asList(lottoResults));
    }

    public int getExpectedHits(int expect) {
        return elements.stream().filter(lottoResult -> lottoResult.expectEquals(expect))
                .map(LottoResult::getHits)
                .findAny()
                .orElseThrow(() -> new RuntimeException("예상 갯수에 맞는 맞춘 로또 수를 가져올 수 없습니다."));
    }

    public double getEarningLate(int purchaseAmount) {
        return (double) calculateTotalCompensation() / purchaseAmount;
    }

    private int calculateTotalCompensation() {
        return elements.stream()
                .map(LottoResult::calculateCompensation)
                .reduce(0, Integer::sum)
        ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
