package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_ALL_NUMBER = 45;
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_UNIT_NUMBER = 6;

    private List<Integer> lottoNumbers = new ArrayList<>();

    public Lotto() {
        List<Integer> lottoAllNumber = new ArrayList<>();

        IntStream.range(LOTTO_MINIMUM_NUMBER, LOTTO_ALL_NUMBER)
                .forEach(number -> lottoAllNumber.add(number));
        Collections.shuffle(lottoAllNumber);

        lottoAllNumber.stream()
                .limit(LOTTO_UNIT_NUMBER)
                .sorted()
                .forEach(number -> lottoNumbers.add(number));
    }

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_UNIT_NUMBER) {
            throw new IllegalArgumentException("로또 개수는 6개여야 합니다.");
        }

        if (Set.copyOf(lottoNumbers).size() != LOTTO_UNIT_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 중복되어서는 안됩니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int numberOfSame(Lotto lotto) {
        return (int) lotto.lottoNumbers.stream()
                .filter(number -> this.lottoNumbers.contains(number))
                .count();
    }

    public boolean isBonusNumber(BonusNumber bonusNumber) {
        return this.lottoNumbers.stream().anyMatch(number -> bonusNumber.isSameNumber(number));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
