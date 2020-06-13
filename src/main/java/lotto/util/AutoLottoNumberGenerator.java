package lotto.util;

import java.util.Collections;
import java.util.List;

import lotto.domain.LottoNumber;

public class AutoLottoNumberGenerator extends LottoNumberGenerator {

	int START_INDEX_OF_NUMBER_ELEMENTS = 0;
	int NUMBER_OF_NUMBER_ELEMENTS = 6;

	List<LottoNumber> beforeShuffledList;

	public AutoLottoNumberGenerator() {
		this.beforeShuffledList = LottoNumberGenerator.getLottoNumbers();
	}

	public List<LottoNumber> pickList() {
		return Collections.unmodifiableList(shuffle());
	}

	private List<LottoNumber> shuffle() {
		Collections.shuffle(beforeShuffledList);
		List<LottoNumber> afterShuffledList = beforeShuffledList
			.subList(START_INDEX_OF_NUMBER_ELEMENTS, NUMBER_OF_NUMBER_ELEMENTS);
		LottoNumberGenerator.sortDescLottoNumbers(afterShuffledList);
		return afterShuffledList;
	}
}
