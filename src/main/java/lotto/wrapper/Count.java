package lotto.wrapper;

public class Count {
    private int count;

    public Count(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }

    public void countUp() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
