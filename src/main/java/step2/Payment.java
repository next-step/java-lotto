package step2;

public class Payment {

	private static final int LOTTO_PRICE = 1000;

	public int lottoAmount(int cash) {
		if(cash < LOTTO_PRICE){
			throw new RuntimeException();
		}
		return cash / LOTTO_PRICE;
	}
}
