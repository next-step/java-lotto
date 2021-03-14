package camp.nextcamp.edu.lotto.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	public String getBonusNumber() {
		out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextLine();
	}

	public String getManualCount() {
		out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return scanner.nextLine();
	}

	public List<String> getManualLottos(int count) {
		out.println("수동으로 구매할 번호를 입력해 주세요.");

		return IntStream.range(0, count)
			.mapToObj((i) -> scanner.nextLine())
			.collect(Collectors.toList());
	}
}
