package lotto.model.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Winning {

    THREE_MATCH(3,5000),
    FOUR_MATCH(4,50000),
    FIVE_MATCH(5,1500000),
    SIX_MATCH(6,2000000000);

    private static final Map<Integer,String> MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Winning::getMatch, Winning::name))
    );

    private static final int LOSS_STANDARD = 1;
    private final int match;
    private final int price;
    private int count;

    Winning(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public static double getProfit(int amount) {
        int totalWinningPrice = Arrays.stream(Winning.values()).mapToInt(Winning::getWinningPrice).sum();
        return totalWinningPrice / (double)amount;
    }

    public static boolean isLoss(double profit) {
        return profit < LOSS_STANDARD;
    }

    public static void win(int match) {
        if(MAP.containsKey(match)) {
            Winning.valueOf(MAP.get(match)).plusCount();
        }
    }

    public int getMatch(){
        return match;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }

    private int getWinningPrice(){
        return count * price;
    }

    private void plusCount() {
        this.count++;
    }

}