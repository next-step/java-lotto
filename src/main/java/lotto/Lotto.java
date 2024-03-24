package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    private boolean contains(LottoNumber num) {
        return this.numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
