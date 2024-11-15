package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import step2.dto.PlayLottoDto;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static PlayLottoDto getPlayLottoParams() {
		List<String> lottoString = new ArrayList<>();

		System.out.println("구입금액을 입력해 주세요.");
		String moneyString = scanner.nextLine();

		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		String manualLottoCount = scanner.nextLine();
		int count = checkCountValid(manualLottoCount);

		System.out.println("수동으로 구매할 번호를 입력해 주세요. ex) 1, 2, 3, 4, 5, 6");
		for (int i = 0; i < count; i++) {
			lottoString.add(scanner.nextLine());
		}

		return new PlayLottoDto(moneyString, lottoString);
	}

	private static int checkCountValid(String manualLottoCount) {
		int count = 0;
		try {
			count = Integer.parseInt(manualLottoCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("구매할 로또 수는 숫자여야 합니다.");
		}
		return count;
	}

	public static String getWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요. ex) 1, 2, 3, 4, 5, 6");
		return scanner.nextLine();
	}

	public static String getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextLine();
	}
}
