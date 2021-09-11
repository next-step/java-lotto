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

		Account totalAccount = input.setAccount();
		Integer manualLottoCount = input.getManualLotto();

		input.manualLottoView();
		for (int number = INIT_NUMBER ; number < manualLottoCount ; ++number) {
			lottoList.add(input.manualLotto());
		}

		Integer autoLottoCount = calculator.getAutoLottoCount(totalAccount, lottoList);
		input.viewLottoCount(autoLottoCount, manualLottoCount);

		for (int number = INIT_NUMBER ; number < autoLottoCount ; ++number) {
			Lotto lotto = generator.getLottoNumber();
			lottoList.add(lotto);
		}

		result.viewLottos(lottoList);
		List<Rank> container = calculator.getResult(lottoList, input.lottoWinningNumber(), input.setBonusNumber());
		result.viewResult(container, totalAccount);
	}
}
