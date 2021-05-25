package lotto;

public class MockupInterface implements UserInterface {

	public static final String MONEY = "10000";
	public static final String WINNING_LOTTO_NUMBER = "1,2,3,4,5,6";
	public static final String BONUS_NUMBER = "7";

	@Override
	public void send(String content) {
		System.out.println(content);
	}

	@Override
	public void shutdown() {

	}

	@Override
	public String receiveMoney() {
		return MONEY;
	}

	@Override
	public String receiveWinningLottoNumber() {
		return WINNING_LOTTO_NUMBER;
	}

	@Override
	public String receiveBonusLottoNumber() {
		return BONUS_NUMBER;
	}

}
