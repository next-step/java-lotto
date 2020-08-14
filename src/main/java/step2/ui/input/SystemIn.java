package step2.ui.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import static step2.constants.MessageConstant.INPUT_SHOULD_INTEGER;

public class SystemIn implements InputChannel{

	private static final Scanner SCANNER = new Scanner(System.in);

	protected SystemIn() {};

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
		try {
			return SCANNER.next();
		} finally {
			SCANNER.nextLine();
		}
	}
}
