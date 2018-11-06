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
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static List<Integer> inputLottoNumbers() {
		Scanner scanner = new Scanner(System.in);
		return Arrays.stream(scanner.nextLine().split(","))
			.map(Integer::parseInt).collect(Collectors.toList());
	}
}
