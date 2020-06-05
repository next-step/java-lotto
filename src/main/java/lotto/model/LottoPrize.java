package lotto.model;

public class LottoPrize {
    public static final int FIRST_PRIZE  = 2000000000;
    public static final int FIRST_COUNT  = 6;
    public static final int SECOND_PRIZE = 1500000;
    public static final int SECOND_COUNT = 5;
    public static final int THIRD_PRIZE  = 50000;
    public static final int THIRD_COUNT  = 4;
    public static final int FOURTH_PRIZE = 5000;
    public static final int FOURTH_COUNT = 3;

    public static int getLottoPrize(int matchingNumber){
        if(matchingNumber == FOURTH_COUNT) {
            return FOURTH_PRIZE;
        }
        if(matchingNumber == THIRD_COUNT) {
            return THIRD_PRIZE;
        }
        if(matchingNumber == SECOND_COUNT) {
            return SECOND_PRIZE;
        }
        if(matchingNumber == FIRST_COUNT) {
            return FIRST_PRIZE;
        }
        return 0;
    }
}
