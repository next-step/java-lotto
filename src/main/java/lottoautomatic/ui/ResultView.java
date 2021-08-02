package lottoautomatic.ui;

import lottoautomatic.domain.Lotto;
import lottoautomatic.domain.LottoProfit;
import lottoautomatic.domain.LottoResult;
import lottoautomatic.domain.Lottos;

import java.util.List;
import java.util.Map;

public class ResultView {

	private static final String TICKET_RESULT = "개를 구매했습니다.";
	private static final String MATCH_RESULT = "\n당첨 통계";
	private static final String DIVISION_LINE = "--------";
	private static final String MATCH_FOR_EACH_MESSAGE = "%d개 일치 (%d원) - %d개%n";
	private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n";

	private final Lottos lottos;

	public ResultView(Lottos lottos) {
		this.lottos = lottos;
	}

	public void printLottos() {
		System.out.printf("%d%s%n", lottos.size(), TICKET_RESULT);
		for (Lotto lotto : lottos.toList()) {
			System.out.println(lotto);
		}
		System.out.println();
	}


	public void printResult(List<Integer> winningNumbers) {
		System.out.println(MATCH_RESULT);
		System.out.println(DIVISION_LINE);

		LottoResult lottoResult = new LottoResult(lottos);
		lottoResult.match(winningNumbers);

		printResultEach(lottoResult.value());
		printResultRate(lottoResult);

	}

	private void printResultRate(LottoResult lottoResult) {
		System.out.printf(PROFIT_RATE_MESSAGE, lottoResult.rate());
	}

	private void printResultEach(Map<LottoProfit, Integer> match) {
		for (Map.Entry<LottoProfit, Integer> profit : match.entrySet()) {
			System.out.printf(MATCH_FOR_EACH_MESSAGE, profit.getKey().getQuantity(), profit.getKey().getProfitUnit(), profit.getValue());
		}
	}

}
