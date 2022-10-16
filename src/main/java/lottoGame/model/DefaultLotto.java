package lottoGame.model;

import java.util.List;
import java.util.Objects;

public class DefaultLotto implements Lotto {
    private final List<Integer> lottoNum;

    public DefaultLotto(List<Integer> lottoNum) {
        this.lottoNum = lottoNum;
    }

    @Override
    public int isContain(List<Integer> winnerNum) {
        return Math.toIntExact(lottoNum.stream()
                .filter(winnerNum::contains)
                .count());
    }

    @Override
    public String toString() {
        return "DefaultLotto{" +
                "lottoNum=" + lottoNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultLotto that = (DefaultLotto) o;
        return Objects.equals(lottoNum, that.lottoNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNum);
    }
}
