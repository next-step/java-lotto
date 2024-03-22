package step2;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public LottoNumber(String number) {
        isNumeric(number);
        this.number = Integer.parseInt(number);
        validateNumber(this.number);
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void isNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean matchedNumber(int number) {
        return this.number == number;
    }
}
