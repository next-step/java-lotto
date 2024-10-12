package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_NUMBERS_CARDINALITY = 6;
    public static final int MAX_BOUND = 45;
    public static final int MIN_BOUND = 1;

    private final int lottoNum;
    private final LottoNumbers numbers;

    private Lotto(int lottoNum, LottoNumbers numbers) {
        this.lottoNum = lottoNum;
        this.numbers = numbers;
    }

    public static Lotto valueOf(int lottoNum, List<Integer> numbers) {
        return new Lotto(lottoNum, LottoNumbers.valueOf(numbers));
    }

    public List<Integer> getNumbers() {
        return this.numbers.value();
    }

    public int getLottoNum() {
        return this.lottoNum;
    }

    public int getMatchCount(LottoNumbers winningNumbers) {
        int matchCount = 0;
        List<Integer> winningNumberList = winningNumbers.value();
        for (int number : numbers.value()) {
            matchCount = updateMatchCount(number, winningNumberList, matchCount);
        }
        return matchCount;
    }

    private int updateMatchCount(int number, List<Integer> winningNumberList, int matchCount) {
        if (winningNumberList.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(getLottoNum(), lotto.getLottoNum());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLottoNum());
    }
}
