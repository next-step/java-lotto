package lotto.dto;

import java.util.Collections;
import java.util.List;

public class PurchasedLottoNumbers {
	private int passiveCount;
	private int autoCount;
	private List<LottoNumbers> lottoNumbers;

	public PurchasedLottoNumbers(int passiveCount, int autoCount, List<LottoNumbers> lottoNumbers) {
		this.passiveCount = passiveCount;
		this.autoCount = autoCount;
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public int getPassiveCount() {
		return passiveCount;
	}

	public int getAutoCount() {
		return autoCount;
	}

	public List<LottoNumbers> getLottoNumbers() {
		return lottoNumbers;
	}
}
