package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

	private final List<Lotto> purchasedLottos;

	public Lottos(List<Lotto> lottos) {
		this.purchasedLottos = lottos;
	}

	public static Lottos of(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public static Lottos of(List<Lotto>... lottos) {
		return new Lottos(Arrays.stream(lottos)
			.flatMap(Collection::stream)
			.collect(Collectors.toList())
		);
	}

	public List<String> lottoStrings() {
		return purchasedLottos.stream()
			.map(Lotto::toString)
			.collect(Collectors.toList());
	}

	public int getCount() {
		return purchasedLottos.size();
	}

	public Map<Reward, Integer> getRewardStatistic(WinningLotto winningLotto) {
		Map<Reward, Integer> rewardStatistic = new EnumMap<>(Reward.class);
		for (Lotto lotto : purchasedLottos) {
			Reward reward = Reward.getRewardByMatchCount(lotto.getMatchingCount(winningLotto.getNumbers()),
				lotto.hasBonusNumber(winningLotto.getBonusNumber()));
			rewardStatistic.put(
				reward,
				rewardStatistic.getOrDefault(reward, 0) + 1
			);
		}
		return rewardStatistic;
	}
}
