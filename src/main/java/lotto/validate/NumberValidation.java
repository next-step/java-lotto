package lotto.validate;

public class NumberValidation {

    public boolean checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
        }
        return true;
    }
}
