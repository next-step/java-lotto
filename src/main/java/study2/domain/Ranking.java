package study2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
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

	public static List<Integer> winNumSplit(String inputWinNumber) {
		if (inputWinNumber.equals("") || inputWinNumber == null) {
			throw new IllegalArgumentException("공백이나 null은 안됩니다.");
		}

		return Arrays.asList(inputWinNumber
				.split(","))
				.stream()
				.mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());

	}

	public Rank matchNumber(List<Lotto> lottoNumbers, List<Integer> winningLotto) {
		
		// 질문을 다시드려야 될것같아요!
		// rank를 담는 배열을 생성하는편이 좋을까요?
		
		lottoNumbers.forEach(lotto -> {
			Rank rank = lotto.getRankWithWinningLotto(winningLotto);
			
		});
				
		return rank;
	}

	public static Rank getRanking(int matchedNumber) {
		
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.getCountOfMatch() == matchedNumber)
				.findFirst()
				.orElse(Rank.MISS);

	}
}