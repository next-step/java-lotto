package lotto.view.dto;

public class LottoWinnerDto implements Comparable<LottoWinnerDto> {
    private final long equalNumberCount;
    private final long prizeAmount;
    private final long winners;

    public LottoWinnerDto(long equalNumberCount, long prizeAmount, long winners) {
        this.equalNumberCount = equalNumberCount;
        this.prizeAmount = prizeAmount;
        this.winners = winners;
    }

    public long getEqualNumberCount() {
        return equalNumberCount;
    }

    @Override
    public String toString() {
        if (equalNumberCount == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(equalNumberCount);
        stringBuilder.append("개 일치 (");
        stringBuilder.append(prizeAmount);
        stringBuilder.append(")- ");
        stringBuilder.append(winners);
        stringBuilder.append("개" + System.lineSeparator());
        return stringBuilder.toString();
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
