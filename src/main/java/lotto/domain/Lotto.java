package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_ALL_NUMBER = 45;
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_UNIT_NUMBER = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
        List<Integer> lottoAllNumber = new ArrayList<>();

        IntStream.range(LOTTO_MINIMUM_NUMBER, LOTTO_ALL_NUMBER)
                .forEach(number -> lottoAllNumber.add(number));
        Collections.shuffle(lottoAllNumber);

        lottoAllNumber.stream()
                .limit(LOTTO_UNIT_NUMBER)
                .sorted()
                .forEach(number -> lottoNumbers.add(new LottoNumber(number)));
    }

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_UNIT_NUMBER) {
            throw new IllegalArgumentException("로또 개수는 6개여야 합니다.");
        }

        if (Set.copyOf(lottoNumbers).size() != LOTTO_UNIT_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 중복되어서는 안됩니다.");
        }

        List<LottoNumber> temporaryLottoNumbers = new ArrayList<>();
        lottoNumbers.forEach(lottoNumber -> temporaryLottoNumbers.add(new LottoNumber(lottoNumber)));

        this.lottoNumbers = new ArrayList<>(temporaryLottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    public int numberOfSame(Lotto lotto) {
        return (int) lotto.lottoNumbers.stream()
                .filter(lottoNumber -> this.lottoNumbers.contains(lottoNumber))
                .count();
    }

    public boolean isSameNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.stream().anyMatch(lottoNumber::isSameNumber);
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
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
