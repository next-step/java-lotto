package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.shuffleNumbers;

public class Lotto {
    private final static int LOTTO_SIZE = 6;

    public List<Set> lotto(UserInput userInput) {
        return autoIssue(userInput.count());
    }

    private List<Set> autoIssue(int countOfLotto) {
        return IntStream.range(0, countOfLotto)
                .mapToObj(i -> new TreeSet<Integer>(shuffleNumbers().stream()
                            .limit(LOTTO_SIZE)
                            .collect(Collectors.toList())))
                .collect(Collectors.toUnmodifiableList());
    }
}
