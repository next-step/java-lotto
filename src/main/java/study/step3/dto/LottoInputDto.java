package study.step3.dto;

public class LottoInputDto {

    private String lottoNumbers;
    private int bonusBall;

    public LottoInputDto(String lottoNumbers, int bonusBall) {
        this.lottoNumbers = lottoNumbers;
        this.bonusBall = bonusBall;
    }

    public String getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
