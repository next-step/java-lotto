package lotto.domain;

public class WInningLottoRequest {
    private String lottoNumbers;
    private int bonusNumber;

    public WInningLottoRequest(String lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
