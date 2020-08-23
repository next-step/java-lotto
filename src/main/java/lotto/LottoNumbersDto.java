package lotto;

import java.util.List;

import lombok.Getter;

@Getter
public class LottoNumbersDto {
	private final List<Integer> lottoNumbers;

	private LottoNumbersDto(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoNumbersDto of(List<Integer> lottoNumbers) {
		return new LottoNumbersDto(lottoNumbers);
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
