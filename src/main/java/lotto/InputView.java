package lotto;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String DELIMITER = "\\,";

	public static Money pay() {
		System.out.println("구입금액을 입력해 주세요.");
		return new Money(scanner.nextInt());
	}

	public static List<LottoNumber> winningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String text = scanner.next();
		System.out.println();
		return stringToNumbers(text);
	}

	public static List<LottoNumber> stringToNumbers(String text) {
		String[] split = text.split(DELIMITER);
		return Stream.of(split)
			.mapToInt(s -> Integer.parseInt(s.trim()))
			.mapToObj(LottoNumber::new)
			.collect(toList());
	}
}
