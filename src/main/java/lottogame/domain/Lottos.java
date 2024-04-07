package lottogame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottos {

    private static final int LOTTOS_SIZE = 6;
    private static final int LOTTOS_MIN_NUMBER = 1;
    private static final int LOTTOS_MAX_NUMBER = 45;
    private final List<LottoNumber> lottoNumbers;

    private Lottos(List<Number> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private Lottos(Numbers numbers) {
        this(numbers.toList());
    }

    public static Lottos from(List<Number> numbers) {
        return new Lottos(numbers);
    }

    public static Lottos from(Numbers numbers) {
        return new Lottos(numbers);
    }
    public static Lottos from() {
        Numbers numbers = Numbers.uniqueRandomOf(LOTTOS_MIN_NUMBER, LOTTOS_MAX_NUMBER);
        return new Lottos(numbers.createRandomNumbers(LOTTOS_SIZE));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean match(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int match(Lottos lottos) {
        return (int) lottos.lottoNumbers.stream()
                .filter(this::match)
                .count();
    }

    private static void validate(List<Number> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Number> numbers) {
        if (numbers.size() != LOTTOS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개야 합니다.");
        }
    }

    private static void validateDuplicate(List<Number> numbers) {
        Set<Number> target = new HashSet<>(numbers);
        if (target.size() != LOTTOS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수가 없습니다.");
        }
    }
}
