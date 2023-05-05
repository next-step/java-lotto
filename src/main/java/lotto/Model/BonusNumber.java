package lotto.Model;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }

        LottoNumber lottoNumber = new LottoNumber(number);

        this.number = lottoNumber.number();
    }

    public int number() {
        return number;
    }
}
