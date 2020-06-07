package study2.view;

import java.util.List;
import java.util.Scanner;

import study2.domain.Lotto;
import study2.domain.Ranking;
import study2.domain.Ranking.Rank;

public class ResultView {
	
	private static final String rankMessages ="당첨 통계";
	private static final String dividMessages = "----------";
	
	Ranking rank = new Ranking();
	static Scanner scanner = new Scanner(System.in);
	
	public void getOutputLottoNumbers(List<Lotto> lottoNumbers) {
		lottoNumbers.stream()
		.map(Lotto::getNumbers)
		.forEach(System.out::println);
	}
	
	public void outPutMessages() { 
		System.out.println(rankMessages);
		System.out.println(dividMessages);
	
		/*
		  System.out.println(
				  String.format( "총 수익률은 "+ a +"입니다.",
						  Rank.getCountOfMatch(),
						  Rank.getWinningMoney(),
		  );
		 */	
	}
	
	
}
