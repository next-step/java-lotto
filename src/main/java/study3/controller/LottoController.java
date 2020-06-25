package study3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import study3.domain.Lotto;
import study3.domain.Lottos;
import study3.domain.Ranking;
import study3.domain.Ranking.Rank;
import study3.view.InputView;
import study3.view.ResultView;

public class LottoController {
	public static void main(String[] args) {
		
		Lottos lottonumbers = new Lottos();
		ResultView resultview = new ResultView();
		Ranking rank = new Ranking();
		
		int price = InputView.enterPriceMessage();
		List<Lotto> lottos = lottonumbers.getLottoNumbers(InputView.inputNumberMessages(price));
		resultview.getOutputLottoNumbers(lottos); // 리스트 출력
		
		// 지난 주 당첨 번호 입력
		List<Integer> winNumber = Lottos.winNumSplit(InputView.rankMessages());
		
		int bonusBall = InputView.enterBonusBallMessage();
				
		Map<Rank, Integer> matchNumber = rank.matchNumber(lottos, winNumber, bonusBall);
				
		resultview.outPutMessages(matchNumber, lottos);		
	}
}
