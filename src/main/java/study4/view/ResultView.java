package study4.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import study4.domain.Lotto;
import study4.domain.Ranking;
import study4.domain.Ranking.Rank;

public class ResultView {

	private static final String rankMessages = "당첨 통계";
	private static final String dividMessages = "---------------";
	private static final String MESSAGE_OF_LOTTO_RESULT = "%d개 일치 (%d원) - %d개";
	private static final String MESSAGE_OF_BONUS_BALL_RESULT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
	private static final int FOUR_PLUS_BONUS_MONEY = 30_000_000;
	
	Long totalMoney = 0L;

	static Scanner scanner = new Scanner(System.in);
	Ranking rank = new Ranking();

	public void getOutputLottoNumbers(List<Lotto> lottoNumbers) {
		lottoNumbers.stream().map(Lotto::getNumbers).forEach(System.out::println);
	}

	public void outPutMessages(Map<Rank, Integer> matchNumber, List<Lotto> lottoNumbers) {
		System.out.println(rankMessages);
		System.out.println(dividMessages);
		
		for (Rank rank : Rank.values()) {
			matchNumberIsNullPutZero(matchNumber, rank);
		}
		
		for (Rank rank : Rank.values()) {
			
			if(rank.getWinningMoney() == FOUR_PLUS_BONUS_MONEY) {
				System.out.println(String.format(MESSAGE_OF_BONUS_BALL_RESULT,
						rank.getCountOfMatch(),
						rank.getWinningMoney(),
						matchNumber.get(rank)));
			}
			if(rank.getWinningMoney() != FOUR_PLUS_BONUS_MONEY) {
			System.out.println(String.format(MESSAGE_OF_LOTTO_RESULT,
					rank.getCountOfMatch(),
					rank.getWinningMoney(),
					matchNumber.get(rank)));
			}			
			totalMoney += rank.getWinningMoney() * matchNumber.get(rank);
		}		
		System.out.println("총 수익률은 "+totalMoney / (lottoNumbers.size() * 1000) + "입니다.(기준이 1이기 때문에 넘으면 이득 낮으면 손해)");
	}
	
	// 매치가 없을때 0을 넣는다
	private void matchNumberIsNullPutZero(Map<Rank, Integer> matchNumber, Rank rank) {
		if(matchNumber.get(rank) == null) {
			matchNumber.put(rank, 0);
		}
	}

}
