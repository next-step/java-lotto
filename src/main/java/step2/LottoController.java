package step2;

import java.util.List;

public class LottoController {
	public static void main(String[] args) {
		int price = InputView.inputPrice();
		int lottoCount = LottoIssuer.getLottoCountByPrice(price);

		List<Integer[]> lottos = LottoIssuer.issueAutoLottos(lottoCount);
		ResultView.printLottos(lottos);

		List<Integer> winningNumbers = InputView.inputWinningNumbers();
		LottoStatistic statistic = new LottoStatistic(winningNumbers);
		ResultView.printWinningResult(statistic.calcLottoResult(lottos));
		ResultView.printYield(statistic.calcYield(price));
	}
}
