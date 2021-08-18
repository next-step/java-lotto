package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinnigResult {

    public static final long FIRST_EARN_MONEY = 2000000000;
    public static final long SECOND_EARN_MONEY = 1500000;
    public static final long THIRD_EARN_MONEY = 50000;
    public static final long FOURTH_EARN_MONEY = 5000;

    public static final String FIRST = "FIRST";
    public static final String SECOND = "SECOND";
    public static final String THIRD = "THIRD";
    public static final String FOURTH = "FOURTH";
    public static final String FIFTH = "FIFTH";
    public static final String MISS = "MISS";

    public static final int FOURTH_MATCH = 3;
    public static final int THIRD_MATCH = 4;
    public static final int SECOND_MATCH = 5;
    public static final int FIRST_MATCH = 6;

    public static final List<String> winStatus = Arrays.asList(
            FOURTH, THIRD, SECOND, FIRST
    );

    public String getLottoStatus(int matchCount) {
        String result = MISS;
        if (matchCount == FOURTH_MATCH) {
            result = FOURTH;
        }

        if (matchCount == THIRD_MATCH) {
            result = THIRD;
        }

        if (matchCount == SECOND_MATCH) {
            result = SECOND;
        }

        if (matchCount == FIRST_MATCH) {
            result = FIRST;
        }
        return result;
    }

    public long getEarnMoney(String status, int count) {

        if (status == FIRST) {
            return FIRST_EARN_MONEY * count;
        }

        if (status == SECOND) {
            return SECOND_EARN_MONEY * count;
        }

        if (status == THIRD) {
            return THIRD_EARN_MONEY * count;
        }

        return FOURTH_EARN_MONEY * count;
    }

}
