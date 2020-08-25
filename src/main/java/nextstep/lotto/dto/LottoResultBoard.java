package nextstep.lotto.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResultBoard {

    public static final int LOTTO_VALUE = 1000;

    private Map<LottoRank, Long> lottoResult = new HashMap();

    private LottoResultBoard(LottoTickets userLottoTickets, LottoWinnerNumbers winnerTicket) {
        this.lottoResult = userLottoTickets.matchCount(winnerTicket);
    }

    public static LottoResultBoard create(LottoTickets userLottoTickets, LottoWinnerNumbers winnerTicket) {

        return new LottoResultBoard(userLottoTickets, winnerTicket);
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
