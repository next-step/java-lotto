package wootecam.lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import wootecam.lotto.exception.LottoException;

public class Lotto {

	public static final int LOTTO_NUMBER_SIZE = 6;
	private List<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> lottoNumbers) {
		if (!isValidLottoNumberSize(lottoNumbers)) {
			throw new LottoException("로또 번호는 6개여야 합니다.");
		}
		this.lottoNumbers = new ArrayList<>(lottoNumbers);
	}

	public Lotto(String lottoNumbersInput) {
		this(Arrays.stream(lottoNumbersInput.split(","))
			.map(LottoNumber::of)
			.distinct()
			.collect(Collectors.toList()));
	}

	private boolean isValidLottoNumberSize(List<LottoNumber> lottoNumbers) {
		int size = Optional.ofNullable(lottoNumbers)
			.orElse(new ArrayList<>()).size();

		return size == LOTTO_NUMBER_SIZE;
	}

	public String toLottoNumberString() {
		return this.lottoNumbers.stream()
			.map(LottoNumber::valueOf)
			.collect(Collectors.joining(","));
	}

	public int getNumberMatchCount(WinningLotto winningLotto) {
		return (int)this.lottoNumbers.stream()
			.filter(winningLotto::contains)
			.count();
	}

	public boolean contains(LottoNumber number) {
		return this.lottoNumbers.contains(number);
	}
}
