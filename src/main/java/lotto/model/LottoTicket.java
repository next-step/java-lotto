package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {

	private final List<LottoNumbers> lottoNumbersGroup;

	public LottoTicket(List<LottoNumbers> lottoNumbersGroup) {
		this.lottoNumbersGroup = Collections.unmodifiableList(lottoNumbersGroup);
	}

	public static LottoTicket of(List<LottoNumbers> oneGroup, List<LottoNumbers> otherGroup) {
		List<LottoNumbers> combineGroup = Stream.concat(
			oneGroup.stream(),
			otherGroup.stream())
			.collect(Collectors.toList());
		return new LottoTicket(combineGroup);
	}

	public List<List<Integer>> getLottoNumbersGroup() {
		return lottoNumbersGroup.stream()
			.map(LottoNumbers::getNumbers)
			.collect(Collectors.toList());
	}

	public LottoResult match(WinningNumbers winningNumbers) {
		List<LottoRank> lottoRanks = lottoNumbersGroup.stream()
			.map((lottoNumbers) -> lottoNumbers.match(winningNumbers))
			.collect(Collectors.toList());
		return LottoResult.of(lottoRanks);
	}
}
