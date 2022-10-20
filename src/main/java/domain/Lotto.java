package domain;

import util.RandomNumberGenerator;

import java.util.*;

public class Lotto {
    private static final int MAXIMUM_NUMBER_BOUND = 45;
    private static final int STANDARD_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = generateNumbers();
    }

    public Lotto(List<LottoNumber> numbers) {
        this.lottoNumbers = new HashSet<>(numbers);
        validateNumbersSize();
    }

    private void validateNumbersSize() {
        if (this.lottoNumbers.size() != STANDARD_SIZE) {
            throw new RuntimeException("로또는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    private Set<LottoNumber> generateNumbers() {
        Set<LottoNumber> tempNumbers = new HashSet<>();

        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.getInstance();
        while(tempNumbers.size() < STANDARD_SIZE) {
            tempNumbers.add(new LottoNumber(randomNumberGenerator.generateNonZero(MAXIMUM_NUMBER_BOUND)));
        }

        return Collections.unmodifiableSet(tempNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }

    public long countEqualNumber(Lotto lotto) {
        return lotto.lottoNumbers
                .stream()
                .filter(lottoNumber -> this.lottoNumbers.contains(lottoNumber))
                .count();
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
}
