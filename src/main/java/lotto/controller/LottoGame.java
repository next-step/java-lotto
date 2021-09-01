package lotto.controller;

import java.util.List;

import lotto.domain.Lottery;
import lotto.domain.LotteryResults;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.domain.Wallet;
import lotto.utils.StringUtils;
import lotto.view.InputView;

public class LottoGame {
	public Lottos buyLotto(int money) {
		Wallet wallet = new Wallet(money);
		int numberOfLotto = wallet.numberOfThingsToBuy();
		return wallet.buyLotto(numberOfLotto);
	}

	public LotteryResults draw(Lottos lottos, String inputNumbers) {
		List<Number> numbers = StringUtils.convertToNumberList(inputNumbers);
		Numbers winningNumbers = new Numbers(numbers);
		Number bonusNumber = new Number(InputView.inputBonusNumber());
		Lottery lottery = new Lottery(winningNumbers, bonusNumber);
		return lottery.draw(lottos);
	}
}
