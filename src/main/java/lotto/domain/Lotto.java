package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    public static final int LOTTO_TOTAL_COUNT = 45;
    public static final int LOTTO_MIN_SIZE = 0;
    public static final int LOTTO_MAX_SIZE = 6;
    private final List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto createLotto() {
        List<Integer> lottoAllNum = Stream.iterate(1, n -> n + 1).limit(LOTTO_TOTAL_COUNT).collect(Collectors.toList());
        Collections.shuffle(lottoAllNum);
        List<Integer> temp = lottoAllNum.subList(LOTTO_MIN_SIZE, LOTTO_MAX_SIZE);
        Collections.sort(temp);
        return new Lotto(temp);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public long findSameNumber(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .filter(n -> lotto.contains(Integer.parseInt(n)))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }


}
