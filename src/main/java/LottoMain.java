import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Records;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

	private static int money;

	public static void main(String[] args) {
		this.money = InputView.inputMoney();
		int lottoCount = money/1000;

		ResultView.outputLottoCount(lottoCount);

		Lottos lottos = Lottos.generateAutoLottos(lottoCount);

		lottos.getLottos()
			.forEach(ResultView::outputLottoNumbers);

		String winLottoNumbers = InputView.inputWinLottoNumbers();

		List<Integer> lottoNumbers = Arrays.stream(winLottoNumbers.split(","))
			.map(String::trim)
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());

		Lotto winLotto = new Lotto(lottoNumbers);

		Records records = lottos.toRevenueRecord().aggregate(winLotto);

		records.getRecords().forEach((key, value) -> System.out.println(key.getMatchNumberCount() + "개 일치 (" + key.getReward() + ") - " + value + "개"));

		System.out.println(records.sumRevenue());
	}
}
