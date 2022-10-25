package lotto.models.request;

public class WinningLottoRequest {

    private final String lottoNumberRequest;
    private final int bonusNumber;

    private WinningLottoRequest(String lottoNumberRequest, int bonusNumber) {
        this.lottoNumberRequest = lottoNumberRequest;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningNumber() {
        return lottoNumberRequest;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinningLottoRequest of(String lottoNumberRequest, int bonusNumber) {
        return new WinningLottoRequest(lottoNumberRequest, bonusNumber);
    }
}
