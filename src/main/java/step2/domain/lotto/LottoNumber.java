package step2.domain.lotto;

public class LottoNumber {
    private Integer number;

    public LottoNumber(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1이상 45이하의 숫자만 가능합니다");
        }
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
