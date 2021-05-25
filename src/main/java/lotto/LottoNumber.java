package lotto;

public class LottoNumber{

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;

	private int num;

	public LottoNumber(int num) {
		if(num < MIN_NUMBER || num > MAX_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 0보다 작거나 45보다 클 수 없습니다.");
		}
		this.num = num;
	}
}
