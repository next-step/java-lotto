package lotto.domain;

public class LottoCalculator {

	public static int getAvailableLottoNumbers(long money) {
		validMoney(money);
		return (int) (money / LottoNumbers.LOTTO_PRICE);
	}

	private static void validMoney(long money) {
		if (money < 1000) {
			throw new IllegalArgumentException("로또을 사려면 1000원 이상 있어야 합니다.");
		}
	}

	public static double getRateOfReturn(long initMoney, long getMoney) {
		double rate = (double) getMoney / initMoney;
		return (Math.floor(rate * 100) / 100.0);
	}

}
