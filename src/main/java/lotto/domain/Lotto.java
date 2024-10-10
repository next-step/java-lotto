package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final int lottoNum;
    private LottoNumbers numbers;

    Lotto(int lottoNum, LottoNumbers numbers) {
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
            if (winningNumberList.contains(number)) {
                matchCount++;
            }
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
