package lotto.validate;

public class InputValidation {

    public void inputValidate(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 이상 입력해야 합니다.");
        }
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 가능합니다.");
        }
    }
}
