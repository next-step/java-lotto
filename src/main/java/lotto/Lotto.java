package lotto;

public class Lotto {

    private static final int PER_COST = 1000;

    public static int lottoCount(int money) {
        return money / PER_COST;
    }
}
