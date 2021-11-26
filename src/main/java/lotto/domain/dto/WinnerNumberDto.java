package lotto.domain.dto;

public class WinnerNumberDto {

    private final String winnerNumbers;
    private final int bonusNumber;

    private WinnerNumberDto(String winnerLottoTicket, int bonusNumber) {
        this.winnerNumbers = winnerLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerNumberDto from(String winnerLottoTicket, int bonusNumber) {
        return new WinnerNumberDto(winnerLottoTicket, bonusNumber);
    }

    public String getWinnerNumbers() {
        return winnerNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
