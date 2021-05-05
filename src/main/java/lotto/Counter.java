package lotto;

public class Counter {
    private int count = 0;

    public void add(int number) {
        count += number;
    }

    public int getCount() {
        return count;
    }
}
