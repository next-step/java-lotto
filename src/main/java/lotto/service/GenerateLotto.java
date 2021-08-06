package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.model.LottoMachine;

public class GenerateLotto {

	public static List<Integer> generateLottoNumbers() {
		return LottoMachine.createLottoNumber();
	}
}
