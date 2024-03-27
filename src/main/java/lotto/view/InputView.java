package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.MyLottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public Integer inputPay() {
		System.out.println("구입금액을 입력해 주세요.");
		return new Scanner(System.in).nextInt();
	}

	public Integer inputNumberOfLottosToPurchaseManually() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return new Scanner(System.in).nextInt();
	}

	public MyLottos inputManualLottoNumbers(Integer count) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			String lottoNumbers = new Scanner(System.in).nextLine();
			Lotto manualLotto = Lotto.createManualLotto(lottoNumbers);
			lottoList.add(manualLotto);
		}
		return new MyLottos(lottoList);
	}

	public String getWinNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return new Scanner(System.in).nextLine();
	}

	public String getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return new Scanner(System.in).nextLine();
	}
}
