package nextstep.lotto.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoResultBoard {

    public static final int LOTTO_VALUE = 1000;

    private Map<LottoRank,Integer> lottoResult = new HashMap();

    public LottoResultBoard() {}
    public LottoResultBoard(LottoTickets userLottoTickets,LottoTicket winnerTicket) {
        this.lottoResult = new HashMap();

        for(LottoTicket ticket : userLottoTickets.getAll()){
            addLottoResult(ticket.matchCount(winnerTicket.getLottoNumber()));
        }
    }

    public static LottoResultBoard create(LottoTickets userLottoTickets,LottoTicket winnerTicket){
        return new LottoResultBoard(userLottoTickets, winnerTicket);
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
