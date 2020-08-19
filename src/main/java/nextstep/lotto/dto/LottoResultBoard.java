package nextstep.lotto.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResultBoard {

    public static final int LOTTO_VALUE = 1000;

    private Map<LottoRank,Integer> lottoResult;

    public LottoResultBoard() {
        this.lottoResult = new HashMap();
    }

    public void addLottoResult(LottoRank lottoRank){
        int count = 0;
        if (lottoResult.containsKey(lottoRank)) {
            count = lottoResult.get(lottoRank);
        }
        lottoResult.put(lottoRank,count+1);
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public float getBenefitRate(){
        int totalReward = 0;
        int totalTicketCount = 0;
        Set<LottoRank> lottoRanks = lottoResult.keySet();
        for(LottoRank lottoRank : lottoRanks) {
            int ticketCount = lottoResult.get(lottoRank);
            totalTicketCount += ticketCount;
            totalReward += ticketCount * lottoRank.getReward();
        }

        return totalReward / (totalTicketCount * LOTTO_VALUE);
    }
}
