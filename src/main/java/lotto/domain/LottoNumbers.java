package lotto.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = toLottoNumber(numbers);
    }

    public LottoNumbers(int... numbers) {
        this(convertToList(numbers));
    }

    private static List<LottoNumber> toLottoNumber(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }

    private static List<Integer> convertToList(int... numbers) {
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        return list;
    }

    public LottoRank getMatchedRank(LottoNumbers other, LottoNumber bonusNumber) {
        int matchCount = 0;

       for (LottoNumber number : numbers) {
           if (other.contains(number)) {
               matchCount++;
           }
       }

        return LottoRank.of(matchCount, numbers.contains(bonusNumber));
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
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
