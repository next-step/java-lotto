package lotto.domain;

public class LottoCount {
	private int lottoCount;

	public LottoCount(int count) {
		validateLottoCount(count);
		this.lottoCount = count;
	}

	private void validateLottoCount(int count) {
		if(count < 0) {
			throw new IllegalArgumentException("로또 개수는 0보다 작을 수 없습니다.");
		}
	}

	public int getCount() {
		return this.lottoCount;
	}
}
