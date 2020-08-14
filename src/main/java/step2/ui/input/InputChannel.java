package step2.ui.input;

public interface InputChannel {

	static InputChannel getDefaultChannel() {
		return new SystemIn();
	}

	int getIntValue();

	String getStringValue();
}
