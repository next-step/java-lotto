package lotto.dto;

import java.util.List;

public class LottoDto {
	private final List<Integer> lottoNumbers;

	public LottoDto(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public List<Integer> lottoNumbers() {
		return lottoNumbers;
	}
}
