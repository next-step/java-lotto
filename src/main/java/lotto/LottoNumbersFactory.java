package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoNumbersFactory {

	private List<LottoNumbers> lottoList;

	public LottoNumbersFactory() {
		this(new ArrayList<>());
	}

	LottoNumbersFactory(final List<LottoNumbers> lottoList) {
		this.lottoList = lottoList;
	}

	public void add(final LottoNumbers lottoNumbers) {
		this.lottoList.add(lottoNumbers);
	}

	public LottoResult summary(final LottoNumbers winningLottoNumbers, final LottoNumber bonusNumber) {
		LottoResult result = new LottoResult();
		lottoList.stream()
				 .map(lottoNumbers -> lottoNumbers.result(winningLottoNumbers, bonusNumber))
				 .forEach(result::add);
		return result;
	}

	public int size() {
		return this.lottoList.size();
	}

	@Override
	public String toString() {
		return lottoList.stream()
				 .map(LottoNumbers::toString)
				 .collect(Collectors.joining("\n"));
	}
}
