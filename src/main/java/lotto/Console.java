package lotto;

import java.util.Scanner;

public class Console implements UserInterface {

	private final Scanner SCANNER = new Scanner(System.in);

	@Override
	public void send(String content) {
		System.out.println(content);
	}

	@Override
	public void shutdown() {
		SCANNER.close();
	}

	@Override
	public String receiveMoney() {
		return SCANNER.nextLine();
	}

	@Override
	public String receiveWinningLottoNumber() {
		return SCANNER.nextLine();
	}

	@Override
	public String receiveBonusLottoNumber() {
		return SCANNER.nextLine();
	}

}
