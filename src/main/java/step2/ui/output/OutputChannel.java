package step2.ui.output;

public interface OutputChannel {

	static OutputChannel getDefaultChannel() {
		return new SystemOut();
	}

	void printLine(String input);
}
