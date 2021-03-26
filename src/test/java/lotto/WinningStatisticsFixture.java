package lotto;


import java.util.HashMap;
import java.util.Map;

public class WinningStatisticsFixture {
    public static WinningStatistics by(int first,
                                       int third,
                                       int fourth,
                                       int fifth
    ) {
        Map<WinningType, Integer> winningLog = new HashMap<>();
        winningLog.put(WinningType.FIRST, first);
        winningLog.put(WinningType.THIRD, third);
        winningLog.put(WinningType.FOURTH, fourth);
        winningLog.put(WinningType.FIFTH, fifth);
        return new WinningStatistics(winningLog, (first + third + fourth + fifth) * LottoStore.LOTTO_PRICE);
    }
}
