package controller;

import service.LottoCalculator;
import util.Input;
import util.Result;
import domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	private static final Integer INIT_NUMBER = 0;

	public static void main(String[] args) {

		Input input = new Input();
		Result result = new Result();
		LottoNumberGenerator generator = new LottoNumberGenerator();
		List<Lotto> lottoList = new ArrayList<>();
		LottoCalculator calculator = new LottoCalculator();

		Account account = input.setAccount();
		List<Lotto> manualLottos = input.getManualLotto();
		Integer lottoCount = calculator.getLottoCount(account);
		input.viewLottoCount(lottoCount);

		for (int number = INIT_NUMBER ; number < lottoCount ; ++number) {
			Lotto lotto = generator.getLottoNumber();
			lottoList.add(lotto);
			result.viewLotto(lotto);
		}

		List<Rank> container = calculator.getResult(lottoList, input.lottoWinningNumber(), input.setBonusNumber());
		result.viewResult(container);
	}
}
