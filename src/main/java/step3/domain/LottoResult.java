package step3.domain;

import java.util.Map;

public class LottoResult {
    private static final int ALL_WINNINGS =  2000000000;
    private static final int FIVE_WINNINGS =  1500000;
    private static final int FOUR_WINNINGS =  50000;
    private static final int THREE_WINNINGS =  5000;

    private Map<Integer, Long> lottoResultMap;

    public LottoResult(Map<Integer, Long> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public long winningResult(int count) {
        return lottoResultMap.getOrDefault(count,0l);
    }

    public long winnings() {
        return (ALL_WINNINGS * winningResult(6)
                        + FIVE_WINNINGS * winningResult(5)
                        + FOUR_WINNINGS * winningResult(4)
                        + THREE_WINNINGS * winningResult(3));
    }
}
