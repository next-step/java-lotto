package domain;

import java.util.List;

public class Result {

	private static final Integer INIT_NUMBER = 0;
	private static final Integer PLUS_NUMBER = 1;
	private static final Integer CONTAINER_INIT_NUMBER = 7;

	private int[] container;

	public Result() {
		container = new int[CONTAINER_INIT_NUMBER];
	}

	public void viewResult(List<List<Integer>> lottoList, List<Integer> lottoWinningNumber) {
		firstComment();
		validateLottoList(lottoList, lottoWinningNumber);
		System.out.println("3개 일치 (5000원)-" + container[3]);
		System.out.println("4개 일치 (50000원)-" + container[4]);
		System.out.println("5개 일치 (1500000원)-" + container[5]);
		System.out.println("6개 일치 (2000000000원)-" + container[6]);
		System.out.println("총 수익률은 " + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
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


	private void firstComment() {
		System.out.println("당첨 통계");
		System.out.println("----------");
	}
}
