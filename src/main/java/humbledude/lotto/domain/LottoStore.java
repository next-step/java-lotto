package humbledude.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    public static final long LOTTO_TICKET_PRICE = 1000;

    private LottoWinningNumbers winningNumbers;
    private static final Map<Integer, LottoPrize> prizeMap;

    static {
        prizeMap = new HashMap<Integer, LottoPrize>() {{
            put(LottoPrize.FIRST.getMatchedCount(), LottoPrize.FIRST);
            put(LottoPrize.SECOND.getMatchedCount(), LottoPrize.SECOND);
            put(LottoPrize.THIRD.getMatchedCount(), LottoPrize.THIRD);
            put(LottoPrize.FOURTH.getMatchedCount(), LottoPrize.FOURTH);
        }};
    }

    public LottoStore() {}

    public void setWinningNumbers(LottoWinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<LottoTicket> buyAutoTickets(long budget) {
        long howMany = howManyCanIBuy(budget);

        return LongStream.range(0, howMany)
                .mapToObj(i -> AutoLotto.buildTicket())
                .collect(Collectors.toList());
    }

    public long howManyCanIBuy(long budget) {
        return budget / LOTTO_TICKET_PRICE;
    }

    public Map<LottoPrize, List<LottoTicket>> claimPrizeForMultipleTickets(List<LottoTicket> tickets) {
        return tickets.stream().collect(
                Collectors.groupingBy(this::claimPrize));
    }

    public LottoPrize claimPrize(LottoTicket ticket) {
        if (winningNumbers == null) {
            throw new IllegalStateException("당첨번호가 입력되지 않았습니다.");
        }

        int matchedCount = winningNumbers.getMatchedCountWith(ticket);
        if (prizeMap.containsKey(matchedCount)) {
            return prizeMap.get(matchedCount);
        }
        return LottoPrize.BLANK;
    }
}
