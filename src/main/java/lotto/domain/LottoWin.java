package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWin {

    private final Integer[] winNumber;
    private final Map<Integer, Integer> winCountMap;

    public LottoWin(Integer[] winNumber) {
        this.winNumber = winNumber;
        this.winCountMap = new HashMap<>();
    }

    public void countMatchingNumber(LottoTicket lottoTicket) {
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();

        int matchingCount = countMatches(lottoNumbers);

        updateWinCountMap(matchingCount);
    }

    private int countMatches(List<Integer> lottoNumbers) {
        int matchingCount = 0;

        for(Integer number : winNumber) {
            if(lottoNumbers.contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private void updateWinCountMap(int matchingCount) {
        winCountMap.put(matchingCount, winCountMap.getOrDefault(matchingCount, 0) + 1);
    }

    public boolean isMatchingCount(int count) {
        return winCountMap.getOrDefault(count, 0) > 0;
    }
}
