package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoNumbersFactory {

	private final List<LottoNumbers> lottoList;

	public LottoNumbersFactory() {
		this(new ArrayList<>());
	}

	LottoNumbersFactory(final List<LottoNumbers> lottoList) {
		this.lottoList = lottoList;
	}

	public void add(final LottoNumbers lottoNumbers) {
		this.lottoList.add(lottoNumbers);
	}

	public LottoResult summary(final WinningLottoNumbers winningLottoNumbers) {
		LottoResult result = new LottoResult();
		lottoList.stream()
				 .map(lottoNumbers -> lottoNumbers.result(winningLottoNumbers))
				 .forEach(result::add);
		return result;
	}

	public int size() {
		return this.lottoList.size();
	}

	public List<LottoNumbers> lottoList() {
		return Collections.unmodifiableList(this.lottoList);
	}
}
