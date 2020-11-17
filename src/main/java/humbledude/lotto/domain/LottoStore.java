package humbledude.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    public static final long LOTTO_TICKET_PRICE = 1000;

    private LottoWinningNumbers winningNumbers;

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

    public LottoPrize claimPrize(LottoTicket ticket) {
        if (winningNumbers == null) {
            throw new IllegalStateException("당첨번호가 입력되지 않았습니다.");
        }

        int matchedCount = winningNumbers.getMatchedCountWith(ticket);
        return LottoPrize.of(matchedCount);
    }
}
