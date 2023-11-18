package lotto.domain;

import java.util.*;

public class LottoResult {

    private final List<LottoRank> DISPLAY_LOTTO_RANKS = List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
    private final Map<LottoRank, Long> lottoResult;

    public LottoResult(Lottos lottos, LottoWin lottoWin) {
        lottoResult = new EnumMap<>(LottoRank.class);
        initLottoResult();
        createLottoResult(lottos, lottoWin);
    }

    private void initLottoResult() {
        for (LottoRank lottoRank : DISPLAY_LOTTO_RANKS) {
            lottoResult.put(lottoRank, 0L);
        }
    }

    private void createLottoResult(Lottos lottos, LottoWin lottoWin) {
        List<LottoRank> ranks = lottos.matchCount(lottoWin);
        for (LottoRank rank : ranks) {
            lottoResult.merge(rank, 1L, Long::sum);
        }
    }

    public int totalLottoIncome() {
        return lottoResult.entrySet().stream()
                .mapToInt(this::lottoIncome)
                .sum();
    }

    private int lottoIncome(Map.Entry<LottoRank, Long> lottoResult) {
        return lottoResult.getKey().getPrizeAmount() * lottoResult.getValue().intValue();
    }

    public Map<LottoRank, Long> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoRank lottoRank : DISPLAY_LOTTO_RANKS) {
            long winCount = lottoResult.getOrDefault(lottoRank, 0L);
            sb.append(lottoRank.getMatchCount()).append("개 일치");
            toStringIsBonus(lottoRank, sb);
            toStringPrizeMount(lottoRank, sb, winCount);
        }
        return sb.toString();
    }

    private void toStringPrizeMount(LottoRank lottoRank, StringBuilder sb, long winCount) {
        sb.append(" (").append(lottoRank.getPrizeAmount()).append("원) - ")
                .append(winCount).append("개");
        if (lottoRank != LottoRank.FIRST) {
            sb.append("\n");
        }
    }

    private void toStringIsBonus(LottoRank rank, StringBuilder sb) {
        if (rank.isBonus()) {
            sb.append(", 보너스 볼 일치");
        }
    }
}
