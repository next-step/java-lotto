package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class LottoNumber {
    private final List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public Rank getRank(WinningNumbers winningNumber) {
        long count = lottoNumber.stream()
                .filter(integer -> winningNumber.getWinningNumbers()
                        .stream()
                        .anyMatch(Predicate.isEqual(integer)))
                .count();
        return Rank.getRank(count);
    }
}
