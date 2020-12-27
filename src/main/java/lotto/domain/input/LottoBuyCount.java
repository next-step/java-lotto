package lotto.domain.input;

public class LottoBuyCount {

	private int lottoBuyCount;

	public LottoBuyCount(int lottoBuyCount) {
		isPositiveNumber(lottoBuyCount);
		this.lottoBuyCount = lottoBuyCount;
	}

	private void isPositiveNumber(int lottoBuyCount) {
		if(lottoBuyCount < 0){
			throw new IllegalArgumentException();
		}
	}

	public int getLottoBuyCount() {
		return lottoBuyCount;
	}

	public LottoBuyCount getAutoLottoCount(LottoBuyCount manualLottoCount) {
		return new LottoBuyCount(this.lottoBuyCount - manualLottoCount.lottoBuyCount);
	}
}
