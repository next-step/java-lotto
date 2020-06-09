package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {
    private List<Lotto> lottoList;
    private Map<Integer, Integer> winLottoCountMap;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.winLottoCountMap = new HashMap<>();
    }

    public void generateLotto() {
        lottoList.forEach(Lotto::generateNumber);
    }

    public void calcWinLottoCountMap(List<String> winningNumber) {
        lottoList.forEach(lotto -> {
            int matchCount = lotto.getMatchCount(winningNumber);
            if (matchCount > 2)
                addCountMap(matchCount);
        });
    }

    private void addCountMap(int matchCount) {
        if (winLottoCountMap.containsKey(matchCount)) {
            winLottoCountMap.put(matchCount, winLottoCountMap.get(matchCount) + 1);
        }
        winLottoCountMap.put(matchCount, 1);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Map<Integer, Integer> getWinLottoCountMap() {
        return winLottoCountMap;
    }
}
