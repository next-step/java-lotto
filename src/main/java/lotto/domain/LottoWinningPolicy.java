package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningPolicy {

    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
    private final Map<LottoRank, Integer> result = new HashMap<LottoRank, Integer>() {{
        put(LottoRank.RANK_1ST, 0);
        put(LottoRank.RANK_2ND, 0);
        put(LottoRank.RANK_3RD, 0);
        put(LottoRank.RANK_4TH, 0);
        put(LottoRank.RANK_5TH, 0);
        put(LottoRank.RANK_6TH, 0);
        put(LottoRank.RANK_7TH, 0);
    }};

    public void setWinningNumber(final String winningNumbersString) {
        lottoWinningNumber.selectWinningNumbers(winningNumbersString);
    }

    public List<Integer> getWinningNumber() {
        return lottoWinningNumber.getWinningNumber();
    }

    public void setResult(LottoGame lottoGame){
        List<LottoTicket> lottoTickets = lottoGame.getTickets();
        for (LottoTicket lottoTicket : lottoTickets){
            result.put(lottoTicket.getLottoRank(), result.get(lottoTicket.getLottoRank()) + 1);
        }
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public int getPrice(){
        int sum = 0;
        sum += result.get(LottoRank.RANK_4TH) * LottoRank.RANK_4TH.getPrice();
        sum += result.get(LottoRank.RANK_3RD) * LottoRank.RANK_3RD.getPrice();
        sum += result.get(LottoRank.RANK_2ND) * LottoRank.RANK_2ND.getPrice();
        sum += result.get(LottoRank.RANK_1ST) * LottoRank.RANK_1ST.getPrice();
        return sum;
    }
}
