package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import lotto.dto.LottoGameResultDto;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;

	private int lottoGameCount;

	private LottoNumbers lottoNumbers;

	public int calculateLottoCount(int input) {
		this.lottoGameCount = input/LOTTO_PRICE;
		return this.lottoGameCount;
	}

	public LottoNumbers generateLottoNumbers(int lottoGameCount, NumberGenerator numberGenerator) {
		lottoNumbers = new LottoNumbers();
		return lottoNumbers.generateLottoNumbers(lottoGameCount, numberGenerator);
	}

	public LottoGameResultDto generateLottoGameResult(LottoNumber winLottoNumber, LottoNumbers lottoNumbers) {
		Map<LottoRank, Long> lottoGameResult = lottoNumbers.getLottoNumbers().stream()
			.map(lottoNumber -> lottoNumber.rankLotto(winLottoNumber))
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.groupingBy(lottoRank -> lottoRank, Collectors.counting()));
		return new LottoGameResultDto(lottoGameResult, lottoGameCount);
	}
}
