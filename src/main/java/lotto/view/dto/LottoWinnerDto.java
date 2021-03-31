package lotto.view.dto;

public class LottoWinnerDto implements Comparable<LottoWinnerDto> {
    private final long equalNumberCount;
    private final long prizeAmount;
    private final long winners;
    private final String message;

    public LottoWinnerDto(long equalNumberCount, long prizeAmount, long winners, String message) {
        this.equalNumberCount = equalNumberCount;
        this.prizeAmount = prizeAmount;
        this.winners = winners;
        this.message = message;
    }

    public long getEqualNumberCount() {
        return equalNumberCount;
    }

    @Override
    public String toString() {
        return String.format(message, winners);
    }

    @Override
    public int compareTo(LottoWinnerDto o) {
        if (prizeAmount > o.prizeAmount) {
            return 1;
        }
        if (prizeAmount < o.prizeAmount) {
            return -1;
        }
        return 0;
    }
}
