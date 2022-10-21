package lotto.models.request;

public class WinningLottoRequest {

    private final LottoNumberRequest lottoNumberRequest;
    private final int bonusNumber;

    private WinningLottoRequest(LottoNumberRequest lottoNumberRequest, int bonusNumber) {
        this.lottoNumberRequest = lottoNumberRequest;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumberRequest getWinningNumber() {
        return lottoNumberRequest;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinningLottoRequest of(LottoNumberRequest lottoNumberRequest, int bonusNumber) {
        return new WinningLottoRequest(lottoNumberRequest, bonusNumber);
    }
}
