package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ManualLottoNumbers {

	private final List<LottoNumberText> lottoNumberTextList;

	public ManualLottoNumbers(List<LottoNumberText> lottoNumberTextList) {
		this.lottoNumberTextList = validLottoNumberTexts(lottoNumberTextList);
	}

	private List<LottoNumberText> validLottoNumberTexts(List<LottoNumberText> lottoNumberTextList) {
		return Optional.ofNullable(lottoNumberTextList)
			.orElse(new ArrayList<>());
	}

	public int count() {
		return lottoNumberTextList.size();
	}

	public List<LottoNumberText> toList() {
		return Collections.unmodifiableList(lottoNumberTextList);
	}
}
