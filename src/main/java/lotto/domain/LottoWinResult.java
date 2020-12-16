package lotto.domain;

import java.util.*;

public class LottoWinResult {

    private Map<LottoWinPrize, Integer> winResultCounts = new HashMap<>();

    public LottoWinResult() {
        Arrays.stream(LottoWinPrize.values())
                .forEach(lottoWinPrize -> winResultCounts.put(lottoWinPrize, 0));
    }

    /**
     * 입력된 수에 해당하는 당첨 케이스를 찾아서 당첨 케이스의 당첨 수를 증가시킵니다.
     * @param matchedCount
     */
    public void addWinResultCount(int matchedCount) {
        LottoWinPrize.getLottoWinPrize(matchedCount)
                .ifPresent(this::addWinResultCount);
    }

    /**
     * 당첨 케이스의 당첨 수를 증가시킵니다.
     * @param lottoWinPrize
     */
    public void addWinResultCount(LottoWinPrize lottoWinPrize) {
        this.winResultCounts.put(lottoWinPrize, this.winResultCounts.get(lottoWinPrize) + 1);

    }

    /**
     * 입력한 당첨 케이스에 당첨 된 수를 리턴합니다.
     * @param lottoWinPrize
     * @return
     */
    public int getCount(LottoWinPrize lottoWinPrize) {
        return this.winResultCounts.get(lottoWinPrize);
    }
}
