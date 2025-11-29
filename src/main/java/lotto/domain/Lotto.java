package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(int... numbers) {
        this(intToList(numbers));
    }

    public Lotto(String... numbers) {
        this(stringToList(numbers));
    }

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    private static List<LottoNumber> stringToList(String... numbers) {
        return Arrays.stream(numbers)
                .map(LottoNumber::new)
                .toList();
    }

    private static List<LottoNumber> intToList(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .toList();
    }

    public LottoRank determineRank(Lotto lotto, LottoNumber bonusNumber) {
        return LottoRank.getLottoRank(lotto.countMatchedNumbers(this.numbers), containsBonusNumber(bonusNumber));
    }

    public boolean containsBonusNumber(LottoNumber winLottoNumber) {
        return this.numbers.contains(winLottoNumber);
    }

    public int countMatchedNumbers(List<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(this.numbers::contains).count();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
