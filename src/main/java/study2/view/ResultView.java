package study2.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import study2.domain.Lotto;
import study2.domain.Ranking;
import study2.domain.Ranking.Rank;

public class ResultView {
	
	private static final String rankMessages ="당첨 통계";
	private static final String dividMessages = "----------";
	 public static final String MESSAGE_OF_LOTTO_RESULT = "%d개 일치 (%d원) - %d개";
	
	Ranking rank = new Ranking();
	static Scanner scanner = new Scanner(System.in);
	
	public void getOutputLottoNumbers(List<Lotto> lottoNumbers) {
		lottoNumbers.stream()
		.map(Lotto::getNumbers)
		.forEach(System.out::println);
	}
	
	public void outPutMessages(Map<Rank, Integer> matchNumber, List<Lotto> lottoNumbers) { 
		System.out.println(rankMessages);
		System.out.println(dividMessages);
	
		/*
		 * for(Rank ranks : rank.values()) { System.out.println( String.format(
		 * MESSAGE_OF_LOTTO_RESULT, rank.getCountOfMatch(), rank.getWinningMoney(), 1)
		 * 
		 * ); }
		 */
		
		  
		 	
	}
	
	
}
