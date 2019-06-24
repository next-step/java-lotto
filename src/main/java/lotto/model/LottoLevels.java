package lotto.model;

public enum LottoLevels {

    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    ALL(6, 2000000000);


    private static int count;

    LottoLevels(int i, int i1) {
    }
    public void count() {
        count++;
    }
    public int value() {
        return count;
    }
}
