package lotto.domain;

public class Lotto {
    private final int[] lotto;

    public Lotto(int i, int i1, int i2, int i3, int i4, int i5) {
        lotto = new int[]{};
    }

    public Lotto(int[] randomNumbers) {
        lotto = randomNumbers;
    }

    public Rank winningResult(WinningNumber winningNumber) {
        return Rank.OTHER;
    }
}
