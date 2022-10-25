package lotto.models.request;

public class WinningLottoRequest {

    private final String lottoNumber;
    private final int bonusNumber;

    private WinningLottoRequest(String lottoNumber, int bonusNumber) {
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningNumber() {
        return lottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinningLottoRequest of(String lottoNumberRequest, int bonusNumber) {
        return new WinningLottoRequest(lottoNumberRequest, bonusNumber);
    }
}
