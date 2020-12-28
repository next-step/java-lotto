package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WinLotto;

public class InputView {
	private static final String DELIMITER = ",";

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputBuyMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		int buyMoney;
		try {
			buyMoney = Integer.parseInt(scanner.next());
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
		return buyMoney;
	}

	public static int inputManualCount() {
		scanner.nextLine();
		System.out.println();
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		int manualCount;
		try {
			manualCount = Integer.parseInt(scanner.next());
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
		return manualCount;
	}

	public static LottoTicket inputManualLotto(int count) {
		scanner.nextLine();
		System.out.println();
		List<Lotto> lottoTicket = new ArrayList<>();
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		for (int i = 0; i < count; i++) {
			lottoTicket.add(new Lotto(inputLotto()));
		}
		return new LottoTicket(lottoTicket);
	}

	public static WinLotto inputWinLotto() {
		System.out.println();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		List<LottoNumber> lotto = inputLotto();
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonus;
		try {
			bonus = Integer.parseInt(scanner.next());
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
		return new WinLotto(new Lotto(lotto), LottoNumber.of(bonus));
	}

	private static List<LottoNumber> inputLotto() {
		try {
			String input = scanner.nextLine();
			return Arrays.stream(input.split(DELIMITER))
				.map(String::trim)
				.map(Integer::parseInt)
				.map(LottoNumber::of)
				.collect(Collectors.toList());
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
	}
}
