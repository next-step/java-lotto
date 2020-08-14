package step2.ui.output;

public class SystemOut implements OutputChannel{

	protected SystemOut() {}

	@Override
	public void printLine(String input) {
		System.out.println(input);
	}
}
