package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static int getBuyAmount() {
		System.out.println("구매금액을 입력해 주세요.");

		return new OverZeroIntegertInput(scanner.nextLine()).getNumber();
	}

	public static int getManualLottoCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

		return new OverZeroIntegertInput(scanner.nextLine()).getNumber();
	}

	public static List<Lotto> getManualLottos(int count) {
		List<Lotto> manualLottos = new ArrayList<>();

		System.out.println("수동으로 구매할 번호를 입력해 주세요.");

		for (int i = 0; i < count; i++) {
			manualLottos.add(new Lotto(getSplitNumberList(scanner.nextLine())));
		}

		return manualLottos;
	}

	public static List<Integer> getLastWinLotto() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");

		String lastWinLotto = scanner.nextLine();
		return Optional.of(getSplitNumberList(lastWinLotto))
			.orElseThrow(() -> new RuntimeException("input must be collection of numbers with comma split"));
	}

	private static List<Integer> getSplitNumberList(String numberList) {
		return Arrays.stream(numberList.split(","))
			.map(x -> Optional.of(Integer.parseInt(x.trim()))
				.orElseThrow(() -> new RuntimeException("each number must be integer number type")))
			.collect(Collectors.toList());
	}

	public static int getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");

		return new OverZeroIntegertInput(scanner.nextLine()).getNumber();
	}
}
