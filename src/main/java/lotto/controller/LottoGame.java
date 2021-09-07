package lotto.controller;

import java.util.List;

import lotto.domain.Lottery;
import lotto.domain.LotteryResults;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.utils.StringUtils;
import lotto.view.InputView;

public class LottoGame {
	public LotteryResults draw(Lottos lottos, String inputNumbers) {
		List<Number> numbers = StringUtils.convertToNumberList(inputNumbers);
		Numbers winningNumbers = new Numbers(numbers);
		Number bonusNumber = new Number(InputView.inputBonusNumber());
		Lottery lottery = new Lottery(winningNumbers, bonusNumber);
		return lottery.draw(lottos);
	}
}
