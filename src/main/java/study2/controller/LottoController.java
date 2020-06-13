package study2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import study2.domain.Lotto;
import study2.domain.LottoNumbers;
import study2.domain.Ranking;
import study2.domain.Ranking.Rank;
import study2.view.InputView;
import study2.view.ResultView;

public class LottoController {
	public static void main(String[] args) {
		
		LottoNumbers lottonumbers = new LottoNumbers();
		List<Lotto> lottoNumbersList = new ArrayList<Lotto>();
		ResultView resultview = new ResultView();
		Ranking rank = new Ranking();
		Map<Rank, List<Integer>> matchNumber;
		
		int price = InputView.initMessages();
		lottoNumbersList = lottonumbers.getLottoNumbers(InputView.inputNumberMessages(price));
		resultview.getOutputLottoNumbers(lottoNumbersList); // 리스트 출력
		
	//	lottonumbers.createLottoNumbers(lottoNumbersList); // 사용되진 않지만 주석처리 해놓겠습니다.
		
		// 지난 주 당첨 번호 입력
		List<Integer> winNumber = rank.winNumSplit(InputView.rankMessages());
		matchNumber =rank.matchNumber(lottoNumbersList, winNumber);
		
		resultview.outPutMessages(matchNumber, lottoNumbersList);
		
	}
}
