package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final static int LOTTO_NUMBER_SIZE = 6;
    private final static List<Integer> rangedInts = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private final Set<LottoNumber> numbers;

    public Lotto() {
        this(generateRandomNumbers());
    }

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers).mapToObj(LottoNumberFactory::get).collect(Collectors.toSet()));
    }

    public Lotto(Set<LottoNumber> numbers) {
        checkValidity(numbers);
        this.numbers = numbers;
    }

    public int countMatchNumbers(Lotto lotto) {
        return Math.toIntExact(this.numbers.stream().filter(lotto::contains).count());
    }

    public boolean matchesBonusNumber(LottoNumber bonusNumber) {
        return contains(bonusNumber);
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(this.numbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    private void checkValidity(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static Set<LottoNumber> generateRandomNumbers() {
        Collections.shuffle(rangedInts);
        return rangedInts.subList(0, LOTTO_NUMBER_SIZE).stream().map(LottoNumberFactory::get).collect(Collectors.toSet());
    }
}
