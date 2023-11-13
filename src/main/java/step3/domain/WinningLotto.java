package step3.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private final Lotto winningNumbersLotto;
    private final LinkedHashMap<Integer,Integer> LOTTO_WINNING_INFO_MAP = new LinkedHashMap<>();
    private static final List<Integer> winningCountList = List.of(3,4,5,6);


    public WinningLotto(Lotto winningNumbersLotto) {
        this.winningNumbersLotto = winningNumbersLotto;
        for(int winningCount: winningCountList){
            LOTTO_WINNING_INFO_MAP.put(LottoWinningInfo.matchCount(winningCount), LottoWinningInfo.winningMoney(winningCount));
        }
    }

    public WinningInfos winningInfos(Lottos lottos){
        WinningInfos result = new WinningInfos(lottos);
        process(lottos, result);
        return result;
    }

    private void process(Lottos lottos, WinningInfos result) {
        for(Map.Entry<Integer, Integer> matchCountInfo: extractWinningCountMap(lottos).entrySet()){
            int matchCount = matchCountInfo.getKey();
            result.addWinningInfo(new WinningInfo(matchCount, LOTTO_WINNING_INFO_MAP.get(matchCount), matchCountInfo.getValue()));
        }
    }

    private LinkedHashMap<Integer, Integer> extractWinningCountMap(Lottos lottos) {
        LinkedHashMap<Integer, Integer> winningCountMap = new LinkedHashMap<>();
        for(Lotto lotto: lottos.getLottos()){
            extractFromEachLotto(winningCountMap, lotto);
        }
        return winningCountMap;
    }

    private void extractFromEachLotto(LinkedHashMap<Integer, Integer> winningCountMap, Lotto lotto) {
        for(Map.Entry<Integer, Integer> entry: LOTTO_WINNING_INFO_MAP.entrySet()){
            int key = entry.getKey();
            if(lotto.matchCount(winningNumbersLotto) == key){
                winningCountMap.put(key, winningCountMap.getOrDefault(key, 0) + 1);
            }
        }
    }


}
