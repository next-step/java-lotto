package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    public static final long TICKET_PRICE = 1000L;

    private List<LottoNumber> numbers;
    private LottoRank rank;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static int getLottoTicketCount(long paidAmount) {
        return (int) (paidAmount / TICKET_PRICE);
    }

    public void checkRank(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                matchCount += 1;
            }
        }

        decideLottoRank(matchCount);
    }

    private void decideLottoRank(int matchCount) {
        this.rank = LottoRank.getRank(matchCount);
    }

    public long getPrizeAmount() {
        return rank.getPrize();
    }
}
