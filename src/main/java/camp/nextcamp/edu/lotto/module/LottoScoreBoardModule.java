package camp.nextcamp.edu.lotto.module;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoTicket;
import camp.nextcamp.edu.lotto.entity.WinningLotto;

public class LottoScoreBoardModule {

	private LottoScoreBoardModule() {
	}

	private static class LazyHolder {
		static final LottoScoreBoardModule INSTANCE = new LottoScoreBoardModule();
	}

	public static LottoScoreBoardModule getInstance() {
		return LottoScoreBoardModule.LazyHolder.INSTANCE;
	}

	public Map<WinningScore, Long> getWinningScoreBoard(List<Lotto> lottos, WinningLotto winning) {
		Map<WinningScore, Long> countByScore = lottos.stream()
			.map(winning::getWinningScore)
			.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));

		WinningScore.getAllExactWinningCount(countByScore)
			.forEach(key -> countByScore.put(key, 0L));

		return countByScore;
	}

	public double getProfit(Map<WinningScore, Long> winningScore, LottoTicket lottoTicket) {
		int purchasedMoney = lottoTicket.getMoney();
		long winningMoney = 0;
		for (WinningScore key : winningScore.keySet()) {
			long value = winningScore.get(key);
			winningMoney += key.getPrice() * value;
		}
		return (double) winningMoney / purchasedMoney;
	}
}
