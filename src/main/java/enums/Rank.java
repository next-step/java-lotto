package enums;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    FIRST_PLACE(6,2000000000),
    SECOND_PLACE(5,1500000),
    THIRD_PLACE(4,50000),
    FOUR_PLACE(3,5000),
    Whack(0,0);

    private int count;
    private int price;

    Rank(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static int findTotalWinnings(List<Rank> ranks){
        return ranks
            .stream()
            .map(Rank::getPrice)
            .reduce(0, Integer::sum);
    }

    public static Rank find(long count){
        Rank rank = Arrays.stream(values())
            .filter(winningsPrice -> winningsPrice.count == count)
            .findFirst()
            .orElse(Whack);
        return rank;
    }
}
