package lotto.service;

import java.util.List;

import lotto.model.LottoMachine;
import lotto.model.LottoNumber;

public class LottoGenerator {

	public static List<LottoNumber> generateLottoNumbers() {
		return LottoMachine.createLottoNumbers().getLottoBalls();
	}
}
