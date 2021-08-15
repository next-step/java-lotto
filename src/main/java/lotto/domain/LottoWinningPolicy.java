package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinningPolicy {

    private LottoNumbers lottoNumbers;
    private final Map<LottoRank, Integer> result = new EnumMap<LottoRank, Integer>(
        LottoRank.class) {
        {
            put(LottoRank.FIRST, 0);
            put(LottoRank.SECOND, 0);
            put(LottoRank.THIRD, 0);
            put(LottoRank.FOURTH, 0);
            put(LottoRank.FAIL, 0);
        }
    };


    public void setWinningNumber(final List<Integer> numbers) {
        lottoNumbers = new LottoNumbers(numbers);
    }

    public List<Integer> getWinningNumber() {
        return lottoNumbers.getLottoNumbers();
    }

    public void setResult(Lotto lotto) {
        List<LottoTicket> lottoTickets = lotto.getTickets();

        lottoTickets.forEach(lottoTicket -> result.put(lottoTicket.getLottoRank(),
            result.get(lottoTicket.getLottoRank()) + 1));
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public int calculateWinningPrice() {
        int sum = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            sum += result.get(lottoRank) * lottoRank.getPrice();
        }
        return sum;
    }
}
