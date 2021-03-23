package lotto.domain;

public class LottoRule {
    private static int MIN = 1;
    private static int MAX = 45;
    private static int COUNT_OF_SELECTION = 6;
    private static int PRICE = 1000;

    public static int min() {
        return MIN;
    }

    public static int max() {
        return MAX;
    }

    public static int countOfSelection() {
        return COUNT_OF_SELECTION;
    }

    public static int price() {
        return PRICE;
    }

    private LottoRule() {
    }
}
