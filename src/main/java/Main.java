import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.Lottos;
import lotto.Money;
import lotto.Prize;
import lotto.Statistics;
import lotto.Store;
import lotto.dto.LottoDto;
import lotto.dto.PrizeDto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {
	private static final InputView inputView = new InputView();
	private static final ResultView resultView = new ResultView();

	public static void main(String[] args) {
		long amount = inputView.askAmount();
		Lottos lottos = Store.buy(new Money(amount));

		List<LottoDto> lottoDtos = createLottoDtos(lottos);
		resultView.printNumbers(lottoDtos);

		List<Integer> prizeNumbers = inputView.askPrizeNumbers();
		int bonusNumber = inputView.askBonusNumber();
		Statistics statistics = lottos.statistics(prizeNumbers, bonusNumber);

		List<PrizeDto> prizeDtos = createPrizeDtos(statistics);
		resultView.output(prizeDtos);
		resultView.outputProfit(Prize.profit(statistics).rate());
	}

	private static List<PrizeDto> createPrizeDtos(Statistics statistics) {
		List<PrizeDto> prizeDtos = new ArrayList<>();
		List<Prize> prizes = new ArrayList<>(Arrays.asList(Prize.values()));
		prizes.remove(Prize.NOTHING);
		for (Prize value : prizes) {
			prizeDtos.add(new PrizeDto(value, statistics.status(value)));
		}
		return prizeDtos;
	}

	static List<LottoDto> createLottoDtos(Lottos lottos) {
		List<LottoDto> lottoDtos = new ArrayList<>();
		for (List<Integer> numbers : lottos.allNumbers()) {
			lottoDtos.add(new LottoDto(numbers));
		}
		Collections.reverse(lottoDtos);
		return lottoDtos;
	}
}
