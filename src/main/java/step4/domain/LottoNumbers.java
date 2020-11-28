package step4.domain;

public class LottoNumbers {

    private Numbers numbers;
    private String bonusNumber;

    private LottoNumbers(Numbers numbers, String bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoNumbers of(Numbers numbers, String bonusNumber) {
        return new LottoNumbers(numbers, bonusNumber);
    }

    public Numbers getNumber() {
        return this.numbers;
    }

    public String getBonusNumber() {
        return this.bonusNumber;
    }
}
