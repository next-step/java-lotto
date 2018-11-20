package domain;

import java.util.Objects;

public class WinningLotto {
    private Lotto winningLoto;
    private int bonusNo;

    private WinningLotto(Lotto winningLoto, int bonusNo) {
        this.winningLoto = winningLoto;
        this.bonusNo = bonusNo;
    }

    public static WinningLotto from(Lotto winningLoto, int bonusNo) {
        return new WinningLotto(winningLoto, bonusNo);
    }

    public Rank matchesNo(Lotto inputlotto) {
        int count = inputlotto.match(winningLoto);
        return Rank.valueOf(count, inputlotto.isMatched(bonusNo));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return bonusNo == that.bonusNo &&
                Objects.equals(winningLoto, that.winningLoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLoto, bonusNo);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "winningLoto=" + winningLoto +
                ", bonusNo=" + bonusNo +
                '}';
    }
}
