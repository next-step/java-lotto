package lotto;

import java.util.*;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public static Lotto of(Set<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto ofComma(String stringNumbers) {
        String[] splitNumbers = stringNumbers.split(",");
        Set<String> numbers = new HashSet<>();
        Collections.addAll(numbers, splitNumbers);

        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (String number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        return of(lottoNumbers);
    }

    private static void checkSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("invalid lotto size");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
