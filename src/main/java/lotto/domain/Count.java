package lotto.domain;

public class Count {

    private int count;

    public Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void update() {
        count++;
    }
}
