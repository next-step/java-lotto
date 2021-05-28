package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LottoTicket {

	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final String INVALID_LOTTO_NUMBERS_MESSAGE = String.format("로또 숫자는 %d 자리입니다.", LOTTO_NUMBER_COUNT);

	private final Set<LottoNumber> lottoNumbers;

	LottoTicket(Set<LottoNumber> lottoNumbers) {
		this.lottoNumbers = validSet(lottoNumbers);
	}

	private Set<LottoNumber> validSet(Set<LottoNumber> lottoNumbers) {
		return Optional.ofNullable(lottoNumbers)
				.filter(set -> set.size() == LOTTO_NUMBER_COUNT)
				.orElseThrow(() -> new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE));
	}

	boolean isMatchingNumber(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	static int countMatchingNumber(LottoTicket userLottoTicket, LottoTicket winningLottoTicket) {
		return userLottoTicket.countMatchingNumber(winningLottoTicket.lottoNumbers);
	}

	int countMatchingNumber(Set<LottoNumber> lottoNumberSet) {
		HashSet<LottoNumber> validLottoNumbers = validLottoNumbers(lottoNumberSet);
		validLottoNumbers.retainAll(this.lottoNumbers);

		return validLottoNumbers.size();
	}

	private HashSet<LottoNumber> validLottoNumbers(Set<LottoNumber> lottoNumberSet) {
		return Optional.ofNullable(lottoNumberSet)
				.map(HashSet::new)
				.filter(set -> set.size() == LOTTO_NUMBER_COUNT)
				.orElse(new HashSet<>());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		LottoTicket that = (LottoTicket) o;

		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	@Override
	public String toString() {
		List<LottoNumber> list = new ArrayList<>(lottoNumbers);
		Collections.sort(list);

		return list.toString();
	}

}
