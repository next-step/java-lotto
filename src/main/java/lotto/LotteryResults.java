package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WiningLottoTicket;

import java.util.HashMap;
import java.util.Map;

public class LotteryResults {

    private Map<LottoRank, Integer> lottoResults;

    public LotteryResults(WiningLottoTicket winingLottoTicket, UserLottoTickets buyLottoTickets) {
        this.lottoResults = initLottoResultMap();
        saveLotteryResult(winingLottoTicket, buyLottoTickets);
    }

    public Map<LottoRank, Integer> getLottoResults() {
        return lottoResults;
    }

    private Map<LottoRank, Integer> initLottoResultMap() {
        lottoResults = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.put(rank, 0);
        }
        return lottoResults;
    }

    private void saveLotteryResult(WiningLottoTicket winingLottoTicket, UserLottoTickets buyUserLottoTickets) {
        for (LottoTicket buyLottoTicket : buyUserLottoTickets.getUserLottoTickets()) {
            LottoRank rank = getLottoRank(winingLottoTicket, buyLottoTicket);
            lottoResults.put(rank, lottoResults.get(rank) + 1);
        }
    }

    private static LottoRank getLottoRank(WiningLottoTicket winingLottoTicket, LottoTicket userLottoTicket) {
        int countNum = winingLottoTicket.checkLottoNumber(userLottoTicket);
        boolean isBonusNumber = winingLottoTicket.checkBonusNumber(userLottoTicket);
        return LottoRank.valueOf(countNum,isBonusNumber);
    }



}
