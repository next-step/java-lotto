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

		Integer autoLottoCount = calculator.getAutoLottoCount(account, manualLottos);
		Integer manualLottoCount = calculator.getManualLottoCount(manualLottos);

		input.viewLottoCount(autoLottoCount, manualLottoCount);

		for (int number = INIT_NUMBER ; number < manualLottoCount ; ++number) {
			lottoList.add(manualLottos.get(number));
			result.viewLotto(lottoList.get(number));
		}

		for (int number = INIT_NUMBER ; number < autoLottoCount ; ++number) {
			Lotto lotto = generator.getLottoNumber();
			lottoList.add(lotto);
			result.viewLotto(lotto);
		}

		List<Rank> container = calculator.getResult(lottoList, input.lottoWinningNumber(), input.setBonusNumber());
		result.viewResult(container);
	}
}
