package lotto.ui.output;

public class SystemOut implements OutputChannel {

	public SystemOut() {}

	@Override
	public void printLine(String input) {
		System.out.println(input);
	}

	@Override
	public void printError(String errorMessage) {
		System.err.println(errorMessage);
	}
}
