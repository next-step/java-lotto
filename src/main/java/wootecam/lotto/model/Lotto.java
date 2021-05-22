package wootecam.lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import wootecam.lotto.exception.LottoException;

public class Lotto {

	public static final int LOTTO_NUMBER_SIZE = 6;
	private final List<Integer> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		if (!isValidLottoNumberSize(lottoNumbers)) {
			throw new LottoException("로또 번호는 6개여야 합니다.");
		}
		this.lottoNumbers = new ArrayList<>(lottoNumbers);
	}

	private boolean isValidLottoNumberSize(List<Integer> lottoNumbers) {
		List<Integer> numbers = Optional.ofNullable(lottoNumbers)
			.orElse(new ArrayList<>());

		return numbers.size() == LOTTO_NUMBER_SIZE;
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

	public String toLottoNumberString() {
		return this.lottoNumbers.stream()
			.map(Object::toString)
			.collect(Collectors.joining(","));
	}
}
