import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Records;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

	private static int money;

	private static Lottos lottos;

	public static void main(String[] args) {
		buyLotto(InputView.inputMoney());

		ResultView.outputNewLine();
		Lotto winLotto = winLotto(InputView.inputWinLottoNumbers());
		ResultView.outputNewLine();

		Records records = lottos.toRevenueRecord().aggregate(winLotto);

		outputStatistics(records);
	}

	private static void buyLotto(int money) {
		LottoMain.money = money;
		LottoCount lottoCount = new LottoCount(money);

		ResultView.outputLottoCount(lottoCount.getLottoCount());
		LottoMain.lottos = Lottos.generateAutoLottos(lottoCount.getLottoCount());

		lottos.getLottos()
			.forEach(ResultView::outputLottoNumbers);
	}

	private static Lotto winLotto(String winLottoNumbers) {
		String[] stringLottoNumbers = winLottoNumbers.split(",");

		List<Integer> lottoNumbers = Arrays.stream(stringLottoNumbers)
										.map(String::trim)
										.mapToInt(Integer::parseInt)
										.boxed()
										.collect(Collectors.toList());

		return new Lotto(lottoNumbers);
	}

	private static void outputStatistics(Records records) {
		ResultView.outputStatisticsTitle();
		records.getRecords().forEach(ResultView::outputLottoNumbers);
		ResultView.outputYield(money, records.sumRevenue());
	}
}
