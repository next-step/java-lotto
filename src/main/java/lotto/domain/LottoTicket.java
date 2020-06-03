package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

	protected final List<LottoNumber> lottoNumbers;

	public LottoTicket(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public boolean doesContainBonusBall(LottoNumber bonusBall) {
		return lottoNumbers.stream()
			.anyMatch(number -> number.getNumber().equals(bonusBall.getNumber()));
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	public int getMatchCount(LottoNumber winningNumber) {
		return (int) this.lottoNumbers.stream()
			.filter(number -> winningNumber.getNumber().equals(number.getNumber()))
			.count();
	}

	@Override
	public String toString() {
		return "[" + lottoNumbers.stream()
			.map(Object::toString)
			.collect(Collectors.joining(", ")) + ']';
	}
}
