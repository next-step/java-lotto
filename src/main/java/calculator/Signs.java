package calculator;

import java.util.List;

public class Signs {
	private final List<Sign> signs;

	public Signs(List<Sign> signs) {
		this.signs = signs;
	}

	public void add(Sign sign) {
		signs.add(sign);
	}

	public List<Sign> signs() {
		return signs;
	}
}
