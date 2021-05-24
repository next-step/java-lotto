import interaction.InputView;
import interaction.OutputView;
import lotto.LottoNumbers;
import lotto.generator.Generator;
import lotto.generator.MessageLottoNumberGenerator;
import lotto.statistics.StatisticsCalculator;
import lotto.store.Budget;
import lotto.store.LottoStore;
import lotto.store.Ticket;

public class LottoGameManager {

	private static final int LOTTO_PRICE_PER = 1_000;

	public static void main(String[] args) {
		Ticket lottPurchaseTicket = purchaseLotto();
		OutputView.sendMessage(lottPurchaseTicket.toString());
		LottoNumbers winningLotto = winningLotto();
		calculate(lottPurchaseTicket, winningLotto);
	}

	private static Ticket purchaseLotto() {
		Budget budget = InputView.budgetLottoPrice();
		LottoStore store = new LottoStore(budget, LOTTO_PRICE_PER);
		OutputView.purchaseCountResult(store.purchaseCount());
		return store.produceLotto();
	}

	private static LottoNumbers winningLotto() {
		String winningLottoMessage = InputView.winningLottoNumberMessage();
		Generator winningLottoGenerator = new MessageLottoNumberGenerator(winningLottoMessage);
		return winningLottoGenerator.generate();
	}

	private static void calculate(Ticket purchased, LottoNumbers winning) {
		StatisticsCalculator calculator = new StatisticsCalculator(purchased, winning);
		OutputView.sendMessage(calculator.toString());
	}

}
