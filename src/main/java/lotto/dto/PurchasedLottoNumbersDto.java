package lotto.dto;

import java.util.Collections;
import java.util.List;

public class PurchasedLottoNumbersDto {
	private int passiveCount;
	private int autoCount;
	private List<LottoNumberDto> lottoNumbers;

	public PurchasedLottoNumbersDto(int passiveCount, int autoCount, List<LottoNumberDto> lottoNumbers) {
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

	public List<LottoNumberDto> getLottoNumbers() {
		return lottoNumbers;
	}
}
