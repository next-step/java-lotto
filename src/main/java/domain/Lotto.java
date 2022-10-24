package domain;

import util.RandomLottoNumberGenerator;

import java.util.*;

public class Lotto {
    private static final int STANDARD_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        List<LottoNumber> numbers = generateNumbers();
        sortLottoNumber(numbers);
        this.lottoNumbers = Collections.unmodifiableList(numbers);
    }

    public Lotto(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        sortLottoNumber(numbers);
        this.lottoNumbers = Collections.unmodifiableList(numbers);
    }

    private List<LottoNumber> sortLottoNumber(List<LottoNumber> numbers) {
        numbers.sort(LottoNumber::compareTo);
        return numbers;
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != STANDARD_SIZE && new HashSet<>(numbers).size() != STANDARD_SIZE) {
            throw new RuntimeException("로또는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    private List<LottoNumber> generateNumbers() {
        Set<LottoNumber> tempNumbers = new HashSet<>();

        RandomLottoNumberGenerator randomLottoNumberGenerator = RandomLottoNumberGenerator.getInstance();
        while(tempNumbers.size() < STANDARD_SIZE) {
            LottoNumber lottoNumber = randomLottoNumberGenerator.generate();
            tempNumbers.add(lottoNumber);
        }

        return new ArrayList<>(tempNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }

    public long matchCount(Lotto lotto) {
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
