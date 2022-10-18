package lotto;

import java.util.List;

public class LottoTicket {

    public static final long TICKET_PRICE = 1000L;
    public static final int LOTTO_NUMBER_COUNT = 6;

    final private List<LottoNumber> numbers;
    private LottoRank rank;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoRank getRank() {
        return rank;
    }

    public static int getLottoTicketCount(long paidAmount) {
        return (int) (paidAmount / TICKET_PRICE);
    }

    public void checkRank(List<LottoNumber> winningNumbers) {
        int matchCount = 0;
        for (LottoNumber winningNumber : winningNumbers) {
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

    public boolean isRank(LottoRank rank) {
        return this.rank == rank;
    }

    public String toNumbersString() {
        return numbers.toString();
    }
}
