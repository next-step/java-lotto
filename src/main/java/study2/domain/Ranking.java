package study2.domain;

import java.util.Arrays;
import java.util.List;

public class Ranking {

	public enum Rank {
		SIXMATCH(6, 2_000_000_000), FIVEMATCH(5, 15_000_000), FOURMATCH(4, 50_000), THREEMATCH(3, 5_000), MISS(0, 0);

		private int countOfMatch;
		private int winningMoney;

		private Rank(int countOfMatch, int winningMoney) {
			this.countOfMatch = countOfMatch;
			this.winningMoney = winningMoney;
		}

		public int getCountOfMatch() {
			return countOfMatch;
		}

		public int getWinningMoney() {
			return winningMoney;
		}

	};

	public static int[] winNumSplit(String inputWinNumber) {
		if (inputWinNumber.equals("") || inputWinNumber == null) {
			throw new IllegalArgumentException("공백이나 null은 안됩니다.");
		}

		return Arrays.stream(inputWinNumber.split(","))
				.mapToInt(Integer::parseInt).toArray();
	}

	public void matchNumber(List<Lotto> lottoNumbersList, int[] winNumber) {
		int count = 0;

		// 이부분에 대한 힌트 및 feedback 부탁드리겠습니다. ㅠ
		// 메소드 분리를 사용하면 인자가 4개가 되버리는 어려움 상황에있습니다.
		// 이부분에 떄문에 추가적으로 진도가 너무 못나가고 있어서 중간 리뷰요청드리겠습니다. ㅜㅜ

		for (int i = 0; i < lottoNumbersList.size(); i++) {
			for (int j = 0; j < winNumber.length; j++) {
				if (lottoNumbersList.get(i).getNumbers().contains(winNumber[j])) {
					count++;
				}
			}
			System.out.println(i + 1 + "번쨰의 로또의  일치수는" + count);
			count = 0;
		}
	}
}