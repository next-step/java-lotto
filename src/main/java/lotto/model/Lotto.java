package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final Set<LottoNumber> numbers;

    public Lotto() {
        this(generateRandomNumbers());
    }

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

    public Lotto(List<Integer> numbers) {
        this(numbers.stream().map(LottoNumber::new).collect(Collectors.toSet()));
    }

    public Lotto(Set<LottoNumber> numbers) {
        checkValidity(numbers);
        List<LottoNumber> numbersList = new ArrayList<>(numbers);
        Collections.sort(numbersList);
        this.numbers = new HashSet<>(numbersList);
    }

    public Set<LottoNumber> value() {
        return Collections.unmodifiableSet(this.numbers);
    }

    public int countMatchNumbers(Lotto lotto) {
        return Math.toIntExact(this.numbers.stream().filter(lotto::contains).count());
    }

    public boolean matchesBonusNumber(LottoNumber bonusNumber) {
        return contains(bonusNumber);
    }

    private void checkValidity(Set<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> array = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(array);
        return array.subList(0, 6);
    }
}
