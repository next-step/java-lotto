package lotto.exceptions;

public class InvalidLottoAmountException extends RuntimeException {

    public InvalidLottoAmountException(int lottoPrice, int amount) {
        super("로또는 1장당 " + lottoPrice + " 원입니다. 입력 금액 : " + amount);
    }
}
