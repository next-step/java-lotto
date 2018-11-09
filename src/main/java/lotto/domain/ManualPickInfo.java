package lotto.domain;

import java.util.List;

public class ManualPickInfo {

	private List<String> manualNumbers;

	public ManualPickInfo(List<String> numbers) {
		this.manualNumbers = numbers;
	}

	public int getPickCount() {
		return manualNumbers.size();
	}

	public List<String> getManualNumbers() {
		return manualNumbers;
	}
}
