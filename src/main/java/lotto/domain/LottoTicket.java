package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static lotto.util.ValidationUtils.*;

public class LottoTicket {

	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final String INVALID_LOTTO_NUMBERS_FORMAT_MESSAGE = String.format("로또 숫자는 %d 자리입니다.",
		LOTTO_NUMBER_COUNT);

	private final Set<LottoNumber> lottoNumbers;

	LottoTicket(Set<LottoNumber> lottoNumbers) {
		validate(lottoNumbers);

		this.lottoNumbers = lottoNumbers;
	}

	private void validate(Set<LottoNumber> lottoNumbers) {
		if (!validateCollection(lottoNumbers, LOTTO_NUMBER_COUNT)) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_FORMAT_MESSAGE);
		}
	}

	static int countMatchingNumber(LottoTicket userLottoTicket, LottoTicket winningLottoTicket) {
		return userLottoTicket.countMatchingNumber(winningLottoTicket.lottoNumbers);
	}

	int countMatchingNumber(Set<LottoNumber> lottoNumberSet) {
		Set<LottoNumber> targetLottoNumberSet = new HashSet<>(lottoNumberSet);
		validate(targetLottoNumberSet);

		targetLottoNumberSet.retainAll(this.lottoNumbers);

		return targetLottoNumberSet.size();
	}

	boolean matchNumber(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoTicket that = (LottoTicket)o;
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
