package lotto.input;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.ManualLottoCount;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static String inputPurchase() {
		System.out.println("구입금액을 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static String inputWinning() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static String inputBonusBall() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static String inputManualLottoCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return SCANNER.nextLine();
	}

	public static List<String> inputManualLottos(ManualLottoCount lottoCount) {
		int manualLottoCount = lottoCount.getManualLottoCount();

		if (manualLottoCount == 0) {
			return Collections.emptyList();
		}

		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

		return IntStream.range(0, manualLottoCount)
						.mapToObj(i -> SCANNER.nextLine())
						.collect(toList());

	}

}
