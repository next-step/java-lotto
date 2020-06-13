package study2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import study2.domain.Lotto;
import study2.domain.Ranking;
import study2.domain.Ranking.Rank;

public class ResultView {

	private static final String rankMessages = "당첨 통계";
	private static final String dividMessages = "----------";
	public static final String MESSAGE_OF_LOTTO_RESULT = "%d개 일치 (%d원) - %d개";

	Long totalMoney = 0L;

	static Scanner scanner = new Scanner(System.in);
	Ranking rank = new Ranking();

	public void getOutputLottoNumbers(List<Lotto> lottoNumbers) {
		lottoNumbers.stream().map(Lotto::getNumbers).forEach(System.out::println);
	}

	public void outPutMessages(Map<Rank, List<Integer>> matchNumber, List<Lotto> lottoNumbers) {
		System.out.println(rankMessages);
		System.out.println(dividMessages);

		for (Rank rank : Rank.values()) {
			System.out.println(String.format(MESSAGE_OF_LOTTO_RESULT,
					rank.getCountOfMatch(),
					rank.getWinningMoney(),
					matchNumber.getOrDefault(rank, new ArrayList<>()).size()));
			
			totalMoney += rank.getWinningMoney() * matchNumber.getOrDefault(rank, new ArrayList<>()).size();
		}
		
		System.out.println("총 수익률은 "+totalMoney / (lottoNumbers.size() * 1000) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
	}

}
