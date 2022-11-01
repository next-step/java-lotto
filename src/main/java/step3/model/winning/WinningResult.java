package step3.model.winning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step3.model.lotto.Lotto;
import step3.model.lotto.Lottos;

public class WinningResult {

	private final double prize;
	private final Lotto winningLotto;
	private final Lotto bonusLotto;
	private final Lottos purchaseLottos;
	private final HashMap<Rank, Integer> rankCountMap;

	public WinningResult(int bonusNumber, Lotto winningLotto, Lottos purchaseLottos) {
		this.winningLotto = winningLotto;
		this.purchaseLottos = purchaseLottos;
		this.bonusLotto = setBonusLotto(bonusNumber);
		this.rankCountMap = matchCountMap();
		this.prize = calculatePrize();
	}

	public HashMap<Rank, Integer> getCountMap() {
		return this.rankCountMap;
	}

	public double getPrize() {
		return this.prize;
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

	private double calculatePrize() {
		double prize = 0;
		for (Map.Entry<Rank, Integer> rankCount : rankCountMap.entrySet()) {
			prize += rankCount.getKey().getWinningMoney() * rankCount.getValue();
		}
		return prize;
	}

	private Lotto setBonusLotto(int bonusNumber) {
		List<Integer> winningLottoNumbers = new ArrayList<>(this.winningLotto.getNumbers());
		winningLottoNumbers.set(winningLottoNumbers.size() - 1, bonusNumber);
		return new Lotto(winningLottoNumbers);
	}
}
