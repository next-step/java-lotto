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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(equalNumberCount);
        stringBuilder.append("개 일치 (");
        stringBuilder.append(prizeAmount);
        stringBuilder.append(")- ");
        stringBuilder.append(winners);
        stringBuilder.append("개");
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(LottoWinnerDto o) {
        if (equalNumberCount > o.equalNumberCount) {
            return 1;
        }
        if (equalNumberCount < o.equalNumberCount) {
            return -1;
        }
        return 0;
    }
}
