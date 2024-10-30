package step2.domain;

import static step2.domain.var.LottoConstant.*;

import java.util.Collections;
import java.util.List;

public class LottoShuffleManager {
	public static List<LottoNumber> shuffleSixNumbers() {
		List<LottoNumber> numberList = LottoNumber.getLottoBallNumbers();
		Collections.shuffle(numberList);
		List<LottoNumber> lottoNumbers = numberList.subList(0, LOTTO_COUNT);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}
}
