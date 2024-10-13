package lotto.fixture;

import java.util.List;

public class BuyerFixture {
    public static final int LOTTOES_BUY_COUNT_FIXTURE = 14;
    //8, 21, 23, 41, 42, 43
    public static final List<Integer[]> LOTTOES_FIXTURE = List.of(
            new Integer[]{8, 21, 23, 41, 42, 43},//111111-1
            new Integer[]{3, 5, 11, 16, 32, 38},//
            new Integer[]{7, 11, 16, 35, 36, 44},//
            new Integer[]{1, 8, 11, 31, 41, 42},//111-4
            new Integer[]{13, 14, 16, 38, 42, 45},//1
            new Integer[]{7, 11, 30, 40, 42, 43},//11
            new Integer[]{2, 13, 22, 32, 38, 45},//
            new Integer[]{23, 25, 33, 36, 39, 41},//11
            new Integer[]{1, 3, 5, 14, 22, 45},//
            new Integer[]{5, 9, 38, 41, 43, 44},//11
            new Integer[]{2, 8, 9, 18, 19, 21},//11
            new Integer[]{13, 14, 18, 21, 23, 35},//11
            new Integer[]{17, 21, 29, 37, 42, 45},//11
            new Integer[]{3, 8, 27, 30, 35, 44}//1
    );
}
