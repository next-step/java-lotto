package lotto.ui.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import static lotto.constants.MessageConstant.INPUT_SHOULD_INTEGER;

public class SystemIn implements InputChannel {

	private static final Scanner SCANNER = new Scanner(System.in);

	public SystemIn() {}

	@Override
	public int getIntValue() {
		try {
			return SCANNER.nextInt();
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException(INPUT_SHOULD_INTEGER, e);
		} finally {
			SCANNER.nextLine();
		}
	}

	@Override
	public String getStringValue() {
		return SCANNER.nextLine();
	}
}
