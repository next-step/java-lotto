package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static Wallet pay() {
		System.out.println("\n구입금액을 입력해 주세요.");
		return new Wallet(scanner.nextInt());
	}

	public static Lotto winLotto() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		String text = scanner.next();
		return LottoGenerator.generate(text);
	}

	public static LottoNumber bonusBall() {
		System.out.println("\n보너스 볼을 입력해 주세요.");
		int bonusBall = scanner.nextInt();
		return LottoNumber.valueOf(bonusBall);
	}

	public static Lottos manualBuy(Wallet wallet) {
		System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
		int manualCount = scanner.nextInt();
		if (wallet.buyLimit() < manualCount) {
			throw new NotEnoughMoneyException(manualCount + "개 만큼 살 수 없습니다."); // TODO Duplicate Statement!
		}

		return writeDownManualLottos(manualCount);
	}

	private static Lottos writeDownManualLottos(int count) {
		System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			String text = scanner.next();
			lottoList.add(LottoGenerator.generate(text));
		}

		return new Lottos(lottoList);
	}
}
