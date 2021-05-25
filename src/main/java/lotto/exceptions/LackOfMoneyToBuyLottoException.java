package lotto.exceptions;

public class LackOfMoneyToBuyLottoException extends RuntimeException {
	public LackOfMoneyToBuyLottoException() {
		super("로또를 살 돈이 부족합니다.");
	}
}
