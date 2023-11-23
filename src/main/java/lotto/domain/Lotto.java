package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> lotto;
    private final List<Integer> lottoNumberSet = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    private Ranking ranking;
    private int matchingCount = 0;

    public Lotto() {
        lotto = makeLotto();
    }

    private List<Integer> makeLotto() {
        Collections.shuffle(lottoNumberSet);
        return lottoNumberSet.subList(0, 6).stream().sorted().collect(Collectors.toList());
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> lotto() {
        return lotto;
    }

    public Ranking ranking() {
        return ranking;
    }

    public void rank(Lotto winningLotto) {
        for (int number : winningLotto.lotto()) {
            increaseMatchingCount(number);
        }
        ranking = Ranking.of(matchingCount);
    }

    private void increaseMatchingCount(int number) {
        if (lotto.contains(number)) {
            matchingCount++;
        }
    }
}
