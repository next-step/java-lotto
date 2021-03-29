package lotto.view.dto;

public class LottoWinnerDto {
    private final long equalNumberCount;
    private final long prizeAmount;
    private final long winners;

    public LottoWinnerDto(long equalNumberCount, long prizeAmount, long winners) {
        this.equalNumberCount = equalNumberCount;
        this.prizeAmount = prizeAmount;
        this.winners = winners;
    }

}
