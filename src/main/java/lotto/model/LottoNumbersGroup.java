package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGroup {

	private final List<LottoNumbers> lottoNumbersGroup;

	public LottoNumbersGroup(List<LottoNumbers> lottoNumbersGroup) {
		this.lottoNumbersGroup = Collections.unmodifiableList(lottoNumbersGroup);
	}

	public List<List<Integer>> getLottoNumbersGroup() {
		return lottoNumbersGroup.stream()
			.map(LottoNumbers::getNumbers)
			.collect(Collectors.toList());
	}

	public LottoResult match(LottoNumbers winningNumbers) {
		LottoResult lottoResult = new LottoResult();
		for (LottoNumbers lottoNumbers : lottoNumbersGroup) {
			int matchCount = lottoNumbers.match(winningNumbers);
			LottoRank lottoRank = LottoRank.of(matchCount);
			lottoResult.increaseCountOfRank(lottoRank);
		}
		return lottoResult;
	}
}
