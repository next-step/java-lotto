import lotto.Statistics;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		inputView.input();

		Statistics statistics = new Statistics(inputView.prizeLotto());
		statistics.analyze(inputView.lottos());

		ResultView resultView = new ResultView();
		resultView.output(statistics);
	}
}
