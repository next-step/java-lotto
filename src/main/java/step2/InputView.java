package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputPrice() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static List<Integer> inputWinningNumbers() {
		scanner.nextLine();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String[] inputValue = scanner.nextLine().split(", ");
		System.out.println();

		return Arrays.stream(inputValue)
				.map(Integer::new)
				.collect(Collectors.toList());
	}
}
