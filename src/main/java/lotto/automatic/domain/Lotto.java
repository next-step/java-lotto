package lotto.automatic.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);

        this.lottoNumbers = new TreeSet<>(lottoNumbers);
    }

    public static Lotto auto() {
        return new Lotto(generateAutoNumbers());
    }

    private static List<LottoNumber> generateAutoNumbers() {

        return LottoNumber.random(NUMBER_SIZE);
    }

    private void validate(List<LottoNumber> numbers) {

        if(numbers.stream().distinct().count() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개로 구성되어 있어야 합니다.");
        }
    }

    public boolean contain(LottoNumber number) {

        return lottoNumbers.contains(number);
    }

    public int matchCount(Lotto lotto) {
        int count = 0;
        for (LottoNumber num : lottoNumbers) {
            count += lotto.contain(num) ? 1 : 0;
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return lottoNumbers != null ? lottoNumbers.equals(lotto.lottoNumbers) : lotto.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
