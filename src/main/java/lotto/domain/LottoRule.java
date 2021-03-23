package lotto.domain;

public class LottoRule {
    private static int MIN = 1;
    private static int MAX = 45;
    private static int COUNT_OF_SELECTION = 6;

    public int min() {
        return MIN;
    }

    public int max() {
        return MAX;
    }

    public int countOfSelection() {
        return COUNT_OF_SELECTION;
    }


}
