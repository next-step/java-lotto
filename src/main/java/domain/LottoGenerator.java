package domain;

import util.RandomLottoNumberGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoGenerator {
    private static final int STANDARD_SIZE = 6;
    public static final Price UNIT_PRICE = new Price(1000);

    private LottoGenerator() {
    }

    public static LottoGenerator getInstance() {
        return LazyHolder.instance;
    }

    public List<Lotto> generateLotto(Price price) {
        return LongStream.range(0, getCount(price))
                .mapToObj(i -> new Lotto(generateNumbers()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(generateNumbers(numbers));
    }

    public WinningLotto generateWinningLotto(List<Integer> numbers, Integer bonusNumber) {
        return new WinningLotto(generateNumbers(numbers), new LottoNumber(bonusNumber));
    }

    private List<LottoNumber> generateNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        return numbers.stream()
                .map(LottoNumber::new)
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<LottoNumber> generateNumbers() {
        Set<LottoNumber> tempNumbers = new HashSet<>();

        RandomLottoNumberGenerator randomLottoNumberGenerator = RandomLottoNumberGenerator.getInstance();
        while(isValidateNumbers(tempNumbers)) {
            LottoNumber lottoNumber = randomLottoNumberGenerator.generate();
            tempNumbers.add(lottoNumber);
        }

        return tempNumbers.stream()
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isValidateNumbers(Set<LottoNumber> numbers) {
        return numbers.size() != STANDARD_SIZE && new HashSet<>(numbers).size() != STANDARD_SIZE;
    }

    private void validateNumbers(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        if(isValidateNumbers(lottoNumbers)) {
            throw new RuntimeException("로또는 6개의 숫자로 이루어져야 합니다.");
        };
    }

    private final static class LazyHolder {
        private final static LottoGenerator instance = new LottoGenerator();
    }

    private long getCount(Price price) {
        return price.divide(UNIT_PRICE);
    }
}
