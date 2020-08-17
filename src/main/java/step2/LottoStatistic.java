package step2;

import java.util.*;
import java.util.stream.Collectors;

// 수익률 = 수익 / 실 투자금액 * 100
public class LottoStatistic {
	private final List<Integer> winningNumbers;
	private static final Map<Integer, Integer> lottoStat = new HashMap<>();

	public LottoStatistic(List<Integer> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public Map<Integer, Integer> calcLottoResult(List<Integer[]> lottoResult) {
		for (int i = 0; i < lottoResult.size(); i++) {
			calcWinningNumberCount(lottoResult.get(i));
		}
		return lottoStat;
	}

	private void calcWinningNumberCount(Integer[] lotto) {
		int count = 0;
		for (Integer winningNumber : winningNumbers) {
			count += Arrays.stream(lotto).filter(number -> number.equals(winningNumber)).collect(Collectors.toList()).size();
		}
		lottoStat.put(count, lottoStat.getOrDefault(count, 0)+1);
	}

}
