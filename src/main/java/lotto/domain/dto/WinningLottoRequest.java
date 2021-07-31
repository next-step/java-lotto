package lotto.domain.dto;

public class WinningLottoRequest {
    private final String lottoNumbers;
    private final int bonusNumber;

    public WinningLottoRequest(String lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String lottoNumbers() {
        return lottoNumbers;
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
