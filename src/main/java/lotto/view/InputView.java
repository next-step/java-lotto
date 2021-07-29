package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.WinningLottoNumbers;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String DELIMITER = ",";
	private static final String BLANK = "";

	private InputView() {
	}

	public static int inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return SCANNER.nextInt();
	}

	public static WinningLottoNumbers inputWinningNumbers() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		List<Integer> collect = IntStream.range(0, 6)
									.mapToObj(i -> Integer.parseInt(SCANNER.next().replace(DELIMITER, BLANK)))
									.collect(Collectors.toList());
		return WinningLottoNumbers.from(collect);
	}

}
