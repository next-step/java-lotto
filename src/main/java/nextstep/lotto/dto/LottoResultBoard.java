package nextstep.lotto.dto;

import java.util.Map;
import java.util.Set;

public class LottoResultBoard {

    public static final int LOTTO_VALUE = 1000;

    private Map<LottoRank, Long> lottoResult;

    private LottoResultBoard(Map<LottoRank, Long> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public static LottoResultBoard create(Map<LottoRank, Long> lottoResult) {
        return new LottoResultBoard(lottoResult);
    }

    public Map<LottoRank, Long> getLottoResult() {
        return lottoResult;
    }

    public float getBenefitRate() {
        Set<LottoRank> lottoRanks = lottoResult.keySet();
        double totalTicketCount = lottoRanks.stream()
                .mapToDouble(lottoResult::get)
                .sum();
        double totalReward = lottoRanks.stream()
                .mapToDouble(lottoRank -> (lottoResult.get(lottoRank) * lottoRank.getReward()))
                .sum();

        return (float) (totalReward / (totalTicketCount * LOTTO_VALUE));
    }
}
