package edu.nextstep.lotto.domain;

public class LottoNumber {
	public static final int START_LIMIT = 1;
	public static final int END_LIMIT = 45;
	private final int lottoNumber;

	public LottoNumber(int number) {
		if (number < START_LIMIT || number > END_LIMIT) {
			throw new IllegalArgumentException("로또 번호는 " + START_LIMIT + "부터 " + END_LIMIT + " 사이만 가능합니다.");
		}
		this.lottoNumber = number;
	}
}