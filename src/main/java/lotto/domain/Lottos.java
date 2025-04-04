package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<LottoNumbers> lottoNumbers;
    private int manualLottoCount;
    private int autoLottoCount;

    public Lottos(List<LottoNumbers> lottoNumbers, int manualLottoCount, int autoLottoCount) {
        this.lottoNumbers = lottoNumbers;
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = autoLottoCount;
    }

    public List<LottoNumbers> lottoNumbers() {
        return lottoNumbers;
    }

    public int manualLottoCount() {
        return manualLottoCount;
    }

    public int autoLottoCount() {
        return autoLottoCount;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public LottoNumbers get(int index) {
        return lottoNumbers.get(index);
    }

    public boolean contains(LottoNumbers numbers) {
        return lottoNumbers.contains(numbers);
    }

    public LottoWinningRecord match(WinningLottoNumbers winningLottoNumbers) {
        Map<LottoRank, Integer> lottoWinningBoardMap = initializeLottoWinningBoardMap();
        calculateMatchStats(lottoWinningBoardMap, winningLottoNumbers);

        return new LottoWinningRecord(lottoWinningBoardMap);
    }

    private void calculateMatchStats(Map<LottoRank, Integer> rank, WinningLottoNumbers winningLottoNumbers) {
        lottoNumbers.forEach(lottoNumber -> {
            LottoRank lottoRank = winningLottoNumbers.lottoRank(lottoNumber);
            rank.merge(lottoRank, 1, Integer::sum);
        });
    }

    private static Map<LottoRank, Integer> initializeLottoWinningBoardMap() {
        Map<LottoRank, Integer> rankMap = new EnumMap<>(LottoRank.class);
        for(LottoRank lottoRank: LottoRank.values()) {
            rankMap.put(lottoRank, 0);
        }
        return rankMap;
    }
}