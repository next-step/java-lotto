package lotto.domain;

//TODO 사용해서 로직..작성해보기
public class LottoNumber {

    private int lottoNumber;

    public LottoNumber(String input) {
        this.lottoNumber = this.validatorValue(Integer.valueOf(input));
    }

    public LottoNumber(int input) {
        this.lottoNumber = this.validatorValue(Integer.valueOf(input));
    }

    public Integer validatorValue(Integer value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("1 이상 45 이하의 수를 입력해주세요");
        }
        return value;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

}
