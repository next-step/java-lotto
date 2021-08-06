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

	private static LottoCount lottoCount;

	public static void main(String[] args) {

		money = InputView.inputMoney();
		lottoCount = new LottoCount(money);

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
