package lotto.domain;

import java.util.*;

public class LottoResult {

    private final List<LottoRank> DISPLAY_LOTTO_RANKS = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
    private final Map<LottoRank, Long> lottoResult;

    public LottoResult(int lottoCount, Lottos lottos, LottoWinNumbers lottoWinNumbers, BonusBall bonusBall) {
        lottoResult = new EnumMap<>(LottoRank.class);
        initLottoResult();
        createLottoResult(lottoCount, lottos, lottoWinNumbers, bonusBall);
    }

    private void initLottoResult() {
        for (LottoRank lottoRank : DISPLAY_LOTTO_RANKS) {
            lottoResult.put(lottoRank, 0L);
        }
    }

    private void createLottoResult(int lottoCount, Lottos lottos, LottoWinNumbers lottoWinNumbers, BonusBall bonusBall) {
        for (int i = 0; i < lottoCount; i++) {
            LottoRank rank = lottos.matchCount(i, lottoWinNumbers, bonusBall);
            lottoResult.merge(rank, 1L, Long::sum);
        }
    }

    public List<LottoWinResult> lottoStatistics() {
        List<LottoWinResult> lottoWinResults = new ArrayList<>();
        lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.MISS)
                .forEach(entry -> lottoWinResults.add(new LottoWinResult(entry.getKey().getMatchCount(), entry.getValue(), entry.getKey().isBonus())));
        return lottoWinResults;
    }

    public Map<LottoRank, Long> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
