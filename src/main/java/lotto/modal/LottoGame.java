package lotto.modal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

	private final Money money;
	private final List<Lotto> lottoPackage;

	public LottoGame(Money userInputMoney) {
		this.money = userInputMoney;
		this.lottoPackage = generateLottoPackage();
	}

	public List<Lotto> getLottoPackage() {
		return this.lottoPackage;
	}

	public LottoResult getLottoResult(WinnerLotto winnerLotto) {
		return new LottoResult(this.lottoPackage, winnerLotto);
	}

	private List<Lotto> generateLottoPackage() {
		int count = this.money.getRepeatCount();

		return Stream.generate(Lotto::new)
			.limit(count)
			.collect(Collectors.toList());
	}
}
