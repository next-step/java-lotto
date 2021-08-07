package lotto.service;

import java.util.List;

import lotto.model.LottoMachine;

public class LottoGenerator {

	public static List<Integer> generateLottoNumbers() {
		return LottoMachine.createLottoNumbers().getLottoBalls();
	}
}
