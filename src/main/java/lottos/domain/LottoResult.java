package lottos.domain;

import java.util.Objects;

public class LottoResult {

    private Prize prize;

    public LottoResult(Prize prize) {
        this.prize = prize;
    }

    public Prize getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return prize == that.prize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
