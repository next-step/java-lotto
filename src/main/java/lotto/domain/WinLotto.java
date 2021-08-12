package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lotto.exception.LottoValidationException;

public class WinLotto {

	private static final int LOTTO_NUMBERS_LENGTH = 6;

	private final Set<LottoNumber> lottoNumbers;
	private final LottoNumber bonusNumber;

	private WinLotto(Set<LottoNumber> lottoNumbers, int bonusNumber) {
		if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
			throw new LottoValidationException("로또 번호는 " + LOTTO_NUMBERS_LENGTH + "개의 숫자여야 합니다.");
		}

		this.lottoNumbers = lottoNumbers;
		this.bonusNumber = LottoNumber.valueOf(bonusNumber);
	}

	public static WinLotto of(String lottoNumbers, int bonusNumber) {
		String[] stringLottoNumbers = lottoNumbers.split(",");

		Set<LottoNumber> lottoNumberList = Arrays.stream(stringLottoNumbers)
			.map(String::trim)
			.mapToInt(Integer::parseInt)
			.mapToObj(LottoNumber::valueOf)
			.collect(Collectors.toCollection(TreeSet<LottoNumber>::new));

		return new WinLotto(lottoNumberList, bonusNumber);
	}

	public static WinLotto of(List<Integer> lottoNumbers, int bonusNumber) {
		Set<LottoNumber> lottoNumberList = lottoNumbers.stream()
													.map(LottoNumber::valueOf)
													.collect(Collectors.toCollection(TreeSet<LottoNumber>::new));

		return new WinLotto(lottoNumberList, bonusNumber);
	}

	public boolean containsLottoNumber(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}
}
