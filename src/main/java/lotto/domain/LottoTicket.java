package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.collections.WinningNumbers;

public class LottoTicket {

	protected final List<LottoNumber> lottoNumbers;

	public LottoTicket(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public int getMatchCounts(final WinningNumbers winningNumbers) {
		return Math.toIntExact(lottoNumbers.stream()
			.filter(number -> number.getMatchCounts(winningNumbers))
			.count());
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public boolean doesContainBonusBall(LottoNumber bonusBall) {
		return lottoNumbers.stream()
			.anyMatch(number -> number.getNumber().equals(bonusBall.getNumber()));
	}

	@Override
	public String toString() {
		return "[" + lottoNumbers.stream()
			.map(Object::toString)
			.collect(Collectors.joining(", ")) + ']';
	}
}
