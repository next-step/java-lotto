package lotto;

import java.util.Arrays;
import java.util.List;

public class Rank {
    private static final int WIN_3 = 3;
    private static final int WIN_4 = 4;
    private static final int WIN_5 = 5;
    private static final int WIN_6 = 6;
    private static final Integer[] winPrice = {5_000, 50_000, 1_500_000, 2_000_000_000};
    private static Integer[] winResult = {0, 0, 0, 0};   // 3개, 4개, 5개, 6개 일치

    static void doWinResultProcess(int cnt) {
        if(cnt == WIN_3) {
            winResult[0]++;
        }
        if(cnt == WIN_4) {
            winResult[1]++;
        }
        if(cnt == WIN_5) {
            winResult[2]++;
        }
        if(cnt== WIN_6) {
            winResult[3]++;
        }
    }

    static List<Integer> makeWinResult() {
        return Arrays.asList(winResult);
    }

    static List<Integer> makeWinPrice() {
        return Arrays.asList(winPrice);
    }

}
