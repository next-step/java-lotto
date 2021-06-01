package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import calculator.Input;
import calculator.Tokenizer;

public class InputView {
	public static final String LOTTO_PURCHASE_INPUT = "구입금액을 입력해 주세요.";
	public static final String BONUS_NUMBER_INPUT = "보너스 볼을 입력해 주세요.";
	public static final String WINNING_NUMBER_MSG = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String MANUAL_LOTTO_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String MANUAL_LOTTOS_MSG = "수동으로 구매할 번호를 입력해 주세요.";

	public static final Scanner scanner = new Scanner(System.in);

	public static void print(String msg) {
		System.out.println(msg);
	}

	public static int inputMoney() {
		System.out.println(LOTTO_PURCHASE_INPUT);
		int inputMoney = scanner.nextInt();
		scanner.nextLine();
		return inputMoney;
	}

	public static List<LottoNumber> inputLottoNumber() {
		InputView.print(InputView.WINNING_NUMBER_MSG);
		return getLottoFromInput();
	}

	public static LottoNumber inputBonusNumber() {
		System.out.println(BONUS_NUMBER_INPUT);
		int bonusNumber = scanner.nextInt();
		scanner.nextLine();
		return new LottoNumber(bonusNumber);
	}

	public static List<Lotto> inputManualLotto() {
		int manualCount = inputManualLottoCount();
		System.out.println(MANUAL_LOTTOS_MSG);

		return Stream.generate(() -> new Lotto(getLottoFromInput())).limit(manualCount).collect(Collectors.toList());
	}

	private static List<LottoNumber> getLottoFromInput() {
		String input = scanner.next();
		String[] lottoNum = new Tokenizer(new Input(input)).split();

		return Arrays.stream(lottoNum).map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toList());
	}

	private static int inputManualLottoCount() {
		System.out.println(MANUAL_LOTTO_COUNT_MSG);
		int manualCount = scanner.nextInt();
		scanner.nextLine();
		if(manualCount < 0) {
			throw new IllegalArgumentException("음수 값을 입력할 수 없습니다.");
		}
		return manualCount;
	}
}
