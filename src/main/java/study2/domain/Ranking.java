package study2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ranking {

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
	
	// List<Integer>말고 Integer로 반환할때
	// String -> Integer로 받을수있나요?
	public static Integer winNumSplit(String inputWinNumber) {
		if (inputWinNumber.equals("") || inputWinNumber == null) {
			throw new IllegalArgumentException("공백이나 null은 안됩니다.");
		}

		return inputWinNumber.trim()
				.replace(" ", "")
				.split(",")
				.stream()
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());
	}

	public Map<Rank, Integer> matchNumber(List<Lotto> lottos, Integer winningLotto) {

		Map<Rank, Integer> rankRepository = new HashMap<>();

		lottos.forEach(lotto -> {
			Rank rank = lotto.getRankWithWinningLotto(winningLotto);
			
			// Integer 이부분에서 카운트를 어떻게 하면좋을까요?
			Integer countOfRank = rankRepository
					.getOrDefault(rank, new ArrayList<>());
			countOfRank.add(1);

			rankRepository.put(rank, countOfRank);

		});
		
		return rankRepository;
	}

	public static Rank getRanking(int matchedNumber) {

		return Arrays.stream(Rank.values()).filter(rank -> rank.getCountOfMatch() == matchedNumber).findFirst()
				.orElse(Rank.MISS);

	}
}