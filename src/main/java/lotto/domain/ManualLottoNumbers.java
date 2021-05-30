package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ManualLottoNumbers that = (ManualLottoNumbers)o;

		return Objects.equals(lottoNumberTextList, that.lottoNumberTextList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumberTextList);
	}
}
