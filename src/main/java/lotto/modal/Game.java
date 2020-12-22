package lotto.modal;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

	private List<Lotto> lottoPackage;

	public Game(ManualLotto manualLotto, int randomCount) {
		lottoPackage = generateLottoPackage(manualLotto, randomCount);
	}

	private List<Lotto> generateLottoPackage(ManualLotto manualLotto, int randomCount) {
		ManualLotto randomLotto = new ManualLotto(randomCount);
		return manualLotto.mergeLotto(randomLotto);
	}

	public List<Lotto> getLottoPackage() {
		return this.lottoPackage;
	}

	public LottoResult getLottoResult(WinnerLotto winnerLotto) {
		return this.generateLottoResult(winnerLotto);
	}
	
	private LottoResult generateLottoResult(WinnerLotto winnerLotto) {
		return new LottoResult(this.lottoPackage.stream()
			.map(lotto -> LottoRank.getRank(winnerLotto.getMatchCount(lotto), winnerLotto.isContainBonus(lotto)))
			.filter(lottoRank -> !lottoRank.equals(LottoRank.NOTHING_RANK))
			.collect(Collectors.toList()));
	}
}
