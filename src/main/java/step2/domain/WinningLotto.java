package step2.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningLotto {

    private final int[] winningNumbers;
    private final LinkedHashMap<Integer,Integer> LOTTO_WINNING_INFO = new LinkedHashMap<>();
    public WinningLotto(int[] winningNumbers) {
        this.winningNumbers = winningNumbers;

        LOTTO_WINNING_INFO.put(LottoWinningInfo.MATCH_THREE.getMatchCount(), LottoWinningInfo.MATCH_THREE.getWinningMoney());
        LOTTO_WINNING_INFO.put(LottoWinningInfo.MATCH_FOUR.getMatchCount(), LottoWinningInfo.MATCH_FOUR.getWinningMoney());
        LOTTO_WINNING_INFO.put(LottoWinningInfo.MATCH_FIVE.getMatchCount(), LottoWinningInfo.MATCH_FIVE.getWinningMoney());
        LOTTO_WINNING_INFO.put(LottoWinningInfo.MATCH_SIX.getMatchCount(), LottoWinningInfo.MATCH_SIX.getWinningMoney());
    }

    public WinningInfos winningInfo(Lottos lottos){
        return winningInfos(extractWinningCountMap(lottos));
    }

    private LinkedHashMap<Integer, Integer> extractWinningCountMap(Lottos lottos) {
        LinkedHashMap<Integer, Integer> winningCountMap = new LinkedHashMap<>();
        for(Lotto lotto: lottos.getLottos()){
            extractFromEachLotto(winningCountMap, lotto);
        }
        return winningCountMap;
    }

    private void extractFromEachLotto(LinkedHashMap<Integer, Integer> winningCountMap, Lotto lotto) {
        for(Map.Entry<Integer, Integer> entry: LOTTO_WINNING_INFO.entrySet()){
            int key = entry.getKey();
            if(getMatchCount(lotto) == key){
                winningCountMap.put(key, winningCountMap.getOrDefault(key, 0) + 1);
            }
        }
    }

    private WinningInfos winningInfos(LinkedHashMap<Integer, Integer> winningCountMap) {
        WinningInfos result = new WinningInfos();
        for(Map.Entry<Integer, Integer> entry: winningCountMap.entrySet()){
            result.addWinningInfo(new WinningInfo(entry.getKey(), LOTTO_WINNING_INFO.get(entry.getKey()), entry.getValue()));
        }
        return result;
    }

    private int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for(LottoNumber lottonumber :lotto.lottoNumbers()){
            matchCount = matchEachLottoNumber(lottonumber);
        }
        return matchCount;
    }

    private int matchEachLottoNumber(LottoNumber lottonumber) {
        int matchCount = 0;
        for(int winningNumber : winningNumbers){
            if(lottonumber.number() == winningNumber){
                matchCount++;
            };
        }
        return matchCount;
    }

}
