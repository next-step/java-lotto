package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class LottoUtils {

	private static final String LOTTO_STRING_DELIMITER_REGEX = ",";

	private LottoUtils() {

	}

	public static Lottos getStringArrayToLottos(String[] lottosString) {
		Lottos lottos = new Lottos();
		for (String lottoString : lottosString) {
			lottos.addLotto(getStringToLotto(lottoString));
		}
		return lottos;
	}

	public static Lotto getStringToLotto(String lottoString) {
		String[] lottoArrays = lottoString.split(LOTTO_STRING_DELIMITER_REGEX);
		List<LottoNumber> winningLottoNumbers = new ArrayList<>();
		Arrays.stream(lottoArrays)
			.forEach(
				winningLottoNumber -> winningLottoNumbers.add(new LottoNumber(Integer.parseInt(winningLottoNumber.trim()))));
		return new Lotto(winningLottoNumbers);
	}
}
