package lotto.models.request;

public class WinningLottoRequest {

    private String winningNumber;
    private int bonusNumber;

    public WinningLottoRequest(String winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
