package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lotto.exception.LottoValidationException;

public class WinLotto {

	private static final int LOTTO_NUMBERS_LENGTH = 6;

	private final Lotto winLotto;
	private final LottoNumber bonusNumber;

	private WinLotto(Lotto winLotto, int bonusNumber) {
		this.winLotto = winLotto;
		this.bonusNumber = LottoNumber.valueOf(bonusNumber);
	}

	public static WinLotto of(String lottoNumbers, int bonusNumber) {
		return new WinLotto(Lotto.of(lottoNumbers), bonusNumber);
	}

	public static WinLotto of(List<Integer> lottoNumbers, int bonusNumber) {
		return new WinLotto(Lotto.of(lottoNumbers), bonusNumber);
	}

	public boolean containsLottoNumber(LottoNumber lottoNumber) {
		return winLotto.contains(lottoNumber);
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}
}
