package enums;

import java.util.Arrays;

public enum Rank {

    FIRST_PLACE(6,2_000_000_000),
    SECOND_PLACE(5,10_000_000),
    THIRD_PLACE(5,1_500_000),
    FOUR_PLACE(4,50_000),
    FIVE_PLACE(3,5_000),
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

    public static Rank find(long count, boolean matchBonus){
        if(matchBonus && Rank.SECOND_PLACE.count == count){
            return SECOND_PLACE;
        }

        return Arrays.stream(values())
            .filter(winningsPrice -> winningsPrice.count == count)
            .findFirst()
            .orElse(Whack);
    }
}
