package lotto;

public class Count {
    private int count;

    public Count(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }
}
