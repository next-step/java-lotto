package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = toLottoNumber(numbers);
    }

    private static List<LottoNumber> toLottoNumber(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }

    public LottoRank getMatchedRank(LottoNumbers other) {
        int matchCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (matchesAtIndex(i, other)) {
                matchCount++;
            }
        }

        return LottoRank.of(matchCount);
    }

    private boolean matchesAtIndex(int index, LottoNumbers other) {
        return numbers.get(index).equals(other.numbers.get(index));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
