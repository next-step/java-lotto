package lotto.modal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

	private final GameManual money;
	private List<Lotto> lottoPackage;

	public Game(GameManual money) {
		this.money = money;
		//this.lottoPackage = generateLottoPackage();
	}

	public List<Lotto> getLottoPackage() {
		return this.lottoPackage;
	}

	public LottoResult getLottoResult(WinnerLotto winnerLotto) {
		return this.generateLottoResult(winnerLotto);
	}

	public void addManualLotto(List<Lotto> manualLotto) {
		this.lottoPackage = Stream.concat(this.lottoPackage.stream(), manualLotto.stream())
			.collect(Collectors.toList());
	}

	private List<Lotto> generateLottoPackage() {
		int count = this.money.getRepeatCount();

		return Stream.generate(Lotto::new)
			.limit(count)
			.collect(Collectors.toList());
	}

	private LottoResult generateLottoResult(WinnerLotto winnerLotto) {
		return new LottoResult(this.lottoPackage.stream()
			.map(lotto -> LottoRank.getRank(winnerLotto.getMatchCount(lotto), winnerLotto.isContainBonus(lotto)))
			.filter(lottoRank -> !lottoRank.equals(LottoRank.NOTHING_RANK))
			.collect(Collectors.toList()));
	}
}
