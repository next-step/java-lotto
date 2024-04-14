package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
	public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
	Scanner scanner = new Scanner(System.in);

	public int inputMoney(){
		System.out.println(INPUT_MONEY_MESSAGE);
		return Integer.parseInt(scanner.nextLine());
	}

	public String inputWinningNumber(){
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		return scanner.nextLine();
	}

	public int inputBonusNumber(){
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		return scanner.nextInt();
	}

	public int inputManualLottoNumberCount() {
		System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
		return scanner.nextInt();
	}

	public List<String> inputManualLottoNumber(int count) {
		System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);
		return IntStream.range(0, count)
			.mapToObj(lotto -> scanner.nextLine())
			.collect(Collectors.toList());
	}
}
