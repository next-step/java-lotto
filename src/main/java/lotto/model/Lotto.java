package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.message.ErrorMessage;

public class Lotto {

	private static final String LAST_WIN_NUMBER_REGEX = ",";
	private static final String INT_REG_EXP = "^\\d+$";
	private static final int LOTTO_NUMBER_LENGTH = 6;

	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> lottoNumbers) {
		checkLottoSize(lottoNumbers);
		checkDuplicateNumber(lottoNumbers);
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public Lotto(String lottoNumbers) {
		checkLottoEmpty(lottoNumbers);
		this.lottoNumbers = Collections.unmodifiableList(toList(lottoNumbers));
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	private List<LottoNumber> toList(String lotto) {
		List<LottoNumber> lottoNumbers = Arrays.stream(lotto.split(LAST_WIN_NUMBER_REGEX))
			.map(s -> new LottoNumber(toInt(s)))
			.collect(Collectors.toList());
		checkLottoSize(lottoNumbers);
		checkDuplicateNumber(lottoNumbers);
		return lottoNumbers;
	}

	private int toInt(String winnerNumbers) {
		checkNumberType(winnerNumbers.trim());
		return Integer.parseInt(winnerNumbers.trim());
	}

	private void checkNumberType(String lottoNumber) {
		if (!lottoNumber.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private void checkLottoSize(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
		}
	}

	private void checkDuplicateNumber(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE);
		}
	}

	private void checkLottoEmpty(String lottoNumbers) {
		if (lottoNumbers.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLottoNumbers());
	}
}
