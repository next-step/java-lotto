package lotto.domain;

import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/20
 * @description :
 **/
public class ManualNumbers {
	private List<String> manualNumbers;

	public ManualNumbers(List<String> manualNumbers) {
		this.manualNumbers = manualNumbers;
	}

	public int getCount() {
		return manualNumbers.size();
	}

	public List<String> getManualNumbers() {
		return manualNumbers;
	}
}
