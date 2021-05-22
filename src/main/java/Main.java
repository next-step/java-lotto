import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		inputView.input();
		ResultView resultView = new ResultView();
		resultView.output(inputView.lottos());
	}
}
