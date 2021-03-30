package step4;
import java.util.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또의 자리수는 6자리입니다.");
        }
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> numbers) {
        Set<LottoNumber> lotto = new HashSet<>();

        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    public int match(Lotto winnerLotto) {
        int count = 0;
        return matchedCount(winnerLotto, count);
    }

    private int matchedCount(Lotto winnerLotto, int count) {
        for (LottoNumber number : lotto) {
            count = getCount(winnerLotto, count, number);
        }
        return count;
    }

    private int getCount(Lotto winnerLotto, int count, LottoNumber number) {
        if (winnerLotto.contains(number)) {
            count++;
        }
        return count;
    }

    public boolean contains(LottoNumber number) {
        return lotto.contains(number);
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

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
