package study2.controller;

import java.util.ArrayList;
import java.util.List;

import study2.domain.Lotto;
import study2.domain.LottoNumbers;
import study2.domain.Ranking;
import study2.view.InputView;

public class LottoController {
	public static void main(String[] args) {
		
		LottoNumbers lottonumbers = new LottoNumbers();
		List<Lotto> lottoNumbersList = new ArrayList<Lotto>();
		Ranking rank = new Ranking();
		
		int price = InputView.initMessages();
		lottoNumbersList = lottonumbers.getLottoNumbers(InputView.inputNumberMessages(price));
		
	//	lottonumbers.createLottoNumbers(lottoNumbersList); // 사용되진 않지만 주석처리 해놓겠습니다.
		
		String winner = InputView.rankMessages();
		
		
	}
}
