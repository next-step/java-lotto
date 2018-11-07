package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by hspark on 06/11/2018.
 */
public class InputView {
	public static int inputLottoPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static int inputLottoBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	public static List<Integer> inputLottoNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return Arrays.stream(scanner.nextLine().split(","))
			.map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
	}
}
