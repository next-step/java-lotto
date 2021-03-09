package camp.nextcamp.edu.lotto.views;

import java.util.Scanner;

public class InputView extends View {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public String getMoneyString() {
		out.println("구입금액을 입력해 주세요.");
		return scanner.nextLine();
	}

	public String getWinningLottoNumbers() {
		out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}
}
