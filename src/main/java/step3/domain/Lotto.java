package step3.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<Integer> lotto;
    private LottoStore store = new LottoStore();

    public Lotto() {
        this.lotto = generateIntegers(store.createIntegers());
    }

    public Lotto(String winnerInput) {
        List<Integer> winnerLotto = Arrays.stream(winnerInput.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        this.lotto = generateIntegers(winnerLotto);
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public Rank match(List<Integer> lotto, WinningLotto winnerLotto) {
        Lotto newUserLotto = new Lotto(lotto);
        int matchCount = newUserLotto.match(winnerLotto);
        boolean matchBonus = newUserLotto.contains(winnerLotto.getBonus());

        return Rank.rank(matchCount, matchBonus);
    }

    public int match(WinningLotto winningLotto) {
        List<Integer> lotto1 = lotto;
        int count = 0;
        for (Integer number : lotto1) {
            count = getCount(winningLotto, count, number);
        }

        return count;
    }

    public boolean contains(Integer Integer) {
        return lotto.contains(Integer);
    }

    private int getCount(WinningLotto winningLotto, int count, Integer number) {
        if (winningLotto.contains(number)) {
            count++;
        }

        return count;
    }

    public List<Integer> generateIntegers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        return numbers;
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public void validateDuplication(List<Integer> Integers) {
        HashSet<Integer> numbers = new HashSet<>(Integers);
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복이 불가능합니다.");
        }
    }

    public List<Integer> getLotto() {
        return lotto;
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
