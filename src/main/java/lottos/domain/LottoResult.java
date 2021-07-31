package lottos.domain;

import java.util.Objects;

public class LottoResult {

    private int prize;
    private Result result;

    public LottoResult(int prize, Result result) {
        this.prize = prize;
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return prize == that.prize && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize, result);
    }
}
