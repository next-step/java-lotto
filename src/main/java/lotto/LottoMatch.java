package lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoMatch {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    IVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    public final int matchCount;
    public final int prize;

    LottoMatch(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoMatch getLottoMatch(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return of((int) lottoNumbers.stream().filter(winningNumbers::contains).count());
    }

    public static LottoMatch of(int matchCount) {
        return Arrays.stream(values())
                .filter(match -> match.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 값이 없습니다."));
    }

}
