package lotto;

import exception.LottoException;
import type.LottoExceptionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static type.LottoExceptionType.NULL_PARAMETER;

public final class LottoNumbersFactory {

	private final List<LottoNumbers> lottoList;

	public LottoNumbersFactory() {
		this(new ArrayList<>());
	}

	LottoNumbersFactory(final List<LottoNumbers> lottoList) {
		checkNull(lottoList);
		this.lottoList = lottoList;
	}

	private void checkNull(final List<LottoNumbers> lottoList) {
		if (Objects.isNull(lottoList)) {
			throw LottoException.of(NULL_PARAMETER);
		}
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

	public List<LottoNumbers> lottoList() {
		return Collections.unmodifiableList(this.lottoList);
	}
}
