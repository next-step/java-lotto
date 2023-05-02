package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto() {
        this.numbers = randomLottoNumbers();
    }

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    private TreeSet<Integer> randomLottoNumbers() {
        List<Integer> AllNumbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(AllNumbers);
        return new TreeSet<>(AllNumbers.subList(0, 6));
    }

    public Rank getRank(WinNumbers winNumbers) {
        return Rank.fromMatchCount(getMatchCount(winNumbers));
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private long getMatchCount(WinNumbers winNumbers) {
        return numbers.stream()
                .filter(winNumbers::contain)
                .count();
    }
}
