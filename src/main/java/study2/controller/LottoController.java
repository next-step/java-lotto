package study2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import study2.domain.Lotto;
import study2.domain.Lottos;
import study2.domain.Ranking;
import study2.domain.Ranking.Rank;
import study2.view.InputView;
import study2.view.ResultView;

public class LottoController {
	public static void main(String[] args) {
		
		Lottos lottonumbers = new Lottos();
		List<Lotto> lottos = new ArrayList<Lotto>();
		ResultView resultview = new ResultView();
		Ranking rank = new Ranking();
		Map<Rank, Integer> matchNumber;
		
		int price = InputView.enterPriceMessage();
		lottos = lottonumbers.getLottoNumbers(InputView.inputNumberMessages(price));
		resultview.getOutputLottoNumbers(lottos); // 리스트 출력
		
		// 지난 주 당첨 번호 입력
		List<Integer> winNumber = lottonumbers.winNumSplit(InputView.rankMessages());
		
		matchNumber = rank.matchNumber(lottos, winNumber);
		
		resultview.outPutMessages(matchNumber, lottos);
		
	}
}
