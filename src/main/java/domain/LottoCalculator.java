package domain;

import java.util.List;

public class LottoCalculator {

	private static final Integer INIT_NUMBER = 0;
	private static final Integer CONTAINER_INIT_NUMBER = 7;

	private int[] container;

	public LottoCalculator() {
		container = new int[CONTAINER_INIT_NUMBER];
	}

	public int[] getResult(List<Lotto> lottoList,Lotto lottoWinningNumber) {
		validateLottoList(lottoList, lottoWinningNumber);
		return container;
	}

	private void validateLottoList(List<Lotto> lottoList, Lotto lottoWinningNumber) {
		for (int number = INIT_NUMBER ; number < lottoList.size() ; ++number) {
			container[numberOfMatches(lottoList.get(number), lottoWinningNumber)]++;
		}
	}

	private Integer numberOfMatches(Lotto lotto, Lotto lottoWinningNumber) {
		return Lotto.numberOfMatches(lotto, lottoWinningNumber);
	}
}
