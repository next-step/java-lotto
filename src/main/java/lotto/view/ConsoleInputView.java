package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInputView implements InputView {

	@Override
	public int purchase() {
		System.out.println("구입 금액을 입력해주세요.");
		Scanner scanner = new Scanner(System.in);

		int payment = parseInt(scanner.nextLine());
		return payment / Lotto.PRICE;
	}

	@Override
	public List<Lotto> manualLottos() {
		System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		int amount = parseInt(scanner.nextLine());

		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<Lotto> manualLottos = new ArrayList<>(amount);

		for (int i = 0; i < amount; i++) {
			String manualLotto = scanner.nextLine();
			manualLottos.add(new Lotto(stringToIntegerList(manualLotto)));
		}
		return manualLottos;
	}

	public WinningLotto winningLotto() {
		System.out.println("지난 주 당첨 번호를 입력해주세요.");
		Scanner scanner = new Scanner(System.in);

		String winningLottoString = scanner.nextLine();
		System.out.println("보너스 볼을 입력해주세요.");
		int bonusNumber = parseInt(scanner.nextLine());
		System.out.println();

		return new WinningLotto(new Lotto(stringToIntegerList(winningLottoString)), bonusNumber);
	}

	private List<Integer> stringToIntegerList(String lottoString) {
		String lotto = Optional.ofNullable(lottoString).orElseThrow(() -> new IllegalArgumentException("빈 값입니다."));
		return Stream.of(lotto.split(","))
				.map(String::trim)
				.map(this::parseInt)
				.collect(Collectors.toList());
	}

	private int parseInt(String number) {
		number = number.trim();
		if (number.isBlank()) {
			throw new IllegalArgumentException("빈 값이 입력되었습니다.");
		}
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
		}
	}
}
