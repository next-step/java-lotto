package lottomanual.domain;

public class LottoBonusNumberException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "당첨번호와 중복되는 보너스번호 입니다.";

	public LottoBonusNumberException() {
		super(DEFAULT_MESSAGE);
	}

}
