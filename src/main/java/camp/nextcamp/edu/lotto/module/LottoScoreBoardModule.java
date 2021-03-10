package camp.nextcamp.edu.lotto.module;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoNumber;
import camp.nextcamp.edu.lotto.entity.LottoTicket;

public class LottoScoreBoardModule {

	private LottoScoreBoardModule() {
	}

	private static class LazyHolder {
		static final LottoScoreBoardModule INSTANCE = new LottoScoreBoardModule();
	}

	public static LottoScoreBoardModule getInstance() {
		return LottoScoreBoardModule.LazyHolder.INSTANCE;
	}

	private int getIntersectionCount(Set<LottoNumber> input, Set<LottoNumber> winning) {
		return input.stream()
			.filter(winning::contains)
			.collect(Collectors.toSet())
			.size();
	}

	public WinningScore getWinningScore(Lotto input, Lotto winning) {
		int intersectionCount = getIntersectionCount(input.getNumbers(), winning.getNumbers());

		return WinningScore.getInstance(intersectionCount);
	}

	public Map<WinningScore, Long> getWinningScoreBoard(List<Lotto> lottos, Lotto winning) {
		Map<WinningScore, Long> countByScore = lottos.stream()
			.map((lotto) -> getWinningScore(lotto, winning))
			.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));

		WinningScore.getAllExactWinningCount(countByScore)
			.forEach(key -> countByScore.put(key, 0L));

		return countByScore;
	}

	public double getProfit(Map<WinningScore, Long> winningScore, LottoTicket lottoTicket) {
		int purchasedMoney = lottoTicket.getMoney();
		long winningMoney = 0;
		for (WinningScore key : winningScore.keySet()) {
			Long value = winningScore.get(key);
			winningMoney += key.getPrice() * value;
		}
		return (double) winningMoney / purchasedMoney;
	}
}
