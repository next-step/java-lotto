package step4.lotto.exception;

public class LottoMachineNotEnoughMoneyException extends LottoMachineException {

    public static final String MESSAGE = "로또 구입 금액이 부족합니다.";

    public LottoMachineNotEnoughMoneyException() {
        super(MESSAGE);
    }

}
