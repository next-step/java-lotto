package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberSet {

    private final Set<LottoNumber> lottoNumberSet;
    public static int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_EXCEPTION = "로또 번호는 " + LOTTO_SIZE + "개여야 합니다.";

    public static LottoNumberSet createLottoNumbers(int[] ints) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int number : ints) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoNumberSet(lottoNumbers);
    }

    public static LottoNumberSet getLottoNumbers() {
        return new LottoNumberSet(LottoNumberFactory.getNumbers(LOTTO_SIZE));
    }

    public LottoNumberSet(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
        this.lottoNumberSet = lottoNumbers;
    }

    public int match(LottoNumberSet numbers) {
        return lottoNumberSet.stream()
                .filter(lottoNumber -> numbers.lottoNumberList().contains(lottoNumber))
                .collect(Collectors.toList())
                .size();
    }

    private Set<LottoNumber> lottoNumberList() {
        return Collections.unmodifiableSet(this.lottoNumberSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberSet that = (LottoNumberSet) o;
        return Objects.equals(lottoNumberSet, that.lottoNumberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberSet);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LottoNumber[] lottoNumbers = lottoNumberSet.toArray(new LottoNumber[0]);
        result.append(lottoNumbers[0]);
        for (int i = 1; i < lottoNumbers.length; i++) {
            result.append(", ");
            result.append(lottoNumbers[i]);
        }
        return result.toString();
    }
}
