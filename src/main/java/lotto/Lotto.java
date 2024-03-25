package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(Set<Integer> pickedNumber) {
        this(pickedNumber.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public Lotto() {
        this(pickLottoNumber());
    }

    private Lotto(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERR_NOT_ENOUGH_NUMBER.print());
        }
        this.numbers = numbers;
        this.numbers.sort(LottoNumber::compareTo);
    }

    private static Set<Integer> pickLottoNumber() {
        List<Integer> universalSet = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(universalSet);
        return new HashSet<>(universalSet.subList(0, 6));
    }

    public MatchedCount countMatchedNumber(Lotto winningLotto) {
        return new MatchedCount(this.numbers.stream()
                .filter(winningLotto::contains)
                .count());
    }

    public boolean contains(LottoNumber num) {
        return this.numbers.contains(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
