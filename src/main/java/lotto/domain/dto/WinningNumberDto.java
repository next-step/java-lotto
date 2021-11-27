package lotto.domain.dto;

public class WinningNumberDto {

    private final String winnerNumbers;
    private final int bonusNumber;

    private WinningNumberDto(String winnerLottoTicket, int bonusNumber) {
        this.winnerNumbers = winnerLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumberDto from(String winnerLottoTicket, int bonusNumber) {
        return new WinningNumberDto(winnerLottoTicket, bonusNumber);
    }

    public String getWinnerNumbers() {
        return winnerNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
