package lotto.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {

	private final List<LottoNumbers> lottoNumbersGroup;

	LottoTicket(List<LottoNumbers> lottoNumbersGroup) {
		this.lottoNumbersGroup = Collections.unmodifiableList(lottoNumbersGroup);
	}

	public static LottoTicket create(LottoNumbersGenerateStrategy... lottoNumbersGenerateStrategies) {
		List<LottoNumbers> lottoNumbers = Stream.of(lottoNumbersGenerateStrategies)
			.map(LottoNumbersGenerateStrategy::generate)
			.flatMap(Collection::stream)
			.collect(Collectors.toList());
		return new LottoTicket(lottoNumbers);
	}

	public List<List<Integer>> getLottoNumbersGroup() {
		return lottoNumbersGroup.stream()
			.map(LottoNumbers::getNumbers)
			.collect(Collectors.toList());
	}

	List<LottoNumbers> getLottoNumbers() {
		return lottoNumbersGroup;
	}

	public LottoResult match(WinningNumbers winningNumbers) {
		List<LottoRank> lottoRanks = lottoNumbersGroup.stream()
			.map((lottoNumbers) -> lottoNumbers.match(winningNumbers))
			.collect(Collectors.toList());
		return LottoResult.of(lottoRanks);
	}
}
