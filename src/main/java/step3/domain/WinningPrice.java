package step2.domain;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Arrays;

public enum WinningPrice {
    FIRST_PRIZE(6,2000000000),
    SECOND_PRIZE(5,1500000),
    THIRD_PRIZE(4,50000),
    FOURTH_PRIZE(3,5000),
    OTHER(0,0);

    private int count;
    private int price;


    WinningPrice( int count,int price)  {
        this.count = count;
        this.price = price;
    }


   public static int getPrice(int winningNumbers) {
        return Arrays.stream(WinningPrice.values())
                .filter(priceValue -> priceValue.checkCount(winningNumbers) )
                .findAny()
                .orElse(OTHER).price;
    }

    public boolean checkCount(int winningNumber) {
        return (count == winningNumber);
    }

}
