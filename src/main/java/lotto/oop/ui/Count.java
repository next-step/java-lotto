package lotto.oop.ui;

public class Count {
    private int count;

    public Count(int count) {
        if (count < 0) {
            throw new ArrayIndexOutOfBoundsException("로또 개수는 0 이상입니다.");
        }
        this.count = count;
    }

    public int getLottoCount() {
        return count;
    }
}
