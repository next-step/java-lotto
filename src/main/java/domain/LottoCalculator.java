package domain;

import java.util.List;

public class LottoCalculator {

	private static final Integer INIT_NUMBER = 0;
	private static final Integer PLUS_NUMBER = 1;
	private static final Integer CONTAINER_INIT_NUMBER = 7;

	private int[] container;

	public LottoCalculator() {
		container = new int[CONTAINER_INIT_NUMBER];
	}

	public int[] getResult(List<List<Integer>> lottoList, List<Integer> lottoWinningNumber) {
		validateLottoList(lottoList, lottoWinningNumber);
		return container;
	}

	private void validateLottoList(List<List<Integer>> lottoList, List<Integer> lottoWinningNumber) {
		for (int i = INIT_NUMBER ; i < lottoList.size() ; ++i) {
			container[numberOfMatches(lottoList.get(i), lottoWinningNumber)]++;
		}
	}

	private Integer numberOfMatches(List<Integer> lotto, List<Integer> lottoWinningNumber) {
		int sum = INIT_NUMBER;
		for (int i = INIT_NUMBER ; i < lotto.size() ; ++i) {
			sum += (lottoWinningNumber.contains(lotto.get(i)) ? PLUS_NUMBER : INIT_NUMBER);
		}
		return sum;
	}
}
