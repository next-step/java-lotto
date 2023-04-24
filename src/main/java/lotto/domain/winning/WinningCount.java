package lotto.domain.winning;

public class WinningCount {
    private int count;

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}
