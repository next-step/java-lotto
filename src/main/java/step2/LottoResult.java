package step2;

import java.util.List;

public class LottoResult {

    private final List<Integer> lottoResult;

    public LottoResult(List<Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int countMatchingNumbers(List<Integer> winNumbers) {
        return Math.toIntExact(
                winNumbers.stream()
                        .filter(lottoResult::contains)
                        .count()
        );
    }

    @Override
    public String toString() {
        return lottoResult.toString();
    }
}
