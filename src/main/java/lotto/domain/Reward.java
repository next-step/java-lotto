package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Reward {

    MATCH_NUMBER_THERE(3, 5000),
    MATCH_NUMBER_FOUR(4, 50000),
    MATCH_NUMBER_FIVE(5, 1500000),
    MATCH_NUMBER_SIX(6, 2000000000);

    public static final List<Reward> NUMBERS = Arrays.asList(MATCH_NUMBER_THERE, MATCH_NUMBER_FOUR, MATCH_NUMBER_FIVE, MATCH_NUMBER_SIX);

    private int matchNumber;
    private int price;

    Reward(int matchNumber, int price) {
        this.matchNumber = matchNumber;
        this.price = price;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrice() {
        return price;
    }

}