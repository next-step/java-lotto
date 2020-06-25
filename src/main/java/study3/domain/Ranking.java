package study3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import study2.domain.Ranking.Rank;

public class Ranking {

	public enum Rank {
		SIXMATCH(6, 2_000_000_000), 
		FOURPLUSBONUS(5, 30_000_000),
		FIVEMATCH(5, 15_000_000),
		FOURMATCH(4, 50_000),
		THREEMATCH(3, 5_000),
		MISS(0, 0);

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
	
	public Map<Rank, Integer> matchNumber(List<Lotto> lottos, List<Integer> winningLotto, int bonusBall) {
		Map<Rank, Integer> rankRepository = new HashMap<>();

		lottos.forEach(lotto -> {
			boolean bonusBallFlag = lotto.lottoContainsBonusBall(bonusBall);
			
			Rank rank = lotto.getRankWithWinningLotto(winningLotto, bonusBallFlag);
						
			/* TODO 잠시 주석처리입니다.
			 * if(rank == Rank.FOURMATCH && bonusBallFlag) {
			 * rankRepository.put(rank.FIVEPLUSBONUS, rankRepository
			 * .getOrDefault(rank.FIVEPLUSBONUS, 0) +1); rankRepository.put(rank,
			 * rankRepository .getOrDefault(rank, 0) -1); }
			 */ 
			
			rankRepository.put(rank, rankRepository
					.getOrDefault(rank, 0) +1);			
		});
		return rankRepository;
	}

	public static Rank getRanking(int matchedNumber, Boolean bonusBallFlag) {
		
		if(bonusBallFlag && matchedNumber == Rank.FOURMATCH.countOfMatch) {
			return Rank.FOURPLUSBONUS;
		}
		
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.winningMoney != Rank.FOURPLUSBONUS.winningMoney)
				.filter(rank -> rank .getCountOfMatch() == matchedNumber)
				.findFirst()
				.orElse(Rank.MISS);
	}
	
	
}