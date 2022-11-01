package lotto.view.dto;

import java.util.List;

public class LottoStringsDto {

	private final List<String> lottoStrings;

	private LottoStringsDto(List<String> lottosString) {
		this.lottoStrings = lottosString;
	}

	public static LottoStringsDto of(List<String> lottosString) {
		return new LottoStringsDto(lottosString);
	}

	public List<String> getLottoStrings() {
		return lottoStrings;
	}
}
