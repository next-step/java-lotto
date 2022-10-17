package lotto.models.request;

public class WinningLottoRequest {

    private final String winningNumber;
    private final int bonusNumber;

    private WinningLottoRequest(String winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinningLottoRequest of(String winningNumber, int bonusNumber) {
        return new WinningLottoRequest(winningNumber, bonusNumber);
    }
}
