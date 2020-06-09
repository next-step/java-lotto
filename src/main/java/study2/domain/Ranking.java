package study2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ranking {
	
	int matchedNumber;
	
	public enum Rank {
		SIXMATCH(6, 2_000_000_000), FIVEMATCH(5, 15_000_000), FOURMATCH(4, 50_000), THREEMATCH(3, 5_000), MISS(0, 0);

		 int countOfMatch;
		 int winningMoney;

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

	}

	public static List<String> winNumSplit(String inputWinNumber) {
		if (inputWinNumber.equals("") || inputWinNumber == null) {
			throw new IllegalArgumentException("공백이나 null은 안됩니다.");
		}
		
		return Arrays.stream(inputWinNumber.split(",")).collect(Collectors.toList());
	}

	public int matchNumber(List<Lotto> lottoNumbers, List<String> winningLotto) {
				
		lottoNumbers.forEach(lotto -> {
			matchedNumber = lotto.getRankWithWinningLotto(winningLotto);
		});
		
		return matchedNumber;
	}
}