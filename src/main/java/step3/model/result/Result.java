package step3.model.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step3.model.lotto.Lotto;
import step3.model.lotto.Lottos;

public class Result {

	private final Lotto winningLotto;		// 당첨 로또
	private final Lotto bonusLotto;			// 보너스 로또
	private final Lottos purchaseLottos;		// 구입한 로또(수동 로또 + 자동 로또)

	public Result(int bonusNumber, Lotto winningLotto, Lottos manualLottos, Lottos automaticLottos) {
		this.winningLotto = winningLotto;
		this.purchaseLottos = manualLottos.addAll(automaticLottos);
		this.bonusLotto = setBonusLotto(bonusNumber);
	}

	public HashMap<Rank, Integer> getCountMap() {
		return matchCountMap();
	}

	public double calculatePrize() {
		HashMap<Rank, Integer> rankCountMap = matchCountMap();
		double prize = 0;
		for (Map.Entry<Rank, Integer> rankCount : rankCountMap.entrySet()) {
			prize += rankCount.getKey().getWinningMoney() * rankCount.getValue();
		}
		return prize;
	}

	private HashMap<Rank, Integer> matchCountMap() {
		HashMap<Rank, Integer> countMap = new HashMap<>();

		this.purchaseLottos.forEach(lotto -> {
			countMap.putIfAbsent(Rank.valueOf(lotto.getMatchCount(winningLotto.getNumbers()), false), 0);
			countMap.computeIfPresent(Rank.valueOf(lotto.getMatchCount(winningLotto.getNumbers()), false), (rank, cnt) -> cnt + 1);
			countMap.putIfAbsent(Rank.valueOf(lotto.getMatchCount(bonusLotto.getNumbers()), true), 0);
			countMap.computeIfPresent(Rank.valueOf(lotto.getMatchCount(bonusLotto.getNumbers()), true), (rank, cnt) -> cnt + 1);
		});
		return countMap;
	}

	private Lotto setBonusLotto(int bonusNumber) {
		List<Integer> winningLottoNumbers = new ArrayList<>(this.winningLotto.getNumbers());
		winningLottoNumbers.set(winningLottoNumbers.size() - 1, bonusNumber);
		return new Lotto(winningLottoNumbers);
	}
}
