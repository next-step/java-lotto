package lottomanual.domain;

public class LottoManualCountException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "수동 구매 수량이 전체 금액보다 클 수 없습니다.";

	public LottoManualCountException() {
		super(DEFAULT_MESSAGE);
	}

}
