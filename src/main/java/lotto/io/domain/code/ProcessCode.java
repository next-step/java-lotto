package lotto.io.domain.code;

public enum ProcessCode {
	REQUEST_INPUT, SYSTEM_IN, FINISH;

	public boolean isRequestInput() {
		return this == REQUEST_INPUT;
	}

	public boolean isSystemIn() {
		return this == SYSTEM_IN;
	}

	public boolean isFinish() {
		return this == FINISH;
	}
}
