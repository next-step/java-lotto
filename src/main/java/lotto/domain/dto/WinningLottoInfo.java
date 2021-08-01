package lotto.domain.dto;

public class WinningLottoInfo {
    private final String lottoNumbers;
    private final int bonusNumber;

    public WinningLottoInfo(String lottoNumbers, int bonusNumber) {
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
