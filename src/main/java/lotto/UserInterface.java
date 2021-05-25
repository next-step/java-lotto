package lotto;

public interface UserInterface {

	void send(String content);

	void shutdown();

	String receiveMoney();

	String receiveWinningLottoNumber();

	String receiveBonusLottoNumber();
}
