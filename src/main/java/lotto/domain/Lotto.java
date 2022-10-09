package lotto.domain;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.shuffleNumbers;

public class Lotto {
    private final static int LOTTO_SIZE = 6;

    public List<NavigableSet<Integer>> lotto(final UserInput userInput) {
        return tickets(userInput.count());
    }

    private List<NavigableSet<Integer>> tickets(final int countOfLotto) {
        return autoIssue(countOfLotto);
    }

    private List<NavigableSet<Integer>> autoIssue(final int countOfLotto) {
        return IntStream.range(0, countOfLotto)
                .mapToObj(i -> new TreeSet<>(shuffleNumbers().stream()
                        .limit(LOTTO_SIZE)
                        .collect(Collectors.toList())))
                .collect(Collectors.toUnmodifiableList());
    }
}
